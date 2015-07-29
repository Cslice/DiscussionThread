/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package posts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import login.FileIO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author cameronthomas
 */
public class NewThread {
    public void AddThread(String threadName, String creator)
    {
        JSONObject finalJsonObj = null;
        ArrayList<String> tempArrayList = new ArrayList();
        ArrayList<ArrayList<String>> threadList = null;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
        
        // Add new thread elements to array
        tempArrayList.add(threadName);
        tempArrayList.add(creator);
        tempArrayList.add(dateFormat.format(date));     
        
        // When there are existing threads
        if(new FileIO().readFile("threads.json") != null)
            threadList = new GetThreadsAndPosts().getThreadsArray("threads");
        else
            threadList = new ArrayList<ArrayList<String>>();
            
        // Add new thread to list
        threadList.add(0, tempArrayList);
        
        // Convert thread array list to JSON object
        finalJsonObj = this.convertArrayListToJSON(threadList);
           
        // Write JSON object to file     
        new FileIO().writeFile("threads.json", finalJsonObj.toString());      
    }
    
    public JSONObject convertArrayListToJSON(ArrayList<ArrayList<String>> threadList)
    {
        JSONObject tempJsonObj = null; 
        JSONArray tempJsonArray = new JSONArray();
        JSONObject finalJsonObj = new JSONObject();
             
        // Add existing threads to list
        for(ArrayList thread: threadList)
        {
            // Create JSON object and add thread elements to object
            tempJsonObj = new JSONObject(); 
            tempJsonObj.put("threadName", thread.get(0));
            tempJsonObj.put("creator", thread.get(1));
            tempJsonObj.put("dateCreated", thread.get(2));

            // Add JSON object to list
            tempJsonArray.add(tempJsonObj);
        }
        
        // Nest threads array in threads element
        finalJsonObj.put("threads", tempJsonArray);
        
        return finalJsonObj;
    }
}

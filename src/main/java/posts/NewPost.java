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
public class NewPost {
    public void addPost(String threadName, String postData, String author)
    {
        JSONObject finalJsonObj = null;
        ArrayList<String> tempArrayList = new ArrayList();
        ArrayList<ArrayList<String>> postList = null;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
        
        // Add new post elements to array
        tempArrayList.add(postData);
        tempArrayList.add(author);
        tempArrayList.add(dateFormat.format(date)); 
        
        if(new FileIO().readFile(threadName + ".json") != null)
        {
            postList = new GetThreadsAndPosts().getPostArray(threadName);
            //System.out.println("asdfs");
        }
        else
            postList = new ArrayList<ArrayList<String>>();
        
        // Add new post to list
        postList.add(0, tempArrayList);

        // Convert post array list to JSON object
        finalJsonObj = this.convertArrayListToJSON(postList);
        
        System.out.println(finalJsonObj.toString());
        
        // Write JSON object to file     
        new FileIO().writeFile(threadName + ".json", finalJsonObj.toString());     
    }
    
    public JSONObject convertArrayListToJSON(ArrayList<ArrayList<String>> postList)
    {
        JSONObject tempJsonObj = null; 
        JSONArray tempJsonArray = new JSONArray();
        JSONObject finalJsonObj = new JSONObject();
             
        // Add existing threads to list
        for(ArrayList post: postList)
        {
            // Create JSON object and add post elements to object
            tempJsonObj = new JSONObject(); 
            tempJsonObj.put("postData", post.get(0));
            tempJsonObj.put("creator", post.get(1));
            tempJsonObj.put("dateCreated", post.get(2));

            // Add JSON object to list
            tempJsonArray.add(tempJsonObj);
        }
        
        // Nest threads array in threads element
        finalJsonObj.put("posts", tempJsonArray);
 
        return finalJsonObj;
    }  
}

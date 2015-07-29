/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package posts;

import java.util.ArrayList;
import java.util.HashMap;
import login.FileIO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author cameronthomas
 */
public class GetThreadsAndPosts {
    public ArrayList getThreadsArray(String threadName)
    {      
        ArrayList<ArrayList<String>> threadsArray = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList = null;
        
        Object obj = new FileIO().readFile("threads.json");
        
        // Thread file exist
        if(obj != null)
        {
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray userArray = (JSONArray)jsonObject.get("threads");
            JSONObject jsonThread = null;

            for(Object user: userArray)
            {
                jsonThread = (JSONObject)user;
                tempList = new ArrayList<String>();

                tempList.add(jsonThread.get("threadName").toString());
                tempList.add(jsonThread.get("creator").toString());
                tempList.add(jsonThread.get("dateCreated").toString());

                threadsArray.add(tempList);      
            }
        }
        
        // Thread file doesn't exist
        else
            threadsArray = null;
        
        return threadsArray;
    }
    public ArrayList<ArrayList<String>> getPostArray(String threadName)
    {
        ArrayList<ArrayList<String>> postsArray = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList = null;

        Object obj = new FileIO().readFile(threadName + ".json");
        
        System.out.println(obj == null);
        
        // Posts file exist
        if(obj != null)
        {
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray userArray = (JSONArray)jsonObject.get("posts");
            JSONObject jsonPost = null;
            
            for(Object post: userArray)
            {
                jsonPost = (JSONObject)post;
                tempList = new ArrayList<String>();
                
                tempList.add(jsonPost.get("postData").toString());
                tempList.add(jsonPost.get("creator").toString());
                tempList.add(jsonPost.get("dateCreated").toString());
                postsArray.add(tempList);   
                
                //System.out.println(tempList);
            }
            
            //System.out.println(postsArray.toString());
        }
        else
            postsArray = null;
      
        return postsArray;
    }     
}

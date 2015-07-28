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
        String data = "{\"threads\":"
	+ "["  +
		"{\"threadName\":\"Test thread\", \"creator\":\"cameron\",  \"dateCreated\": \"Jul 27, 2015\"}," 
		+ "{\"threadName\":\"Test thread2\", \"creator\":\"camasdfsdfsdferon\",  \"dateCreated\": \"Jul , 2015\"}]}";
	

//        data = data.replaceAll("'", "\"");
       // Object tempObject = new FileIO().readFile(threadName + ".json");
       // new FileIO().writeFile("test.json", data);
        
        ArrayList<ArrayList<String>> threadsArray = new ArrayList<ArrayList<String>>();
        ArrayList<String> tempList = null;
        Object obj = new FileIO().readFile(threadName + ".json");
        //System.out.println(System.getProperty("user.dir"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray userArray = (JSONArray)jsonObject.get("threads");
        JSONObject jsonThread;
                   
        for(Object user: userArray)
        {
            jsonThread = (JSONObject)user;
            tempList = new ArrayList<String>();

            tempList.add(jsonThread.get("threadName").toString());
            tempList.add(jsonThread.get("creator").toString());
            tempList.add(jsonThread.get("dateCreated").toString());
            
            threadsArray.add(tempList);      
        }
        
        return threadsArray;
    }
    public ArrayList<HashMap<String, String>> getPostArray(String threadName)
    {
        ArrayList<HashMap<String, String>> postsArray = new ArrayList();

        return postsArray;
    }     
}

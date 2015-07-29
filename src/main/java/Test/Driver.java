/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import java.util.ArrayList;
import java.util.HashMap;
import login.FileIO;
import posts.GetThreadsAndPosts;
import posts.NewPost;
import posts.NewThread;

/**
 *
 * @author cameronthomas
 */
public class Driver {
    String glassFishFilePath = "/Applications/NetBeans/glassfish-4.0/glassfish/domains/domain1/config/";

    public static void main(String[] args)
    {
        Driver driver = new Driver();
        //driver.testAddThread();
        //driver.testGetThreadsAndPosts("threads");
        //driver.testGetPost("subject");
        //driver.testNewPost();
        driver.testDeleteFile("threads");
    }  
    
    public void testGetThreads(String threadName)
    {
        ArrayList<ArrayList<String>> threadList = new GetThreadsAndPosts().getThreadsArray("threads");

        for(ArrayList<String> thread: threadList)
        {

            for(String threadItem: thread)
            {
               System.out.println(threadItem); 
            }
        }
    }
    
    public void testAddThread()
    {
        new NewThread().AddThread("new thread", "me");    
    }
    
    public void testGetPost(String threadName)
    {
        ArrayList temp = new GetThreadsAndPosts().getPostArray(glassFishFilePath + threadName);
        
        System.out.println(temp.toString());
    }
    
    public void testNewPost()
    {
        new NewPost().addPost(glassFishFilePath + "subject", "postData", "author");
    }
    
    public void testDeleteFile(String fileName)
    {
        fileName = glassFishFilePath + fileName;
        String postFileName = "";
        //System.out.println(fileName);
        ArrayList<ArrayList<String>> threadList = new GetThreadsAndPosts().getThreadsArray(fileName);

        // Delete post files
         for(ArrayList<String>thread: threadList)
         {
             System.out.println(thread.get(0));
             postFileName = glassFishFilePath + thread.get(0) + ".json";
             if(new FileIO().readFile(postFileName) != null)
                new FileIO().deleteFile(postFileName);             
         }
         
        fileName = glassFishFilePath + fileName;
        
    }
}

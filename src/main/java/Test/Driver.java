/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import java.util.ArrayList;
import java.util.HashMap;
import posts.GetThreadsAndPosts;

/**
 *
 * @author cameronthomas
 */
public class Driver {
    public static void main(String[] args)
    {
        new Driver().testGetThreadsAndPosts();
    }  
    
    public void testGetThreadsAndPosts()
    {
        String threadName = "test";
        ArrayList<ArrayList<String>> threadList = new GetThreadsAndPosts().getThreadsArray(threadName);

        for(ArrayList<String> thread: threadList)
        {

            for(String threadItem: thread)
            {
               System.out.println(threadItem); 
            }
        }
    }
}

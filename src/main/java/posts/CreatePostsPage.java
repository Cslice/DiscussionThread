/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package posts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cameronthomas
 */
public class CreatePostsPage {
    public void createPostPage(HttpServletRequest request, HttpServletResponse response)
    {
        String threadName = request.getParameter("threadName");
        String username = request.getParameter("username");
        ArrayList<ArrayList<String>> postList = new GetThreadsAndPosts().getPostArray(threadName);

        request.setAttribute("threadName", threadName);
        request.setAttribute("postList", postList);
        request.setAttribute("username", username);
            
        try {                               
            request.getRequestDispatcher("viewPosts.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CreatePostsPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreatePostsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

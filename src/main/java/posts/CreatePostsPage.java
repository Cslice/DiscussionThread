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
        
        String deletePostsButtonHtml = "<a href=\"DeletePosts?threadName=" + threadName +
                "&username=" + username + "\">"
                + "<button type=\"button\" class=\"btn btn-danger\">Delete All Posts For Thread</button>"
                + "</a>";
        String noPostsLabel = "<h3>No Threads On Page</h3>";
        
        ArrayList<ArrayList<String>> postList = new GetThreadsAndPosts().getPostArray(threadName);
        
        if(postList != null)
        {
            request.setAttribute("deleteButton", deletePostsButtonHtml);
            request.setAttribute("noPostsLabel", "");

        }
        else
        {
            request.setAttribute("deleteButton", "");
            request.setAttribute("noPostsLabel", noPostsLabel);

        }

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

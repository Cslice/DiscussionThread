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
public class CreateThreadPage {
    public void createThreadPage(HttpServletRequest request, HttpServletResponse response)
    {
        String username = request.getParameter("username");
        String deleteThreadsButtonHtml = "<a href=\"DeleteThreads?username=" + username + "\">"
                + "<button type=\"button\" class=\"btn btn-danger\">Delete All Threads</button>"
                + "</a>";
        String noThreadsLabel = "<h3>No Threads On Page</h3>";
                
        try {     
            ArrayList<ArrayList<String>> threadList = new GetThreadsAndPosts().getThreadsArray("threads");
            
            if(threadList != null)
            {
                request.setAttribute("deleteButton", deleteThreadsButtonHtml);
                request.setAttribute("noThreadsLabel", "");
            }
            else
            {
                request.setAttribute("deleteButton", "");
                request.setAttribute("noThreadsLabel", noThreadsLabel);
            }

            request.setAttribute("threadList", threadList);
            request.setAttribute("username", username);      
            request.getRequestDispatcher("discussionBoardHomepage.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CreateThreadPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateThreadPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

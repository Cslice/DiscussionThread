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

        try {     
            ArrayList<ArrayList<String>> threadList = new GetThreadsAndPosts().getThreadsArray("threads");
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

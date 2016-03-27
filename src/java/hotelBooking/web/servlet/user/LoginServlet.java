/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelBooking.web.servlet.user;

import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author spanda2
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginTabStyle", "active");
        String nextJSP = "/Views/User/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginTabStyle", "active");
        String nextJSP = "/Views/User/login.jsp";
        
        String errorText = "";
        
        UserCredential cred = new UserCredential();
        
        cred.setPassword(request.getParameter("password"));
        cred.setUserID(request.getParameter("userID"));
        
        if(UserService.authenticate(cred))
        {
            nextJSP = "/Views/User/userList.jsp";
            ArrayList<User> users = UserService.findUser();
            if(users!=null)
            {
                request.setAttribute("userList", users);
                request.setAttribute("userCount", users.size());
            }
        
        }
        else
        {
            errorText += "\n Bad Credentials";
            request.setAttribute("error", errorText);
        }
            
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }
}

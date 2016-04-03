/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelBooking.web.servlet.user;

import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.jdbc.UserDBHandler;
import hotelBooking.core.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author spanda2
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginTabStyle", "active");
        String nextJSP = "/Views/User/login.jsp";
       
        
        String nextServlet = request.getParameter("referer");
        request.setAttribute("referer", nextServlet);
        //request.setAttribute("error", nextServlet);
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
        
        String nextServlet = request.getParameter("referer");
        request.setAttribute("referer", nextServlet);
        //
        if(UserService.authenticate(cred))
        {
            
            User u = UserService.findUser(cred.getUserID());
            HttpSession session = request.getSession(true);
            session.setAttribute("user", u);
            
            //String nextServlet = request.getParameter("referer");
            //nextServlet = "../admin/view";
            ArrayList<User> users = UserService.findUser();
            if(users!=null)
            {
                
                request.setAttribute("userList", users);
                request.setAttribute("userCount", users.size());
            }
            
            if(nextServlet!= null)
                response.sendRedirect(nextServlet);
            else
            {
                response.sendRedirect("../..");
            }
            
        }
        else
        {
            
            UserDBHandler db = new UserDBHandler();
            try {
                db.checkConnection();
                db.closeConnection();
                errorText += "\n Bad Credentials";
            } catch (ClassNotFoundException ex) {
                errorText += "Could'nt connect to the Database";
            } catch (SQLException ex) {
                errorText += "Some unknown error occured";
            }
            
            request.setAttribute("error", errorText);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
            
       
        
    }
}

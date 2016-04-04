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
import java.text.MessageFormat;
import java.util.ArrayList;
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
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginTabStyle", "active");
        String nextJSP = "/Views/User/register.jsp";
       
        String nextServlet = request.getParameter("referer");
        request.setAttribute("referer", nextServlet);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errorText = "";
        
        UserCredential registration = new UserCredential();
        
        registration.setName(request.getParameter("name"));
        registration.setPassword(request.getParameter("password"));
        registration.setConfirmationPassword(request.getParameter("confirmationPassword"));
        registration.setUserID(request.getParameter("userID"));
        
        boolean valid = registration.validate();
        boolean added = false;
        
        String nextJSP = "/Views/User/register.jsp";
        String nextServlet = request.getParameter("referer");
        request.setAttribute("referer", nextServlet);
                
        if(valid)
        {
            added = UserService.registerUser(registration);
            
            if(added)
            {
                User u = UserService.findUser(registration.getUserID());
                HttpSession session = request.getSession(true);
                session.setAttribute("user", u);
                
                if (request.getParameterMap().containsKey("referer") && !nextServlet.equals("")) {
			response.sendRedirect(nextServlet);
		}
                else
                {
                    response.sendRedirect("/cs4280.project/");
                }
            }
            else{
                
                
                UserDBHandler db = new UserDBHandler();
                try {
                    db.checkConnection();
                    db.closeConnection();
                    errorText += "\n Duplicate User ID";
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
        else
        {
            errorText += "\n Your password and confirmation password dont match Or is not 6 characters in length!";
            request.setAttribute("error", errorText);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
        
       
        
        /*
        User user = new User(name, email, password);
        user = userService.create(user);
        HttpSession session = request.getSession(true);
        session.setAttribute(TodoListUtils.SESSION_USER, user);
        request.getRequestDispatcher("/todos").forward(request, response);
                */
    }

    
    

}

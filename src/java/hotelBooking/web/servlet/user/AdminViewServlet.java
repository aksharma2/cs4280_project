/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelBooking.web.servlet.user;

import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserRole;
import hotelBooking.core.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AdminViewServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginTabStyle", "active");
        
        UserRole requiredRole = new UserRole(UserRole.ADMIN);
        
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        
        ArrayList<UserRole> assignedRoles = UserService.findRolesAssignedToUser(user);
        boolean authorized = requiredRole.checkPreviledge(assignedRoles);
       
        String nextJSP = "/Views/User/userList.jsp";
       
        if(authorized)
        {
            nextJSP = "/Views/User/userList.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
        else
        {
            response.sendRedirect("../user/login");  
        }
       
    }
}

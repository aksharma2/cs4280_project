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

/**
 *
 * @author spanda2
 */
public class EditUserAccess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("idToEdit") != null)
        {
            User u = UserService.findUser((String) request.getParameter("idToEdit"));
            
            boolean isCheckedHotelManager =  request.getParameter("role_hotel_manager") != null;
            
            boolean isCheckedAdmin =  request.getParameter("role_admin") != null;
        
            
            ArrayList<UserRole> assigned = new ArrayList<UserRole>();
            if(isCheckedAdmin)
                assigned.add(new UserRole(UserRole.ADMIN));
            
            if(isCheckedHotelManager)
                assigned.add(new UserRole(UserRole.HOTEL_MANAGER));
            
            UserService.editUserAccess(u, assigned);
            
        }  
        
        String  nextJSP = "/Views/User/userList.jsp";
        ArrayList<User> users = UserService.findUser();
        
        request.setAttribute("userList", users);
        request.setAttribute("userCount", users.size());
                
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
        
    }
}

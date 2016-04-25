/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelBooking.web.servlet.booking;

import hotelBooking.core.domain.Room;
import hotelBooking.core.domain.User;
import hotelBooking.core.services.BookingService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sgarg2
 */
public class DeleteRoom extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
         String nextJSP = "/Views/Booking/BookingList.jsp";
        
        
        int dBookingID = Integer.parseInt(request.getParameter("Bookinguserid"));
        
         HttpSession session = request.getSession(true);
        
         session.setAttribute("dBookingID", dBookingID);
         
         String username ="EXTERNAL_USER";
          
          try
          {
               User currUser=(User)session.getAttribute("user");
            username=currUser.getId();
            
          } catch(Exception e)
          {
              username="EXTERNAL_USER";
          }
         
         
         BookingService bookingservice = new BookingService();
            
            boolean isConnectionMade = bookingservice.deleteBooking(dBookingID);
            
            if(isConnectionMade)
                
            {
              
                
            boolean isRoomBooked = bookingservice.deleteRoom(username);
            
            
            
            if(isRoomBooked)
            {
                
            }
            
            else
                
            {
                 
            }
           
            
        }
        
       
         
        
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
       
       
         
            
    }
    
   
        
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

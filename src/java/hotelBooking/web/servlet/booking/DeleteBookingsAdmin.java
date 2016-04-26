/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.booking;

import hotelBooking.core.services.BookingService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shrankhla
 */
public class DeleteBookingsAdmin extends HttpServlet {

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
        
        //String nextJSP = "/Views/Booking/allHotelBookings.jsp";
        
       // String nextServlet = "/Views/Booking/allHotelBookings.jsp";
        
        
        int dBookingID = Integer.parseInt(request.getParameter("Bookinguserid"));
        
        
        
        
        String username = request.getParameter("Bookingusername");
        
        if(username==null)
            
        {
            username="EXTERNAL_USER";
        }
        
        
          
         BookingService bookingservice = new BookingService();
            
            boolean isConnectionMade = bookingservice.deleteBooking(dBookingID);
            
            if(isConnectionMade)
                
            {
              
                
       boolean isRoomdeleted = bookingservice.deleteRoom(username);
            String hotelid = bookingservice.getHotelID(dBookingID);
            String rType= bookingservice.getRoomType(dBookingID);
            
             boolean isRoomadded=false;
            
            if(isRoomdeleted)
            {
                isRoomadded = bookingservice.IncreaseRoomInHotel(hotelid,rType);
            }
            
            else
                
            {
                 
            }
           
            
        }
        
       
         
        /*
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
       
        */
        response.sendRedirect("./ShowAllHotelBookings");
        
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

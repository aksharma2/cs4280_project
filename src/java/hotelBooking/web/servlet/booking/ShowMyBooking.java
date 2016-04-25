/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.booking;

import hotelBooking.core.domain.Booking;
import hotelBooking.core.domain.BookingType;
import hotelBooking.core.domain.User;
import hotelBooking.core.services.BookingService;
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
 * @author shrankhla
 */
public class ShowMyBooking extends HttpServlet {

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
        
        
         HttpSession session = request.getSession(true);
         
         
         
           String username ="EXTERNAL_USER";
          
          try
          {
               User currUser=(User)session.getAttribute("user");
            username=currUser.getId();
            
          } catch(Exception e)
          {
              username="EXTERNAL_USER";
          }
         
         
         // User currUser=(User)session.getAttribute("user");
           /// String username=currUser.getId();
        
        
        
        ArrayList<BookingType> allbookings;
        
         ArrayList<BookingType> allHotelbookings;
        
         BookingService bookingservice = new BookingService();
         allbookings=bookingservice.getallMyBookings(username);
         allHotelbookings=bookingservice.getallBookings();
       
         request.setAttribute("allbookings", allbookings);
         request.setAttribute("allHotelBookings", allHotelbookings);
         
         
         String nextJSP = "/Views/Booking/BookingList.jsp";
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
        
        doGet(request,response);
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

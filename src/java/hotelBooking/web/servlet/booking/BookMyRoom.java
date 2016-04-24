/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.booking;

import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserRole;
import hotelBooking.core.services.BookingService;
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
 * @author shrankhla
 */
public class BookMyRoom extends HttpServlet {

  

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
        
        
        
            String nextJSP = "/Views/Booking/BookRoom.jsp";
       
            String HName = request.getParameter("hotelN");
            String HURL = request.getParameter("hotelU");
            String HCity = request.getParameter("hotelC");
            String HID = request.getParameter("HotelID");

            request.setAttribute("hname", HName);
            request.setAttribute("hurl", HURL);
            request.setAttribute("hcity", HCity);
            
            boolean authorized = UserService.checkForAccess(request, UserRole.AUTHENTICATED);
            
            /*
            request.setAttribute("isAuthenticated",authorized);
            request.setAttribute("singlePrice", 150);
            request.setAttribute("deluxePrice", 199);
            request.setAttribute("suiteePrice", 289);
            request.setAttribute("singlePriceDisc", 100);
            request.setAttribute("deluxePriceDisc", 160);
            request.setAttribute("suiteePriceDisc", 250);
            
            */
            
               BookingService bookingservice = new BookingService();
               
               ArrayList<Integer> orgprice = new ArrayList<Integer>();
              orgprice = bookingservice.getOriginalPriceOfHotel(HID);
               
             //  orgprice = bookingservice.getOriginalPrice();
               
               ArrayList<Integer> discountedsprice = new ArrayList<Integer>();
               discountedsprice = bookingservice.getDiscountedPriceofHotel(HID);
              // discountedsprice = bookingservice.getDiscountedPrice();
            
            request.setAttribute("isAuthenticated",authorized);
            request.setAttribute("singlePrice", orgprice.get(0));
            request.setAttribute("deluxePrice", orgprice.get(1));
            request.setAttribute("suiteePrice", orgprice.get(2));
            request.setAttribute("singlePriceDisc", discountedsprice.get(0));
            request.setAttribute("deluxePriceDisc", discountedsprice.get(1));
            request.setAttribute("suiteePriceDisc", discountedsprice.get(2));
            
            
            
            
            
            
            
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
       
       
        
        
          HttpSession session = request.getSession(true);
          session.setAttribute("HotelCity", HCity);
          session.setAttribute("HotelName", HName);
          session.setAttribute("HID", HID);
          
         
          
        
       
       
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
        
        
         String nextJSP = "/Views/Booking/BookRoom.jsp";
        
        
        
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

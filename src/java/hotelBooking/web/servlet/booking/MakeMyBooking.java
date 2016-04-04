/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.booking;

import hotelBooking.core.domain.Booking;
import hotelBooking.core.domain.Hotel;
import hotelBooking.core.domain.Room;
import hotelBooking.core.domain.User;
import hotelBooking.core.jdbc.HotelDBHandler;
import hotelBooking.core.services.BookingService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
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
 * @author shrankhla
 */
public class MakeMyBooking extends HttpServlet {

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
       
        String nextJSP = "/Views/Booking/makebooking.jsp";
        
        ArrayList<Hotel>hotels= new ArrayList<Hotel>();
        HotelDBHandler db=new HotelDBHandler();
        
        
        boolean check=false;
        try {
            check = db.checkConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeMyBooking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MakeMyBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            if(check){
             hotels=db.findHotel();
                
            }
              
            request.setAttribute("hotel", hotels);
            
        
        
        
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
        
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
        String DEFAULT_CITY= "London";
     
        String hotel = request.getParameter("hotels");
        String room = request.getParameter("rooms");
        if (hotel != null && !hotel.equalsIgnoreCase("") &&
                room != null && !room.equalsIgnoreCase("")) {
            
            
            Long id ;
            Random rand = new Random();
            id=rand.nextLong();
            
            //String userName=Long.toString(id);
            
            
             HttpSession session = request.getSession(true);
          User currUser=(User)session.getAttribute("user");
            String username=currUser.getId();
            
            //String CityId = (String) session.getAttribute("city");
            
            //Booking b = new Booking(hotel,room,username,CityId);
            
            
            Booking b = new Booking(hotel,room,username,DEFAULT_CITY);
           // b.setHotelID(hotel);
            //b.setRoomID(room);
            //b.setUserID(userName);
            
           
            
           BookingService bookingservice = new BookingService();
            
            boolean isConnectionMade = bookingservice.makeBooking(b);
            
            if(isConnectionMade)
                
            {
               out.println("<legend>New Booking is sucessfully made.</legend>");
               
            Long id_Room ;
            Random randi = new Random();
            id_Room=randi.nextLong();
            String RoomID=Long.toString(id_Room);
            boolean isRoomAvailable=false;
            
            
            
            Room r = new Room(hotel,RoomID,room,isRoomAvailable);
            
            boolean isRoomBooked = bookingservice.BookRoom(r);
            
            if(isRoomBooked)
            {
                out.println("<legend>New Room has been booked for you.</legend>");
            }
            
            else
                
            {
                 out.println("<legend>ERROR: Room Booking Failed.</legend>");
            }
            
               
            
            }
            else {
                out.println("<legend>ERROR: Booking Failed.</legend>");
            }
        }
        
        else{
             if (hotel == null) {
                hotel = "";
            }
            if (room == null) {
                room = "";
            }
            
            String nextJSP = "/Views/Booking/makebooking.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
            
        }
        
        
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

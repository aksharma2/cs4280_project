/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.booking;

import hotelBooking.core.domain.Booking;
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
 * @author shrankhla
 */
public class AssignRoom extends HttpServlet {

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
        
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
          HttpSession session = request.getSession(true);
          User currUser=(User)session.getAttribute("user");
            String username=currUser.getId();
            
         String hotel = (String) session.getAttribute("HotelName");
         String City = (String) session.getAttribute("HotelCity");
         String RoomType= (String) session.getAttribute("Roomtype");
         
         String CheckInDate = (String) session.getAttribute("checkindate");
         String CheckOutDate = (String) session.getAttribute("checkoutdate");
         
         Integer numofAdults = (Integer) session.getAttribute("noofadults");
         Integer numOfChilren = (Integer)(session.getAttribute("noofchildren"));
         
         String hotelID = (String) session.getAttribute("HID");
           
         int MyBookingId =0;
         
         try
         {
           MyBookingId = (Integer) session.getAttribute("Bookingid");
         }catch (NullPointerException e )
         {
             
         }
       
         
       //  String MyBookingId = (String) session.getAttribute("Bookingid");
         
       
       
       
       
       String nextJSP = "/Views/Booking/BookingList.jsp";
       
       if (hotel != null && !hotel.equalsIgnoreCase("") &&
                RoomType != null && !RoomType.equalsIgnoreCase("") && MyBookingId==0) {
            
            
           /*
            Long id ;
            Random rand = new Random();s
            id=rand.nextLong();
            */
            //String userName=Long.toString(id);
            
          
            //String CityId = (String) session.getAttribute("city");
            
            //Booking b = new Booking(hotel,room,username,CityId);
            
            
            Booking b = new Booking(hotelID,RoomType,username,City);
           // b.setHotelID(hotel);
            //b.setRoomID(room);
            //b.setUserID(userName);
          
           BookingService bookingservice = new BookingService();
            
            boolean isConnectionMade = bookingservice.makeBooking(b,CheckInDate,CheckOutDate );
            
            if(isConnectionMade)
                
            {
               out.println("<legend>New Booking is sucessfully made.</legend>");
               
            Long id_Room ;
            Random randi = new Random();
            id_Room=randi.nextLong();
            String RoomID=Long.toString(id_Room);
            boolean isRoomAvailable=false;
            
            
            
            Room r = new Room(hotelID,RoomID,RoomType,isRoomAvailable);
            
            boolean isRoomBooked = bookingservice.BookRoom(r,numofAdults,numOfChilren,username);
            
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
        
       
       else if (hotel != null && !hotel.equalsIgnoreCase("") &&
                RoomType != null && !RoomType.equalsIgnoreCase("") && MyBookingId!=0)
           
       {
             Booking b = new Booking(hotel,RoomType,username,City);
             
              BookingService bookingservice = new BookingService();
              
            // int myid = Integer.parseInt(MyBookingId);
              
              
            
           // boolean isConnectionMade = bookingservice.UpdateBooking(b,CheckInDate,CheckOutDate,MyBookingId );
             
             boolean isConnectionMade = bookingservice.UpdateBooking(b,CheckInDate,CheckOutDate,MyBookingId );
            
            
            if(isConnectionMade)
                
            {
               out.println("<legend>New Booking is sucessfully Updated .</legend>");
               
            Long id_Room ;
            Random randi = new Random();
            id_Room=randi.nextLong();
            String RoomID=Long.toString(id_Room);
            boolean isRoomAvailable=false;
            
            
            
            Room r = new Room(hotel,RoomID,RoomType,isRoomAvailable);
            
            boolean isRoomBooked = bookingservice.BookRoom(r,numofAdults,numOfChilren,username);
            
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
            if (RoomType == null) {
                RoomType = "";
            }
            
           nextJSP = "/Views/Booking/BookRoom.jsp";
       
            
        }
        
        
       
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
           
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

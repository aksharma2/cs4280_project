/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.hotel;

import hotelBooking.core.domain.Hotel;
import hotelBooking.core.jdbc.HotelDBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author aksharma2
 */
public class ViewHotel extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String lowerval=request.getParameter("lowerval");
         String upperval=request.getParameter("upperval");
         
         if(lowerval.equals(""))
             lowerval="0";
         
         if(upperval.equals(""))
             upperval="0";
       
        try {
            String nextJSP="/Views/User/hotelmgmt.jsp";
            String id=request.getParameter("id");
            String radio=request.getParameter("Q2");
             int lowerLmt=Integer.parseInt(lowerval);
             int upperLmt=Integer.parseInt(upperval);
            ArrayList<Hotel>hotels=new ArrayList<Hotel>();
            hotels=null;
            HotelDBHandler db=new HotelDBHandler();
            boolean check=db.checkConnection();
            
            String hotelchosen = request.getParameter("hotelchosen");
            
            if(check && radio!=null){
                
                if(radio.equals("city"))
                    hotels=db.findHotelByCity(id,lowerLmt,upperLmt);
                
                else if(radio.equals("id"))
                    hotels=db.findHotelById(id,lowerLmt,upperLmt);
                
                else if(radio.equals("allHotels"))
                    hotels=db.findHotel(lowerLmt,upperLmt);
                
            }
            
            else if(hotelchosen!=null)
                
            {
               hotels=db.findHotelByCity(hotelchosen,lowerLmt,upperLmt);
            }
            
            request.setAttribute("hotel", hotels); 
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewHotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewHotel.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nextJSP="/Views/User/hotelmgmt.jsp";
        String name="id";
        
        
        int Bookingid = Integer.parseInt(request.getParameter("bookingUserID"));
        
        String bookingid = request.getParameter("bookingUserID");
       // int dBookingID = Integer.parseInt(request.getParameter("Bookinguserid"));
        
        
         HttpSession session = request.getSession(true);
         session.setAttribute("Bookingid", Bookingid);
         session.setAttribute("bookingid", bookingid);
         
         //session.setAttribute("dBookingID", dBookingID);
        
        
        
        request.setAttribute("eid", name);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
        response.sendRedirect("/Views/User/hotelmgmt.jsp");
   
     }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

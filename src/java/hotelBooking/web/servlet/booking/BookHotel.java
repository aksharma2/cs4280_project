/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.booking;

import hotelBooking.core.domain.Hotel;
import hotelBooking.core.domain.HotelImg;
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

/**
 *
 * @author shrankhla
 */
public class BookHotel extends HttpServlet {

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
        
         String nextJSP = "/Views/Booking/BookHotel.jsp";
        
       
        ArrayList<HotelImg> allImgs = new ArrayList<HotelImg>();
        
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
            
             allImgs=db.getHotelImages();
                
            }
              
           
            request.setAttribute("imgs", allImgs);
            
        
        
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

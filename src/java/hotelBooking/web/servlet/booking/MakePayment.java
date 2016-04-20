/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.booking;

import hotelBooking.core.domain.UserRole;
import hotelBooking.core.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
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
public class MakePayment extends HttpServlet {

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
        
      doPost(request,response);
       
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
        
         boolean authorized = UserService.checkForAccess(request, UserRole.AUTHENTICATED);
         
         if(authorized)
        {
          String roomtype = request.getParameter("act");
          String hotlname= request.getParameter("hotlName");
          String nextJSP="/Views/Booking/Payment.jsp";
          Integer tariff = null;
          
        
         
          
          if(roomtype==null)
          {
              nextJSP="/Views/Booking/BookRoom.jsp";
          }
          
          else if(roomtype.equals("single"))
          {
              tariff=150;
          }
          
          else if(roomtype.equals("deluxe"))
          {
              tariff=199;
              
          }
          
          else if (roomtype.equals("suitee"))
          {
              tariff=289;
          }
          
          request.setAttribute("tariff", tariff);
          request.setAttribute("roomType", roomtype);
          request.setAttribute("HotlName", hotlname);
          
          
           HttpSession session = request.getSession(true);
           session.setAttribute("Roomtype", roomtype);
        
          
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
          dispatcher.forward(request,response);
        
    }else
        {
            response.sendRedirect("./user/login?referer=" + request.getRequestURI());
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

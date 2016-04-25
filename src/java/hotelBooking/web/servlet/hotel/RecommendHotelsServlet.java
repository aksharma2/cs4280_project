/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelBooking.web.servlet.hotel;

import hotelBooking.core.domain.Recommendation;
import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserRole;
import hotelBooking.core.services.HotelManagerService;
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
 * @author spanda2
 */
public class RecommendHotelsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /*
        
        So now if you require the user to have ADMIN role to access the Admin View Servlet then you gottal change the nexr line to... 
        boolean authorized = UserService.checkForAccess(request, UserRole.ADMIN);
        
        */
        boolean authorized = false;
        try{
            authorized = UserService.checkForAccess(request, UserRole.ADMIN);
        }
        catch(Exception e)
        {
            response.sendRedirect("./user/login?referer=" + request.getRequestURI());
        }
        
        String nextJSP = "/Views/Hotel/recommendHotels.jsp";
       
        if(authorized)
        {
            nextJSP = "/Views/Hotel/recommendHotels.jsp";
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            ArrayList<String> allHotels = null;
            if(user != null)
                allHotels = HotelManagerService.findHotelsByManagerID(user.getId());
            
            ArrayList<Recommendation> allrecs = new ArrayList<Recommendation>();
            for(String h: allHotels)
            {
                Recommendation r = new Recommendation();
                r = retreiveRecommendation(h, "single");
                allrecs.add(r);
                r = retreiveRecommendation(h, "deluxe");
                allrecs.add(r);
                r = retreiveRecommendation(h, "suitee");
                allrecs.add(r);
            }
            
            if(allHotels!=null && user!=null)
            {
                request.setAttribute("allRecs", allrecs);
                //request.setAttribute("manager", user.getId());
                
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
        else
        {
            response.sendRedirect("./user/login?referer=" + request.getRequestURI());
        }
       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String hotelID = request.getParameter("hotelID");
        String roomID = request.getParameter("roomID");
        String index = request.getParameter("SingleRecomendationIndex");
        
        Recommendation newRecommendation = new Recommendation();
        if(hotelID!=null && roomID!=null && index!=null )
        {
            
            boolean editRecommendationIndex = HotelManagerService.editRecommendationIndex(hotelID, roomID, Integer.parseInt(index));
        }
        
        doGet(request,response);
        
    }
    
    public Recommendation retreiveRecommendation(String h, String type)
    {
        //returns rec if exist
        ArrayList<Recommendation> all = HotelManagerService.findRecommendations(h, type);
        Recommendation r = new Recommendation();
        if(all.size() > 0)
        {
            r = all.get(0);
        
        }
        else{
            r.setHotelID(h);
            r.setRoomID(type);
            r.setIndex(0);
        
        }
        
        
        
        return r;
    }
    

}

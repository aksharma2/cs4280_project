/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service.user;


import hotelBooking.core.domain.Recommendation;
import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.domain.UserRole;
import hotelBooking.core.jdbc.UserDBHandler;
import hotelBooking.core.services.HotelManagerService;
import hotelBooking.core.services.UserService;
import java.util.ArrayList;

/**
 *
 * @author spanda2
 */
public class DBKeyGen {
    
     public static void main(String[] arg) throws ClassNotFoundException
    {  
        /*
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
    
    */
/*        
       Recommendation r = new Recommendation();
       r.setHotelID("10");
       r.setRoomID("suitee");
       r.setIndex(1);
       
       HotelManagerService.editRecommendationIndex(r.getHotelID(), r.getRoomID(), r.getIndex());
       
       ArrayList<Recommendation> allrec = HotelManagerService.findRecommendations("10","suitee");
       
       int  x = 10 ;
*/
        
        Boolean b = UserService.checkHotelMangerMapping("2892891", "shrankhla2");
        
        int x = 5;
        
        
    }
            
   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service.user;


import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.domain.UserRole;
import hotelBooking.core.jdbc.UserDBHandler;
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
        User u = new User("spanda2","spanda2");
         ArrayList<UserRole> roles = UserService.findRolesAssignedToUser(u);
         String roleName = roles.get(0).getRoleName();
         */
        
        User u = UserService.findUser("spanda2");
       
         boolean res = UserService.checkHotelMangerMapping("hotel2","spanda2");
         
         
         int x = 6;
    }
            
   
}


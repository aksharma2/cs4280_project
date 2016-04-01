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
         UserCredential u = new UserCredential();
         u.setUserID("spanda2");
         u.setPassword("123123");
         
         boolean res = UserService.authenticate(u);
         
         int x = 6;
    }
            
   
}


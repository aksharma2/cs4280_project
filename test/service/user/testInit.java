/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.user;

import hotelBooking.core.domain.User;
import hotelBooking.core.services.UserService;

/**
 *
 * @author PANDA Sourav
 */
public class testInit {
    
    //Simple test - no rocket science
    public static void main(String[] arg)
    {   
        
        User u = UserService.getUserByID("43895807");
        System.out.println(u.getName() + ", " + u.getUserID());
    }
    
    
}

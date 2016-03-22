/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.services;

import hotelBooking.core.domain.User;

/**
 *
 * @author PANDA Sourav
 */
public class UserService {
 
    public static User getUserByID(String id)
    {
        User u = new User();
        u.setName("Sourav Panda");
        u.setUserID("spanda2");
        return u;
    }
    
    
}

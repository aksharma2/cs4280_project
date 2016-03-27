/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.services;

import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.jdbc.UserDBHandler;
import java.util.ArrayList;

/**
 *
 * @author PANDA Sourav
 */
public class UserService {
 
    public static boolean registerUser(UserCredential u)
    {
        boolean success = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            success = db.registerUser(u);
        }
        db.closeConnection();
        return success;
    }
    
    public static ArrayList<User> findUser()
    {
        ArrayList<User> allusers = null;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            allusers = db.findUser();
        }
        db.closeConnection();
        return allusers;
    
    }
    
    
}

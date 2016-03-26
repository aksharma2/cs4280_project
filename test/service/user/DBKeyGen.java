/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service.user;


import hotelBooking.core.domain.User;
import hotelBooking.core.jdbc.UserDBHandler;
import hotelBooking.core.services.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author spanda2
 */
public class DBKeyGen {
    
     public static void main(String[] arg) throws ClassNotFoundException, SQLException
    {   
        
       User u = new User();
       u.setName("Sourav Panda");
       u.setUserID("spanda19");
       
      UserDBHandler db = new UserDBHandler();
      boolean connectionResult = db.setupConnection();
      if(connectionResult)
      {
        boolean added = db.registerUser(u);
        
        if(added)
            System.out.println("Added");
        else
            System.out.println("NOT Added");
        }
    }
            
   
}


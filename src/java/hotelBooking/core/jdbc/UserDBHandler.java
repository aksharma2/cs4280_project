/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import hotelBooking.core.domain.User;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PANDA Sourav
 */
public class UserDBHandler {
    
    Connection con;
    
    public boolean setupConnection()
    {
        boolean success = false;
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad056_db", "aiad056", "aiad056");
            success = true;
        }
        catch (ClassNotFoundException e) {
            success = false;
        } catch (SQLException e) {
            success = false;
        } finally {
            out.close();
        }
        
        return success;
    }
    
    public boolean registerUser(User u)
    {
    
        boolean success = false;
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("INSERT INTO [PROJ_USER] ([Name], [ID] ) VALUES (?, ?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getUserID());
            
            int rows = pstmt.executeUpdate();
            if(rows > 0)
                success = true;
            
        }
        catch (SQLException ex) {
            success = false;
        }
        
        
        return success;
    
    }
    
    
    
    
    
}

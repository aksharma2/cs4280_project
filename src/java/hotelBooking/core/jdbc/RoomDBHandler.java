/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shrankhla
 */
public class RoomDBHandler {
    
    boolean success = true;
    Connection con;
    Statement stmt;
    ResultSet rs;
            
    public boolean makeConnection()
            
    {
        try
        {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad056_db", "aiad056", "aiad056");
           success=true;     
        }  catch (ClassNotFoundException e) {
            success = false;
        } catch (SQLException e) {
            success = false;
        } finally {
           
        }
        
        return success;
    }
    
    
    public boolean setMaxRoom (String hotelID, String roomType, int num)
            
    {
        boolean success= false;
        
        try
        {
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO [PROJ_ROOMASSIGNMENT] ( [hotelID], [roomType],[maxNum]) VALUES (?, ?, ?)");
                pstmt.setString(1, hotelID);
                pstmt.setString(2, roomType);
                pstmt.setInt(3,num);
                
                int rows = pstmt.executeUpdate();
                
                if(rows>0)
                {
                    
                }success=true;
                          
        }catch(SQLException e)
            
        {
            success=false;
        }
       
        return success;
   
        
    }
    
    
     public void closeConnection()
    {
        if(this.con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

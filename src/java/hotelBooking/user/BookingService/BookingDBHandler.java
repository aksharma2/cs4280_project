/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.user.BookingService;

import hotelBooking.core.domain.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shrankhla
 */
public class BookingDBHandler {
    
    boolean success = true;
    Connection con;
    Statement stmt;
    
    public boolean makeConnection()
            
    {
        try
        {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad025_db", "aiad025", "aiad025");
           success=true;     
        }  catch (ClassNotFoundException e) {
            success = false;
        } catch (SQLException e) {
            success = false;
        } finally {
           
        }
        
        return success;
    }
    
    public boolean makeMybooking(Booking b)
            
    {
        boolean success= false;
        
        try
        {
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO [Booking] ([roomID], [hotelID], [userID]) VALUES (?, ?, ?)");
                pstmt.setString(1, b.getRoomID());
                pstmt.setString(2, b.getHotelID());
                pstmt.setString(3,b.getUserID());
                
                 int rows = pstmt.executeUpdate();
                 if(rows>0)
                 {
                      success=true;
                 }
                    
        }catch(SQLException e)
            
        {
            success=false;
        }
       
        return success;
    }
    
    public ResultSet returnResult() throws SQLException
            
    {
         Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT @@IDENTITY AS [@@IDENTITY]");
        return rs;
        
    }
     
    
    public Statement getStatement()
            
    {
        return stmt;
    }
    
    
}

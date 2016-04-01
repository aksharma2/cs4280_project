/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

import hotelBooking.core.domain.Booking;
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
public class BookingDBHandler {
    
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
    
    public boolean makeMybooking(Booking b)
            
    {
        boolean success= false;
        
        try
        {
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO [PROJ_BOOKING] ([roomID], [hotelID], [userID]) VALUES (?, ?, ?)");
                pstmt.setString(1, b.getRoomID());
                pstmt.setString(2, b.getHotelID());
                pstmt.setString(3,b.getUserID());
                
                 int rows = pstmt.executeUpdate();
                 if(rows>0)
                 {
                      success=true;
                     
                      System.out.println("Your Booking Details are as follows.");
                        if (rs != null && rs.next() != false) {
                            System.out.println("Room: " + (b.getRoomID()));
                            System.out.println("Hotel:" + (b.getHotelID()) );
                            System.out.println("User:" + (b.getUserID()));
                            rs.close();
                    }
                    StatementClose(); 
                    
                 }
                 
            
                    
        }catch(SQLException e)
            
        {
            success=false;
        }
       
        return success;
    }
    
    public ResultSet returnResult() throws SQLException
            
    {
          stmt = con.createStatement();
         rs = stmt.executeQuery("SELECT @@IDENTITY AS [@@IDENTITY]");
        return rs;
        
    }
     
    
    public Statement getStatement()
            
    {
        return stmt;
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
    
    public void ResultSetClose()
            
    {
        if(this.rs!=null)
        {
            try
            {
                rs.close();
            }catch(SQLException ex)
            {
                 Logger.getLogger(BookingDBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void StatementClose()
    {
        if(this.stmt!=null)
            
        {
            try{
                stmt.close();
            }catch(SQLException ex)
            {
               Logger.getLogger(BookingDBHandler.class.getName()).log(Level.SEVERE, null, ex);
           
            }
        }
    }
    
}

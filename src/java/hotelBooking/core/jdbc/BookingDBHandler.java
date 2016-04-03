/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

import hotelBooking.core.domain.Booking;
import hotelBooking.core.domain.Room;
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
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO [PROJ_BOOKING] ([roomID], [hotelID], [userID],[city]) VALUES (?, ?, ?, ?)");
                pstmt.setString(1, b.getRoomID());
                pstmt.setString(2, b.getHotelID());
                pstmt.setString(3,b.getUserID());
                pstmt.setString(4,b.getCityID());
                
                
                 int rows = pstmt.executeUpdate();
                 if(rows>0)
                 {
                      success=true;
                     
                      System.out.println("Your Booking Details are as follows.");
                        if (rs != null && rs.next() != false) {
                            System.out.println("Room: " + (b.getRoomID()));
                            System.out.println("Hotel:" + (b.getHotelID()) );
                            System.out.println("User:" + (b.getUserID()));
                            System.out.println("City:" + (b.getCityID()));
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
    
    
    public boolean BookMyRoom(Room r)
            
    {
        boolean successs= false;
        
        try
        {
            boolean Connectionmade = makeConnection();
            
            if(Connectionmade)
            {
                PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO [PROJ_ROOM] ([hotelID],[id], [type],[isAvailable]) VALUES (?, ?, ?, ?)");
                pstmt1.setString(1,r.getHotelID() );
                pstmt1.setString(2,r.getId() );
                pstmt1.setString(3,r.getType());
                pstmt1.setBoolean(4,r.isIsAvailable());
                
                
                
                
                 int rows = pstmt1.executeUpdate();
                 
                 if(rows>0)
                 {
                      successs=true;
                     
                      System.out.println("Your Booking Details are as follows.");
                        if (rs != null && rs.next() != false) {
                            System.out.println("Room: " + (r.getHotelID()));
                            System.out.println("Hotel:" + (r.getId()) );
                            System.out.println("User:" + (r.getType()));
                            System.out.println("City:" + (r.isIsAvailable()));
                            rs.close();
                    }
                    StatementClose(); 
                    
                 }
            }
                    
        }catch(SQLException e)
            
        {
            successs=false;
        }
       
        return successs;
    }
}

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
    
    
    public boolean setMaxRoom (String hotelID, String roomType, int num, int price, int discPrice)
            
    {
        boolean success= false;
           makeConnection();
        try
        {
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO [PROJ_ROOMASSIGNMENT] ( [hotelID], [roomType],[maxNum],[price],[discountedPrice]) VALUES (?, ?, ?, ?, ?)");
                pstmt.setString(1, hotelID);
                pstmt.setString(2, roomType);
                pstmt.setInt(3,num);
                pstmt.setInt(4,price);
                pstmt.setInt(5,discPrice);
                
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

    public int getMaximumSingleRooms(String id) {
        
        int maxSingleRoom=0;
        
         makeConnection();
         
          try
        {
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT] WHERE [hotelID]= (?) AND [roomType]= (?) ");
                pstmt.setString(1, id);
                pstmt.setString(2, "single");
               
                rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 maxSingleRoom=(rs.getInt("maxNum"));
             }
               
                          
        }catch(SQLException e)
            
        {
            
        }
       
        return maxSingleRoom;
        
        }

    public int getMaximumDeluxeRooms(String id) {
        
         
        int maxDeluxeRoom=0;
        
         makeConnection();
         
          try
        {
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT] WHERE [hotelID]= (?) AND [roomType]= (?) ");
                pstmt.setString(1, id);
                pstmt.setString(2, "deluxe");
               
                rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 maxDeluxeRoom=(rs.getInt("maxNum"));
             }
               
                          
        }catch(SQLException e)
            
        {
            
        }
       
        return maxDeluxeRoom;
        
        }

    public int getMaximumSuiteRooms(String id) {
        
          
        int maxSuiteRoom=0;
        
         makeConnection();
         
          try
        {
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT] WHERE [hotelID]= (?) AND [roomType]= (?) ");
                pstmt.setString(1, id);
                pstmt.setString(2, "suite");
               
                rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 maxSuiteRoom=(rs.getInt("maxNum"));
             }
               
                          
        }catch(SQLException e)
            
        {
            
        }
       
        return maxSuiteRoom;
        
        
        
          }
    
    
    
     public int getMaximumRooms(String id,String roomtype) {
        
          
        int maxRoom=0;
        
         makeConnection();
         
          try
        {
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT] WHERE [hotelID]= (?) AND [roomType]= (?) ");
                pstmt.setString(1, id);
                pstmt.setString(2, roomtype);
               
                rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 maxRoom=(rs.getInt("maxNum"));
             }
               
                          
        }catch(SQLException e)
            
        {
            
        }
       
        return maxRoom;
        
        
        
          }
    
    
    

    public boolean reduceNumOfRoomsFromHotel(String id,String roomtype) {
        
        boolean success= false;
        
         makeConnection();
        try
        {
            int num = getMaximumRooms(id,roomtype);
            num=num-1;
            
             PreparedStatement pstmt = con.prepareStatement("UPDATE [PROJ_ROOMASSIGNMENT] SET [maxNum] =? WHERE [hotelID] =? AND [roomType]= ? ");
               
                pstmt.setInt(1,num);
                pstmt.setString(2, id);
                pstmt.setString(3, roomtype);
                
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

    public boolean IncreaseNumOfRoomsinHotel(String id, String roomtype) {
        
        boolean success= false;
        
         makeConnection();
        try
        {
            int num = getMaximumRooms(id,roomtype);
            num=num+1;
            
             PreparedStatement pstmt = con.prepareStatement("UPDATE [PROJ_ROOMASSIGNMENT] SET [maxNum] =? WHERE [hotelID] =? AND [roomType]= ? ");
               
                pstmt.setInt(1,num);
                pstmt.setString(2, id);
                pstmt.setString(3, roomtype);
                
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

    public String getRoomType(int id) {
        
        
           String type=null;
        
         makeConnection();
         
          try
        {
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM [PROJ_BOOKING] WHERE [bookingID]= (?)  ");
                pstmt.setInt(1, id);
                
               
                rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 type=(rs.getString("roomID"));
             }
               
                          
        }catch(SQLException e)
            
        {
            
        }
       
        return type;
        
        
         }

    public String getHotelID(int id) {
        
        
           String hotelid=null;
        
         makeConnection();
         
          try
        {
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM [PROJ_BOOKING] WHERE [bookingID] = (?) ");
              pstmt.setInt(1, id);
              rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 hotelid=(rs.getString("hotelID"));
             }
               
                          
        }catch(SQLException e)
            
        {
            
        }
       
        return hotelid;
        
         }
        
         
}

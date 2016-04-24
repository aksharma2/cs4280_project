/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelBooking.core.jdbc;

import hotelBooking.core.domain.Recommendation;
import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserRole;
import static hotelBooking.core.services.UserService.findRolesAssignedToUser;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spanda2
 */
public class HotelManagerDBHandler {
    
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
    
    public boolean checkConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad056_db", "aiad056", "aiad056");
        
        return true;
    }
    
    public void closeConnection()
    {
        if(this.con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> findHotelsManagedByManager(String id)
    {
        
        ArrayList<String> allHotels = new ArrayList<String>();
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_HOTELMANAGER] WHERE MANAGERID = (?)");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               String hotelID = rs.getString("HOTELID");
               if(hotelID != null)
                 allHotels.add(hotelID);
            }
            
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
        return allHotels;
    }
    
    public boolean editRecommendationIndex(String hotelID, String roomType, int index)
    {
        boolean success = true;
        PreparedStatement pstmt;
        try {
           
            pstmt = con.prepareStatement("DELETE FROM [PROJ_RECOMMENDEDHOTELS] WHERE [HotelID] = (?) AND [RoomType] = (?)");
            pstmt.setString(1, hotelID);
            pstmt.setString(2, roomType);
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected <= 0)
                success = false;
           
            //Insert the new roles
            pstmt = con.prepareStatement("INSERT INTO [PROJ_RECOMMENDEDHOTELS] ( [HotelID], [RoomType], [recommendationLevel] ) VALUES (?, ?, ?)");
            pstmt.setString(1, hotelID);
            pstmt.setString(2, roomType);
            pstmt.setInt(3, index);
            
            if(index > 0)
            rowsAffected = pstmt.executeUpdate();
                
                if(rowsAffected <= 0)
                    success = false;
           
            
        }
        catch (SQLException ex) {
            success = false;
        }
        return success;
    
    }
    
    
    public ArrayList<Recommendation> findRecommendations(String id, String roomtype)
    {
        
        ArrayList<Recommendation> rec = new ArrayList<Recommendation>();
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_RECOMMENDEDHOTELS] WHERE HotelID = (?) AND RoomType = (?)");
            pstmt.setString(1, id);
            pstmt.setString(2, roomtype);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               String hotelID = rs.getString("HOTELID");
               if(rs.getString("RoomType")!=null && rs.getString("recommendationLevel")!=null)
               {
                   Recommendation r = new Recommendation();
                   r.setHotelID(id);
                   r.setIndex(rs.getInt("recommendationLevel"));
                   r.setRoomID(rs.getString("RoomType"));
                   rec.add(r);
               }
               
            }
            
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
        return rec;
    }
    
    public ArrayList<Recommendation> findRecommendations()
    {
        
        ArrayList<Recommendation> rec = new ArrayList<Recommendation>();
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_RECOMMENDEDHOTELS] ");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               String hotelID = rs.getString("HOTELID");
               if(rs.getString("RoomType")!=null && rs.getString("recommendationLevel")!=null)
               {
                   Recommendation r = new Recommendation();//HotelID
                   r.setHotelID(rs.getString("HotelID"));
                   r.setIndex(rs.getInt("recommendationLevel"));
                   r.setRoomID(rs.getString("RoomType"));
                   rec.add(r);
               }
               
            }
            
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
        return rec;
    }
}

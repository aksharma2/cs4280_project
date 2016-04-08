/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

import hotelBooking.core.domain.Hotel;
import hotelBooking.core.domain.HotelImages;
import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.domain.UserRole;
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
 * @author aksharma2
 */
public class HotelDBHandler {
    
    Connection con;
    
      public boolean setupConnection(){
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
    
    public boolean checkConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad056_db", "aiad056", "aiad056");
        
        return true;
    }
    
    public void closeConnection(){
        if(this.con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean registerHotel(Hotel h){
        boolean success = false;
        PreparedStatement pstmt;
        try {
            
            //Create Entry in the PROJ_USER table
            pstmt = con.prepareStatement("INSERT INTO [PROJ_HOTEL] ( [hotelid], [hotelname] , [hotelcity] ) VALUES (?, ?, ?)");
            pstmt.setString(1, h.getId());
            pstmt.setString(2, h.getName());
            pstmt.setString(2, h.getCity());
            
            int rowsUser = pstmt.executeUpdate();
            
            if(rowsUser > 0)
                success = true;
        }
        catch (SQLException ex) {
            success = false;
        }
        return success;
    
    }
    
    public boolean clearTable(){
        boolean success = false;
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("DELETE FROM [PROJ_HOTEL]");
            int rowsUser = pstmt.executeUpdate();
           
            
            if(rowsUser > 0)
                success = true;
        }
        catch (SQLException ex) {
            success = false;
        }
        return success;
    
    }
    
    public boolean deleteHotel(String hotelId){
        boolean success = false;
        PreparedStatement pstmt;
        try {
            
            //Create Entry in the PROJ_USER table
            pstmt = con.prepareStatement("DELETE FROM [PROJ_HOTEL] WHERE [hotelid] = (?)");
            pstmt.setString(1, hotelId);
            
            int rowsUser = pstmt.executeUpdate();
            
            if(rowsUser > 0)
                success = true;
        }
        catch (SQLException ex) {
            success = false;
        }
        return success;
    
    }
    
    public ArrayList<Hotel> findHotel(){
        
        ArrayList<Hotel> allHotels = new ArrayList<Hotel>();
        
        PreparedStatement pstmt;
       
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_HOTEL]");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               Hotel h = new Hotel();
               h.setId(rs.getString("hotelid"));
               h.setName(rs.getString("hotelname"));
               h.setCity(rs.getString("hotelcity"));
               
               PreparedStatement pstmt1 = con.prepareStatement("SELECT * FROM [PROJ_HOTEL_IMG] WHERE H_Id= '"+h.getId()+"' ");
               ResultSet rs1 = pstmt1.executeQuery(); 
               while(rs1.next()){
                   
                   HotelImages h1= new HotelImages();
                   h1.setHotelId(rs1.getString("H_Id"));
                   h1.setHotelName(rs1.getString("H_Name"));
                   h1.setHotelCity(rs1.getString("H_City"));
                   h1.setHotelImg(rs1.getString("H_Img"));
                   h.setImg(h1.getHotelImg());
                   
               }
               
               allHotels.add(h);
            }
            
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
         return allHotels;
    }
    
    public ArrayList<Hotel> findHotelById(String id){
        
        PreparedStatement pstmt;
        ArrayList<Hotel>hotel=new ArrayList<Hotel>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_HOTEL] WHERE hotelid = (?)");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               if(rs.getString("hotelid") != null && rs.getString("hotelid").equalsIgnoreCase(id)){
                    Hotel h = new Hotel();
                    h.setId(rs.getString("hotelid"));
                    h.setName(rs.getString("hotelname"));
                    h.setCity(rs.getString("hotelcity"));
                    
                    PreparedStatement pstmt1 = con.prepareStatement("SELECT * FROM [PROJ_HOTEL_IMG] WHERE H_Id= '"+h.getId()+"' ");
               ResultSet rs1 = pstmt1.executeQuery(); 
               while(rs1.next()){
                   
                   HotelImages h1= new HotelImages();
                   h1.setHotelId(rs1.getString("H_Id"));
                   h1.setHotelName(rs1.getString("H_Name"));
                   h1.setHotelCity(rs1.getString("H_City"));
                   h1.setHotelImg(rs1.getString("H_Img"));
                   h.setImg(h1.getHotelImg());
                   
               }
                    
                    hotel.add(h);
                    
               }
            }
             
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
         return hotel;
    }   
    
     public ArrayList<Hotel> findHotelByCity(String city){
        
        PreparedStatement pstmt;
        ArrayList<Hotel>allHotels=new ArrayList<Hotel>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_HOTEL] WHERE hotelcity = (?)");
            pstmt.setString(1, city);
                        
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               if(rs.getString("hotelcity").equalsIgnoreCase(city)){
                    Hotel h = new Hotel();
                    h.setId(rs.getString("hotelid"));
                    h.setName(rs.getString("hotelname"));
                    h.setCity(rs.getString("hotelcity"));
                    
                    PreparedStatement pstmt1 = con.prepareStatement("SELECT * FROM [PROJ_HOTEL_IMG] WHERE H_Id= '"+h.getId()+"' ");
               ResultSet rs1 = pstmt1.executeQuery(); 
               while(rs1.next()){
                   
                   HotelImages h1= new HotelImages();
                   h1.setHotelId(rs1.getString("H_Id"));
                   h1.setHotelName(rs1.getString("H_Name"));
                   h1.setHotelCity(rs1.getString("H_City"));
                   h1.setHotelImg(rs1.getString("H_Img"));
                   h.setImg(h1.getHotelImg());
                   
               }
                    
                    allHotels.add(h);
                    
                 }
            }
             
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
         return allHotels;
    }   
    
}

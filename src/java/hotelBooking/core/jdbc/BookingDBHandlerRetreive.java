/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

import hotelBooking.core.domain.Booking;
import hotelBooking.core.domain.BookingType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shrankhla
 */
public class BookingDBHandlerRetreive {
    
     boolean success = true;
    Connection con;
    Statement stmt;
    ResultSet rs;
    int numRows;
    
    
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
    
    
     public boolean showMybookings()
            
    {
        boolean success= false;
        
        try
        {
              stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = stmt.executeQuery("SELECT * FROM [PROJ_BOOKING] ");
            
            if (rs != null && rs.last() != false)
            {
            numRows = rs.getRow();
            rs.beforeFirst();
            }
            
            if(numRows>0)
            {
                success=true;
            }
            
        }catch(SQLException e)
            
        {
            success=false;
        }
       
        return success;
    }
    
     public ArrayList<BookingType> findBooking()
             
     {
         ArrayList<BookingType> allbookings = new ArrayList<BookingType>();
         
         PreparedStatement pst;
         
         try{
            // pst=con.prepareStatement("SELECT * FROM [PROJ_BOOKING] ");
             
             //rs=pst.executeQuery();
            makeConnection();
            
            Statement pstmt;
             pstmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = pstmt.executeQuery("SELECT * FROM [PROJ_BOOKING] ");
             while(rs.next())
             {
                 BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"),rs.getInt("numOfRooms"));
                 allbookings.add(b);
             }
         } catch (SQLException ex) {
             Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return allbookings;
     }
     
     
     
     
      public ArrayList<BookingType> findMyBooking(String id)
             
     {
         ArrayList<BookingType> allbookings = new ArrayList<BookingType>();
         
         //PreparedStatement pst;
         
         try{
            // pst=con.prepareStatement("SELECT * FROM [PROJ_BOOKING] ");
             
             //rs=pst.executeQuery();
            makeConnection();
            
            PreparedStatement pstmt;
            // pstmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             
              pstmt = con.prepareStatement("SELECT * FROM [PROJ_BOOKING] WHERE [userID] = (?) ");
              pstmt.setString(1, id);
                 rs = pstmt.executeQuery();
             while(rs.next())
             {
                 BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"),rs.getInt("numOfRooms"));
                 allbookings.add(b);
             }
         } catch (SQLException ex) {
             Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return allbookings;
     }
     
     
      
      
      public ArrayList<Integer> getOriginalprice()
             
     {
         ArrayList<Integer> originalPrice = new ArrayList<Integer>();
         
         //PreparedStatement pst;
         
         try{
            // pst=con.prepareStatement("SELECT * FROM [PROJ_BOOKING] ");
             
             //rs=pst.executeQuery();
            makeConnection();
            
            PreparedStatement pstmt;
            // pstmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             
              pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT]  ");
            
              
                 rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 originalPrice.add(rs.getInt("price"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return originalPrice;
     }
    
      
      
      public ArrayList<Integer> getOriginalpriceofHotel(String id)
             
     {
         ArrayList<Integer> originalPrice = new ArrayList<Integer>();
         
         //PreparedStatement pst;
         
         try{
            // pst=con.prepareStatement("SELECT * FROM [PROJ_BOOKING] ");
             
             //rs=pst.executeQuery();
            makeConnection();
            
            PreparedStatement pstmt;
            // pstmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             
             pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT] WHERE [hotelID] = (?) ");
             pstmt.setString(1, id);
             rs = pstmt.executeQuery();
            
             
             
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 originalPrice.add(rs.getInt("price"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return originalPrice;
     }
      
      
      
      
      
      
    public ArrayList<Integer> getDiscountedprice()
             
     {
         ArrayList<Integer> discountedPrice = new ArrayList<Integer>();
         
         //PreparedStatement pst;
         
         try{
            // pst=con.prepareStatement("SELECT * FROM [PROJ_BOOKING] ");
             
             //rs=pst.executeQuery();
            makeConnection();
            
            PreparedStatement pstmt;
            // pstmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             
              pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT]");
            
              
                 rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 discountedPrice.add(rs.getInt("discountedPrice"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return discountedPrice;
     }
      
      
    
    public ArrayList<Integer> getDiscountedpriceofHotel(String id)
             
     {
         ArrayList<Integer> discountedPrice = new ArrayList<Integer>();
         
         //PreparedStatement pst;
         
         try{
            // pst=con.prepareStatement("SELECT * FROM [PROJ_BOOKING] ");
             
             //rs=pst.executeQuery();
            makeConnection();
            
            PreparedStatement pstmt;
            // pstmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             
              pstmt = con.prepareStatement("SELECT * FROM [PROJ_ROOMASSIGNMENT] WHERE [hotelID]= (?)");
             pstmt.setString(1, id);
              rs = pstmt.executeQuery();
             while(rs.next())
             {
                 //BookingType b = new BookingType(rs.getString("hotelID"),rs.getString("roomID"),rs.getString("userID"),rs.getString("city"),rs.getInt("bookingID"));
                 
                 discountedPrice.add(rs.getInt("discountedPrice"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return discountedPrice;
     }
      
      
      
      
      
      
      
     
     /*
     public Booking findBooking(String id)
             
     {
         Booking b = new Booking("a","b","c");
         return b;
     }
     */
     
    public Statement returnStatement()
    {
        return stmt;
    }
    
    public Connection getConnection()
    {
        return con;
    }
    
    public ResultSet getResultSet()
           
    {
        return rs;
    }
    
    public int returnNumOfRows()
            
    {
        return numRows;
    }
    
     public void closeConnection()
    {
        if(this.con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
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
                 Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
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
               Logger.getLogger(BookingDBHandlerRetreive.class.getName()).log(Level.SEVERE, null, ex);
           
            }
        }
    }
}

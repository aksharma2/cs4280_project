/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.services;

import hotelBooking.core.domain.Booking;
import hotelBooking.core.domain.BookingType;
import hotelBooking.core.domain.Room;

import hotelBooking.core.jdbc.BookingDBHandler;
import hotelBooking.core.jdbc.BookingDBHandlerRetreive;
import hotelBooking.core.jdbc.RoomDBHandler;
import java.util.ArrayList;

/**
 *
 * 
 */
public class BookingService {
    
   public static  BookingDBHandler db;
   public static BookingDBHandlerRetreive dbr;
   public static RoomDBHandler dbR;
   
    
    public static boolean makeBooking(Booking b , String checkinDate, String checkoutdate , String n)
    {
        boolean success=false;
        
         db = new BookingDBHandler();
        
        if(db.makeConnection())
            
        {
            success=db.makeMybooking(b, checkinDate , checkoutdate ,n);
            
        }
        db.closeConnection();
        
        return success;
    }
    
    public static boolean showBookings()
    {
        boolean success=false;
        
         dbr = new BookingDBHandlerRetreive();
        
        if(dbr.makeConnection())
        {
            success=dbr.showMybookings();
        }
        db.closeConnection();
        
        return success;
    }
    
     public static boolean BookRoom(Room r , int numofAdults , int numOfChilren ,String username)
    {
        boolean success=false;
        
         db = new BookingDBHandler();
        
        if(db.makeConnection())
            
        {
            success=db.BookMyRoom(r,numofAdults,numOfChilren ,username);
        }
        db.closeConnection();
        
        return success;
    }
     
     
     
   public static boolean deleteRoom(String username)
    {
        boolean success=false;
        
         db = new BookingDBHandler();
        
        if(db.makeConnection())
            
        {
            success=db.DeleteMyRoom(username);
        }
        db.closeConnection();
        
        return success;
    }
    
     
      public static boolean UpdateBooking(Booking b , String checkinDate, String checkoutdate , int id , String numR)
    {
        boolean success=false;
        
         db = new BookingDBHandler();
        
        if(db.makeConnection())
            
        {
            success=db.UpdateMybooking(b, checkinDate , checkoutdate , id , numR);
            
        }
        db.closeConnection();
        
        return success;
    }
     
    public static boolean deleteBooking(int id)
    {
        boolean success=false;
        
         db = new BookingDBHandler();
        
        if(db.makeConnection())
            
        {
            success=db.DeleteMybooking(id);
            
        }
        db.closeConnection();
        
        return success;
    }
      
      
    
     
   public static boolean setMaximumRooms(String hotelID , String roomType , int num, int price, int discPrice )
    {
        boolean success=false;
        
         dbR = new RoomDBHandler();
        
        if(dbR.makeConnection())
            
        {
            success=dbR.setMaxRoom(hotelID, roomType, num, price, discPrice);
        }
        dbR.closeConnection();
        
        return success;
    }  
     
     
   
    
    public static ArrayList<BookingType> getallMyBookings(String id)
            
    {
        ArrayList<BookingType> mybookings;
        dbr=new BookingDBHandlerRetreive();
        mybookings=dbr.findMyBooking(id);
        
        return mybookings;
        
    }
    
    
      public static ArrayList<BookingType> getallBookings()
            
    {
        ArrayList<BookingType> mybookings;
        dbr=new BookingDBHandlerRetreive();
        mybookings=dbr.findBooking();
        
        return mybookings;
        
    }
    
    
    
    public static ArrayList<Integer> getOriginalPrice()
            
    {
        ArrayList<Integer> originalPrice ;
         dbr=new BookingDBHandlerRetreive();
         originalPrice = dbr.getOriginalprice();
         
         return originalPrice;
    }
    
    
    public static ArrayList<Integer> getOriginalPriceOfHotel(String id)
            
    {
        ArrayList<Integer> originalPrice ;
         dbr=new BookingDBHandlerRetreive();
         originalPrice = dbr.getOriginalpriceofHotel(id);
         
         return originalPrice;
    }
    
    
    
    public static ArrayList<Integer> getDiscountedPrice()
            
    {
        ArrayList<Integer> discountedPrice ;
         dbr=new BookingDBHandlerRetreive();
         discountedPrice = dbr.getDiscountedprice();
         
         return discountedPrice;
    }
   
    
    
    public static ArrayList<Integer> getDiscountedPriceofHotel(String id)
            
    {
        ArrayList<Integer> discountedPrice ;
         dbr=new BookingDBHandlerRetreive();
         discountedPrice = dbr.getDiscountedpriceofHotel(id);
         
         return discountedPrice;
    }
   
    
    
     
    public static int getMaxSingleRoom(String id)
            
    {
        int maxsingleroom;
         dbR=new RoomDBHandler();
         maxsingleroom=dbR.getMaximumSingleRooms(id);
         
         return maxsingleroom;
    }
    
    
     public static int getDeluxeRoom(String id)
            
    {
        int maxdeluxeroom;
         dbR=new RoomDBHandler();
         maxdeluxeroom=dbR.getMaximumDeluxeRooms(id);
         
         return maxdeluxeroom;
    }
    
     
     public static int getSuiteRoom(String id)
            
    {
        int maxSuiteroom;
        
         dbR=new RoomDBHandler();
         maxSuiteroom=dbR.getMaximumSuiteRooms(id);
         
         return maxSuiteroom;
    }
     
     
     public static int getRoomsLeft(String id,String roomtype)
            
    {
        int maxrooms;
        
         dbR=new RoomDBHandler();
         maxrooms=dbR.getMaximumRooms(id,roomtype);
         
         return maxrooms;
    }
     
     public static String getRoomType(int id)
            
    {
        String type;
        
         dbR=new RoomDBHandler();
         type=dbR.getRoomType(id);
         
         return type;
    }
     
     public static String getHotelID(int id)
            
    {
        String hotelid;
        
         dbR=new RoomDBHandler();
         hotelid=dbR.getHotelID(id);
         
         return hotelid;
    }
      
    
    
    public boolean reduceRoomInHotel(String id, String roomtype)
    
    {
        boolean success=false;
        dbR=new RoomDBHandler();
        
        if(dbR.makeConnection())
            
        {
            success=dbR.reduceNumOfRoomsFromHotel(id,roomtype);
        }
        dbR.closeConnection();
        
        return success;
        
        
    }
   
    
    public boolean IncreaseRoomInHotel(String id, String roomtype)
    
    {
        boolean success=false;
        dbR=new RoomDBHandler();
        
        if(dbR.makeConnection())
            
        {
            success=dbR.IncreaseNumOfRoomsinHotel(id,roomtype);
        }
        dbR.closeConnection();
        
        return success;
        
        
    }
    
}

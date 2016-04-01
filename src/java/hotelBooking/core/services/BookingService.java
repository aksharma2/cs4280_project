/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.services;

import hotelBooking.core.domain.Booking;

import hotelBooking.core.jdbc.BookingDBHandler;
import hotelBooking.core.jdbc.BookingDBHandlerRetreive;

/**
 *
 * @author PANDA Sourav
 */
public class BookingService {
    
   public static  BookingDBHandler db;
   public static BookingDBHandlerRetreive dbr;
    
    public static boolean makeBooking(Booking b)
    {
        boolean success=false;
        
         db = new BookingDBHandler();
        
        if(db.makeConnection())
            
        {
            success=db.makeMybooking(b);
            
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
    
   
}

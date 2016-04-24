/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotelBooking.core.services;

import hotelBooking.core.domain.Recommendation;
import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserRole;
import hotelBooking.core.jdbc.HotelManagerDBHandler;
import hotelBooking.core.jdbc.UserDBHandler;
import static hotelBooking.core.services.UserService.findRolesAssignedToUser;
import java.util.ArrayList;

/**
 *
 * @author spanda2
 */
public class HotelManagerService {
    
    public static ArrayList<String> findHotelsByManagerID(String id)
    {
        ArrayList<String> allHotels = null;
        HotelManagerDBHandler db = new HotelManagerDBHandler();
        
        if(db.setupConnection())
        {
            allHotels = db.findHotelsManagedByManager(id);
            
        }
        db.closeConnection();
        return allHotels;
    
    }
    //editRecommendationIndex
    
    public static boolean editRecommendationIndex(String hotelID, String roomType, int index)
    {
        boolean result = false;
        HotelManagerDBHandler db = new HotelManagerDBHandler();
        
        if(db.setupConnection())
        {
            result = db.editRecommendationIndex( hotelID,  roomType,  index);
            
        }
        db.closeConnection();
        return result;
    
    }
    
    public static ArrayList<Recommendation> findRecommendations(String id, String roomType)
    {
        ArrayList<Recommendation> allRec = null;
        HotelManagerDBHandler db = new HotelManagerDBHandler();
        
        if(db.setupConnection())
        {
            allRec = db.findRecommendations(id, roomType);
            
        }
        db.closeConnection();
        return allRec;
    
    }
    
    public static ArrayList<Recommendation> findRecommendations()
    {
        ArrayList<Recommendation> allRec = null;
        HotelManagerDBHandler db = new HotelManagerDBHandler();
        
        if(db.setupConnection())
        {
            allRec = db.findRecommendations();
            
        }
        db.closeConnection();
        return allRec;
    
    }
}

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
import java.util.Random;

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
    
    public static boolean deleteRecommendationIndex(String hotelID)
    {
        boolean result = false;
        HotelManagerDBHandler db = new HotelManagerDBHandler();
        
        if(db.setupConnection())
        {
            result = db.deleteRecommendationIndex( hotelID);
            
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
    
    public static ArrayList<Recommendation> getRandomRecommendations(int nHigh, int nMed, int nLow)
    {
        ArrayList<Recommendation> allRecs = findRecommendations();
        
        
        ArrayList<Recommendation> high = new ArrayList<Recommendation>();
        ArrayList<Recommendation> low = new ArrayList<Recommendation>();
        ArrayList<Recommendation> med = new ArrayList<Recommendation>();
        
        if(allRecs!=null && allRecs.size() > 0)
        {
            for(Recommendation r: allRecs)
            {
                if(r.getIndex() == 3)
                    high.add(r);
                else if(r.getIndex() == 2)
                     med.add(r);
                else if(r.getIndex() ==  1)
                    low.add(r);
            }
        }
        ArrayList<Recommendation> finalList = new ArrayList<Recommendation>();
        
        for(int i = 0 ; i < nHigh; i++)
        {
            if(i < high.size() )
                finalList.add(high.get(i));
        }
        for(int i = 0 ; i < nMed; i++)
        {
            if(i < med.size() )
                finalList.add(med.get(i));
        }
        for(int i = 0 ; i < nLow; i++)
        {
            if(i < low.size() )
                finalList.add(low.get(i));
        }
      
        return finalList;
        
    }
    
    public static int randInt(int min, int max) {

    // Usually this can be a field rather than a method variable
        Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
    }
}

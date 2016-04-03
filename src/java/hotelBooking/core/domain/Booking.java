/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.domain;

/**
 *
 * @author PANDA Sourav
 */
public class Booking {
    
    private String userID;
    private String roomID;
    private String hotelID;
    private String CityID;
    
    

    public Booking(String HotelID, String RoomID, String UserID,String CityID) {
       
            setHotelID(HotelID);
            setRoomID(RoomID);
            setUserID(UserID);
            setCityID(CityID);
         }

   

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public void setCityID(String CityID) {
       
        this.CityID = CityID;
    }
    
    public String getCityID()
            
    {
       return this.CityID; 
    }
}

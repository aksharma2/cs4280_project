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
    
    

    public Booking(String HotelID, String RoomID, String UserID) {
       
            setHotelID(HotelID);
            setRoomID(RoomID);
            setUserID(UserID);
         }

    public Booking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}

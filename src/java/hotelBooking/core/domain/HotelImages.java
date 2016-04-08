/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.domain;

/**
 *
 * @author aksharma2
 */
public class HotelImages {
    
    private String hotelId;
    private String hotelName;
    private String hotelCity;
    private String hotelImg;
    
    public String getHotelId() {
        return hotelId;
    }

    public String getHotelCity() {
        return hotelCity;
    }
    
    public String getHotelName(){
        return hotelName;
    }
    
    public void setHotelName(String hotelName){
        this.hotelName=hotelName;
    }

    public String getHotelImg() {
        return hotelImg;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }
    
    public void setHotelImg(String hotelImg){
        this.hotelImg=hotelImg;
    }
    
    
}


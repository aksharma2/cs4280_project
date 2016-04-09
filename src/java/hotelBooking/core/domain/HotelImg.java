/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.domain;

/**
 *
 * @author shrankhla
 */
public class HotelImg {
    
    private int HID;
    private String HName;
    private String HCity;
    private String HURL;
    
    public HotelImg (int id , String name , String city , String hURL)
            
    {
        this.HID=id;
        this.HName=name;
        this.HCity=city;
        this.HURL=hURL;
    }
    
    public void setID(int id)
    {
        this.HID=id;
    }
    
    public int getHID()
    {
        return this.HID;
    }
    
    public void setHName(String name)
    {
        this.HName=name;
    }
    
    public String getHName()
            
    {
        return this.HName;
    }
    
    public void SetHCity(String city)
            
    {
        this.HCity=city;
    }
    
    public String getHCity()
    {
        return this.HCity;
    }
    
    public void SetHURL(String HURL)
    {
        this.HURL=HURL;
    }
    
    public String getHURL()
            
    {
        return this.HURL;
    }
            
    
    
}

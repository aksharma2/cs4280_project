/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.domain;

import java.util.ArrayList;

/**
 *
 * @author PANDA Sourav
 */
public class Hotel {
    
    private String name;
    private String id;
    private String city;
    private int price;
    private ArrayList<String>hotelImgs;
    
    public Hotel(){
        hotelImgs=new ArrayList<String>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setImg(String img){
        hotelImgs.add(img);
    }
    
    public ArrayList<String> getImg(){
        return hotelImgs;
    }

}

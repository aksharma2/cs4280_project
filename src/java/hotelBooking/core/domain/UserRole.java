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
public class UserRole {
    
    public static final int ADMIN = 0;
    public static final int HOTEL_MANAGER = 1;
    public static final int CUSTOMER = 2;
    public static final int AUTHENTICATED = 3;
    
    private int role = -1;

    
    public UserRole(int aRole)//e.g. CSUTOMER, HOTEL_MANAGER
    {
        if(aRole == ADMIN || aRole == HOTEL_MANAGER || aRole == CUSTOMER)
            this.role = aRole;
        else
            this.role = -1;
    }
    
    public UserRole(String name)
    {
        if(name.equals("ROLE_ADMIN"))
            role = ADMIN;
        else if(name.equals("ROLE_HOTEL_MANAGER"))
            role = HOTEL_MANAGER;
        else if(name.equals("ROLE_CUSTOMER"))
            role = CUSTOMER;
        else
            role = -1;
    }
    
    
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
    public boolean checkPreviledge(ArrayList<UserRole> rolesAssignedToUser)
    {
        if(rolesAssignedToUser == null || rolesAssignedToUser.size() < 1)
            return false;
        
        
        for(UserRole r : rolesAssignedToUser)
        {
            if(r.getRole() == this.role)
                return true;
        }
        
        return false;
        
    }
    
    public String getRoleName()
    {
        if(role > -1)
        {
            switch(role)
            {
                case ADMIN:
                    return "ROLE_ADMIN";
                case HOTEL_MANAGER:
                    return "ROLE_HOTEL_MANAGER";
                case CUSTOMER:
                    return "ROLE_CUSTOMER";
                default:
                    return null;
            }
        }
        
        return null;
    
    }
}

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
public class User {
    
    private String name;
    private String id;

    private boolean isManager = false;
    private boolean isAdmin   = false;

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public User() {
        
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

    public void setId(String userID) {
        this.id = userID;
    }
    
    
}

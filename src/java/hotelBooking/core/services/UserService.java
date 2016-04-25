/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.services;

import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.domain.UserRole;
import hotelBooking.core.jdbc.UserDBHandler;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PANDA Sourav
 */
public class UserService {
 
    //Register a new User --> exmple registerServlet
    public static boolean registerUser(UserCredential u)
    {
        boolean success = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            success = db.registerUser(u);
        }
        db.closeConnection();
        return success;
    }
    
    //FInd User (OverLoading), returns all users registered
    public static ArrayList<User> findUser()
    {
        ArrayList<User> allusers = null;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            allusers = db.findUser();
            for(User u: allusers)
            {
                if(u !=  null)
                {
                ArrayList<UserRole> assignedRoles = findRolesAssignedToUser(u);
                UserRole admin = new UserRole(UserRole.ADMIN);
                UserRole hotel_manager = new UserRole(UserRole.HOTEL_MANAGER);
                if(admin.checkPreviledge(assignedRoles))
                    u.setIsAdmin(true);
                if(hotel_manager.checkPreviledge(assignedRoles))
                    u.setIsManager(true);
                
                }
            
            }
        }
        db.closeConnection();
        return allusers;
    
    }
    
    //Returns User Instance for only 1 id
    public static User findUser(String id)
    {
       
        User u = null;
        UserDBHandler db = null;
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            u = db.findUser(id);
            
            if(u !=  null)
            {
                ArrayList<UserRole> assignedRoles = findRolesAssignedToUser(u);
                UserRole admin = new UserRole(UserRole.ADMIN);
                UserRole hotel_manager = new UserRole(UserRole.HOTEL_MANAGER);
                if(admin.checkPreviledge(assignedRoles))
                    u.setIsAdmin(true);
                if(hotel_manager.checkPreviledge(assignedRoles))
                    u.setIsManager(true);
                
            }
            
        }
        db.closeConnection();
        return u;
        
    
    }
    
    //DeleteUserServlet <-- see this one
    public static boolean deleteUser(String id)
    {
        boolean success = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            success = db.deleteUser(id);
        }
        db.closeConnection();
        return success;
    }
    
    //Drops the entire table
    public static boolean dropUserTables()
    {
        boolean success = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            success = db.clearTable();
        }
        db.closeConnection();
        return success;
    }
    
    //authenticates user
    public static boolean authenticate(UserCredential cred)
    {
       
        boolean isAuthenticated = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            User u = db.findUser(cred.getUserID());
            if(u != null)
            {
                isAuthenticated = db.checkPassword(cred);
            }
            else
            {
                isAuthenticated =  false;
            }
            
        }
        db.closeConnection();
        return isAuthenticated;
    
    }
    
    public static ArrayList<UserRole> findRolesAssignedToUser(User u)
    {
        if(u == null)
            return null;
        
        ArrayList<UserRole> allroles = null;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            allroles = db.getRolesAssignedToUser(u);
        }
        db.closeConnection();
        return allroles;
    
    }
    
    public static boolean editUserAccess(User user, ArrayList<UserRole> assignedRoles)
    {
        boolean success = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            success = db.editUserAccess(user, assignedRoles);
        }
        db.closeConnection();
        return success;
    }
    
    public static boolean checkForAccess(HttpServletRequest request, int roleType)
    {
        UserRole requiredRole = new UserRole(roleType);
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        
        if(roleType == UserRole.AUTHENTICATED && user!= null)
            return true;
        
        
        ArrayList<UserRole> assignedRoles = UserService.findRolesAssignedToUser(user);
        return requiredRole.checkPreviledge(assignedRoles);
        
    }
    
    public static boolean checkHotelMangerMapping(String hotelId, String managerID)
    {
        boolean success = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            success = db.checkIfHotelBelongsToManager(hotelId, managerID);
        }
        db.closeConnection();
        return success;
        
    }
    
    public static boolean deleteHotelManager(String id)
    {
        boolean success = false;
        UserDBHandler db = new UserDBHandler();
        db = new UserDBHandler();
        if(db.setupConnection())
        {
            success = db.deleteHotelThatBelongsToManager(id);
        }
        db.closeConnection();
        return success;
    }
    
}

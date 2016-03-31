/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

//import com.microsoft.sqlserver.jdbc.SQLServerException;
import hotelBooking.core.domain.User;
import hotelBooking.core.domain.UserCredential;
import hotelBooking.core.domain.UserRole;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PANDA Sourav
 */
public class UserDBHandler {
    
    Connection con;
    
    public boolean setupConnection()
    {
        boolean success = false;
       
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad056_db", "aiad056", "aiad056");
            success = true;
        }
        catch (ClassNotFoundException e) {
            success = false;
        } catch (SQLException e) {
            success = false;
        } finally {
            out.close();
        }
        
        return success;
    }
    
    public void closeConnection()
    {
        if(this.con!=null)
            try {
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean registerUser(UserCredential u)
    {
        boolean success = false;
        PreparedStatement pstmt;
        try {
            
            //Create Entry in the PROJ_USER table
            pstmt = con.prepareStatement("INSERT INTO [PROJ_USER] ( [Name], [ID] ) VALUES (?, ?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getUserID());
            
            int rowsUser = pstmt.executeUpdate();
            
            //Create entry in the PROJ_USERCRED table
            pstmt = con.prepareStatement("INSERT INTO [PROJ_USERCRED] ( [Name], [ID], [Password] ) VALUES (?, ?, ?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getUserID());
            pstmt.setString(3, u.getPassword());
            
            int rowsUserCred = pstmt.executeUpdate();
            
            if(rowsUser > 0 && rowsUserCred > 0)
                success = true;
        }
        catch (SQLException ex) {
            success = false;
        }
        return success;
    
    }
    
    public boolean clearTable()
    {
        boolean success = false;
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("DELETE FROM [PROJ_USER]");
            int rowsUser = pstmt.executeUpdate();
            
            pstmt = con.prepareStatement("DELETE FROM [PROJ_USERCRED]");
            int rowsUserCred = pstmt.executeUpdate();
            
            
            if(rowsUser > 0 && rowsUserCred > 0)
                success = true;
        }
        catch (SQLException ex) {
            success = false;
        }
        return success;
    
    }
    
    public boolean deleteUser(String id)
    {
        boolean success = false;
        PreparedStatement pstmt;
        try {
            
            //Create Entry in the PROJ_USER table
            pstmt = con.prepareStatement("DELETE FROM [PROJ_USER] WHERE [ID] = (?)");
            pstmt.setString(1, id);
            
            int rowsUser = pstmt.executeUpdate();
            
            //Create entry in the PROJ_USERCRED table
            pstmt = con.prepareStatement("DELETE FROM [PROJ_USERCRED] WHERE [ID] = (?)");
            pstmt.setString(1, id);
            
            int rowsUserCred = pstmt.executeUpdate();
            
            if(rowsUser > 0 && rowsUserCred > 0)
                success = true;
        }
        catch (SQLException ex) {
            success = false;
        }
        return success;
    
    }
    
    public ArrayList<User> findUser()
    {
        
        ArrayList<User> allusers = new ArrayList<User>();
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_USER]");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               User u = new User(rs.getString("Name"), rs.getString("ID"));
               allusers.add(u);
            }
            
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
         return allusers;
    }
    
    public User findUser(String id)
    {
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_USER] WHERE ID = (?)");
            pstmt.setString(1, id);
            User user = null;
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               if(rs.getString("Name")!=null && rs.getString("ID") != null)
               {
                    user = new User(rs.getString("Name"), rs.getString("ID"));
                    return user;
               }
            }
             
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
         return null;
    }
    
    public boolean checkPassword(UserCredential cred)
    {
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_USERCRED] WHERE ID = (?)");
            pstmt.setString(1, cred.getUserID());
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               String dbPassword = rs.getString("Password");
               String dbID = rs.getString("ID");
               
               if(cred.getUserID().equals(dbID) && cred.getPassword().equals(dbPassword))
                   return true;
            }
           
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
        return false;
    
    }
    
    
    public ArrayList<UserRole> getRolesAssignedToUser()
    {
        
        ArrayList<UserRole> allroles = new ArrayList<UserRole>();
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("SELECT * FROM [PROJ_USERROLEMAPPING] WHERE USERID = (?)");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
               String roleName = rs.getString("ROLEID");
               if(roleName != null){
                    UserRole u = new UserRole(roleName);
                    allroles.add(u);
               }
               
            }
            
        }
        catch (SQLException ex) {
            //DO nothing
        }
        
         return allroles;
    }
    
}

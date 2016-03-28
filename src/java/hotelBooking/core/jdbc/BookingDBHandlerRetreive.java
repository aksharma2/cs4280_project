/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.core.jdbc;

import hotelBooking.core.domain.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shrankhla
 */
public class BookingDBHandlerRetreive {
    
     boolean success = true;
    Connection con;
    Statement stmt;
    ResultSet rs;
    int numRows;
    
    
    public boolean makeConnection()
            
    {
        try
        {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

             con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad025_db", "aiad025", "aiad025");
             success=true;     
        }  catch (ClassNotFoundException e) {
            success = false;
        } catch (SQLException e) {
            success = false;
        } finally {
           
        }
        
        return success;
    }
    
    
     public boolean showMybookings()
            
    {
        boolean success= false;
        
        try
        {
              stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = stmt.executeQuery("SELECT * FROM [Booking] ");
            
            if (rs != null && rs.last() != false)
            {
            numRows = rs.getRow();
            rs.beforeFirst();
            }
            
            if(numRows>0)
            {
                success=true;
            }
            
        }catch(SQLException e)
            
        {
            success=false;
        }
       
        return success;
    }
    
    public Statement returnStatement()
    {
        return stmt;
    }
    
    public Connection getConnection()
    {
        return con;
    }
    
    public ResultSet getResultSet()
           
    {
        return rs;
    }
    
    public int returnNumOfRows()
            
    {
        return numRows;
    }
}

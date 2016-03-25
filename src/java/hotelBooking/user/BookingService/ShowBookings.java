/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.user.BookingService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shrankhla
 */
public class ShowBookings extends HttpServlet {

    public static int userCounts=1;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String action = request.getParameter("action");

        if (action != null) {
            // call different action depends on the action parameter
            if (action.equalsIgnoreCase("update")) {
                this.doUpdateEntry(request, response);
            }
          
        }

        this.doRetrieveEntry(request, response);
        
    }

    
    
    private void doRetrieveEntry(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         int numRow = 1;
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Show Bookings</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>All My Bookings</h1>");
            out.println("<div style='width:600px'>");
            out.println("<fieldset>");
            out.println("<legend>Booked Rooms</legend>");
            
            
                
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            
            Connection con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad025_db", "aiad025", "aiad025");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM [Booking] ");
            
            if (rs != null && rs.last() != false)
            {
            numRow = rs.getRow();
            rs.beforeFirst();
            }

           out.println("<p>Total"+numRow+"entries.</p>");
            out.println("<div><table style='width:100%'>");
            out.println("<thead>");
            out.println("<th align='left'>Hotel</th><th align='left'>Room Type</th><th align='left'>User Name</th>");
            out.println("</thead>");
            out.println("<tbody>");
            
            while(rs.next())
                
            {
                String hotel=rs.getString("hotelID");
                String room=rs.getString("roomID");
                String user=rs.getString("userID");
                
                
            out.println("<tr>");
            out.println("<td>" + this.htmlEncode(hotel) + "</td>");
            out.println("<td>" + this.htmlEncode(room) + "</td>");
            out.println("<td>" + this.htmlEncode(user) + "</td>");
             out.println("<td>");
            out.println("<a href='" + request.getRequestURI() + "?action=update&userid=" + user + "'>Update</a>");
           out.println("</td>");
             out.println("</tr>");
                
                
            }
            
            out.println("</tbody>");
            out.println("</table></div>");
          //  out.println("<br/><a href='" + request.getRequestURI() + "?action=create'>Add a New Phonebook Entry</a>");
            out.println("</fieldset>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
 
            
         } catch (ClassNotFoundException e) {
               out.println("<div style='color: red'>" + e.toString() + "</div>");
        } catch (SQLException e) {
               out.println("<div style='color: red'>" + e.toString() + "</div>");
        }

        finally {
            out.close();
        }
    }
    
     private void doUpdateEntry(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Show Bookings</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Boookings (Update)</h1>");
            out.println("<div style='width:600px'>");
            out.println("<fieldset>");
            
            
            String hotel = request.getParameter("hotels");
            String room = request.getParameter("rooms");
            String USERID= request.getParameter("userid");
            
             Statement stmt;
             ResultSet rs;
             Connection con=null;

            if (hotel != null && !hotel.equalsIgnoreCase("") &&
                room != null && !room.equalsIgnoreCase("")) 
            { 
                
                    
                  
                String userName= "User" + userCounts;
                // Register the JDBC driver, open a connection
                userCounts+=1;
                
                // Create a preparedstatement to set the SQL statement			 
                PreparedStatement pstmt = con.prepareStatement("UPDATE [Booking] SET [roomID] = ? , [hotelID] =?   WHERE [userID] = ?");

                pstmt.setString(1,hotel);
                pstmt.setString(2, room);
                pstmt.setString(3, USERID);
  
                // execute the SQL statement
                int rows = pstmt.executeUpdate();

                if (rows > 0) {
                    out.println("<legend>New record is sucessfully created.</legend>");
                    // display the information of the record just added including UID
                    stmt=con.createStatement();
                    rs=stmt.executeQuery("SELECT @@IDENTITY AS [@@IDENTITY]");
                    if(rs!=null && rs.next()!=false)
                    {
                        out.println("<p>UserID: "+USERID+"</p>");
                        rs.close();
                    }
                   
					
                    out.println("<p>Hotel:" + this.htmlEncode(hotel) + "</p>");
                    out.println("<p>Room:" + room + "</p>");
                }
                else {
                    out.println("<legend>ERROR: New Booking failed to Update.</legend>");
                }
            }
            else {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://w2ksa.cs.cityu.edu.hk:1433;databaseName=aiad025_db", "aiad025", "aiad025");
             
                String useridString=request.getParameter("userid");
                stmt=con.createStatement();
                rs=stmt.executeQuery("SELECT * FROM [Booking]");

                
                if (hotel == null) {
                    hotel = "";
                }
                if (room == null) {
                   room = "";
                }				
               out.println("<legend>Please fill in the form</legend>");
                out.println("<form method='POST' action='" + request.getRequestURI() + "'>");
                out.println("<input name='action' type='hidden' value='create' />");
                out.println("<p>Hotel:");
                out.println(" <select name=\"hotels\">\n" +
"    <option value=\"hyatt\">Hyatt</option>\n" +
"    <option value=\"radisson\">Radisson</option>\n" +
"    <option value=\"itc\">ITC</option>\n" +
"    <option value=\"leela\">Leela Palace</option>\n" +
"  </select></p>");
                out.println("<p>Room Type:");
                out.println(" <select name=\"rooms\">\n" +
"    <option value=\"single\">Single</option>\n" +
"    <option value=\"deluxe\">Deluxe</option>\n" +
"    <option value=\"suite\">Suite</option>\n" +
"    <option value=\"prsuite\">Presidential Suite</option>\n" +
"  </select></p>");
                
                out.println("<input type='submit' value='Make Booking!' />");
                out.println("</form>");
            
                 if (stmt !=null)
                        stmt.close();
            }
            
            out.println("</fieldset>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException e) {
            out.println("<div style='color: red'>" + e.toString() + "</div>");
        } catch (SQLException e) {
            out.println("<div style='color: red'>" + e.toString() + "</div>");
        } finally {
            out.close();
        }
		
         
     }
     
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

     private String htmlEncode(String s) {

        StringBuffer sb = new StringBuffer(s.length() * 2);

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if ((ch >= '?' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch == ' ') || (ch == '\n')) {
                sb.append(ch);
            }
            else {
                switch(ch) {
                    case '>':
                        sb.append("&gt;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#039;");
                        break;
                    case '"':
                        sb.append("&quot;");
                        break;
                    default:
                        sb.append("&#");
                        sb.append(new Integer(ch).toString());
                        sb.append(';');
                }
            }
        }

        return sb.toString();
    }

    
}

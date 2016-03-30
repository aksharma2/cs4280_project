

import hotelBooking.core.domain.Hotel;
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
 * @author PANDA Sourav
 */
public class HotelService extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

          response.setContentType("text/html;charset=UTF-8");
          String action = request.getParameter("action");
          PrintWriter out = response.getWriter();
         out.println("<html>");
         out.println("<br/><a href='" + request.getRequestURI() + "?action=register'>Add a new hotel</a>");
         out.println("<br/><a href='" + request.getRequestURI() + "?action=remove'>View & remove existing hotels</a>");
         out.println("<html>");
               if (action != null) {
            // call different action depending on the action parameter
                    if (action.equalsIgnoreCase("register")) {
                        this.registerHotel(request, response);
                    } 
                    if (action.equalsIgnoreCase("remove")) {
                        this.removeHotel(request, response);
                        
                    } 
                   
                }
         }   
    
    
    private void registerHotel(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     String url = "jdbc:mysql://localhost:3306/cs4280";
     String username = "root";
     String password = "dl4cne2577";
     
        try{
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Hotel register(Manager Access)</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div style='width:600px'>");
                out.println("<fieldset>");
                out.println("<legend>Add a new hotel(Manager)</legend>");
                out.println("<form method='GET' action='" + request.getRequestURI() + "'>");
                out.println("<input name='action' type='hidden' value='register' />");
                out.println("<p>Hotel:");
                out.println(" <select name=\"hotelname\">\n" +
                            "    <option value=\"hilton\">Hilton</option>\n" +
                            "    <option value=\"sheraton\">Sheraton</option>\n" +
                            "    <option value=\"royalplaza\">Royal Plaza</option>\n" +
                            "    <option value=\"grand\">Grand</option>\n" +
                            "    </select></p>");
           
                out.println("<p>City:");
                out.println(" <select name=\"hotelcity\">\n" +
                            "    <option value=\"hk\">HK</option>\n" +
                            "    <option value=\"london\">London</option>\n" +
                            "    <option value=\"paris\">Paris</option>\n" +
                            "    <option value=\"ny\">New York</option>\n" +
                            "    </select></p>");
                
                out.println("<p>Hotel id:");
                out.println("<input name='hotelid' value='' type='text' size='15' maxlength='15'> ");
                
                out.println("<input type='submit' value='register!' />");
                out.println("</form>");        
                out.println("</fieldset>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");

                Hotel h=new Hotel();
                h.setId(request.getParameter("hotelid"));        //values obtained from form submission
                h.setName(request.getParameter("hotelname"));
                h.setCity(request.getParameter("hotelcity"));

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,username,password);
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO hotel VALUES (?, ?, ?)");
                pstmt.setString(1, h.getId());
                pstmt.setString(2, h.getName());
                pstmt.setString(3, h.getCity());
                int rows= pstmt.executeUpdate();

                if(rows>0) {
                    out.println("Hotel succesfully added");
                    Statement st=con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT @@IDENTITY AS [@@IDENTITY]");

                    if (rs != null && rs.next() != false) {
                        out.println("<p>Hotel Id: " + (h.getId()) + "</p>");
                        out.println("<p>Hotel name:" + (h.getName()) + "</p>");
                        out.println("<p>City:" + (h.getCity()) + "</p>");
                        rs.close();
                    }
                }    
            
        }catch(SQLException e){
          //out.println("<div style='color: red'>" + e.toString() +  "</div>");
        }catch(ClassNotFoundException e){
          out.println("<div style='color: red'>" + e.toString() +  "</div>");
        }finally {
          out.close();
        }
    
    }
    
    
    
    private void removeHotel(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     String url = "jdbc:mysql://localhost:3306/cs4280";
     String username = "root";
     String password = "dl4cne2577";
    
     try{
         
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hotel");
            
            out.println("<html>");
            out.println("<body>");
            out.println("<div style='width:600px'>");
            out.println("<fieldset>");
            out.println("<legend>Current hotels</legend>");
            out.println("<form action='" + request.getRequestURI() + "'>");
            out.println("<input name='action' type='hidden' value='remove' />");
            out.println("<div><table style='width:100%'>");
            out.println("<thead>");
            out.println("<th align='left'>Hotel Id</th><th align='left'>Hotel Name</th><th align='left'>City</th><th align='left'>Action</th>");
            out.println("</thead>");
            out.println("<tbody>");
            
             while (rs != null && rs.next() != false) {
                 
                 String hotelId=rs.getString("hotelid");
                 String hotelName=rs.getString("hotelname");
                 String hotelCity=rs.getString("hotelcity");
                 
                 out.println("<tr>");
                 out.println("<td>" + hotelId + "</td>");
                 out.println("<td>" + this.htmlEncode(hotelName) + "</td>");
                 out.println("<td>" + hotelCity + "</td>");
                 out.println("<td> <a href='"+request.getRequestURI()+ "?id="+hotelId+"&action=remove '>Remove </a>" );
                 out.println("</td></form>");                 
                 out.println("</tr>");
            }
             
                out.println("</tbody>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
                String sql="DELETE FROM hotel WHERE hotelid = '"+request.getParameter("id")+ "'" ;
                int rows=stmt.executeUpdate(sql);
                
                if(rows>0)
                    response.sendRedirect(request.getRequestURI()+"?action=remove");
                                
        }catch(SQLException e){
          out.println("<div style='color: red'>" + e.toString() +  "</div>");
        }catch(ClassNotFoundException e){
          out.println("<div style='color: red'>" + e.toString() +  "</div>");
        }finally {
          out.close();
                  
        }

    }   
    
    
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
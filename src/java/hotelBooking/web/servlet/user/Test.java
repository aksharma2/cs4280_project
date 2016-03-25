/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.user;

import hotelBooking.core.domain.User;
import hotelBooking.core.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PANDA Sourav
 */
public class Test extends HttpServlet {

    private String message;

  public void init() throws ServletException
  {
      // Do required initialization
      message = "Panda Hello World";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
        String nextJSP = "/Views/User/test.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
  }
  
  public void destroy()
  {
      // do nothing.
  }

}

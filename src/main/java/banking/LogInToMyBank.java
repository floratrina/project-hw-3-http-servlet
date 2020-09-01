package banking;


/*
  Please implement servlet life cycle so that user from the browser can enter account number and pin number.
  After receiving the request, please parse the the user data and send the response to the client.

  After implementing servlet,web.xml and index.jsp, deploy on Tomcat Server
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="LogIn", urlPatterns = "/login")
public class LogInToMyBank extends HttpServlet {

    //implement initialize method
    public String message;

    public void init() throws ServletException{
        System.out.println("......Initializing Servlet...........");
        message="Welcome to Bank";
    }


    //implement doGet method

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>" + message +"<h1>");
        System.out.println("Servlet called doGet method");
    }


    //implement doPost method
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if(userName.equalsIgnoreCase("sophia") && password.equalsIgnoreCase("1234abcd")) {
            resp.setContentType("text/xml");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<h1>" + "You are authorized user. Welcome to Bank" + "<h1>");
            System.out.println("Servlet called doPost method");
        } else {
            resp.setContentType("text/xml");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<h1>" + "You are not an authorized user." + "<h1>");
            System.out.println("Servlet called doPost method");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet");
    }


}

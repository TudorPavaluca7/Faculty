package Servlets;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Win extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Guess the number</title></head>");
        out.println("<body><h3>You won</h3>");
        out.println("<a href=\""+request.getContextPath()+"/\">Try again</a>");
        out.println("</body>");
        out.println("</html>");


    }


}


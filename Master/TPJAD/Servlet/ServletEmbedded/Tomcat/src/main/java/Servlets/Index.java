package Servlets;

import Model.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Index extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {



        String cssTag="<link rel='stylesheet' type='text/css' href='Utils/styles.css'>";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Guess the number</title>"+cssTag+"</head>");
        out.println("<body><h1>Guess the number</h1>");
        out.println("<div class='start'>");
        out.println("<form action=\""+request.getContextPath()+"/start-game\" method=\"post\"> <br>");
        out.println("<label >Min Range </label>");
        out.println("<input type=\"text\"  name=\"minRange\" > <br>");
        out.println("<label >Max Range </label>");
        out.println("<input type=\"text\"  name=\"maxRange\" > <br>");
        out.println("<label >Select nr of attempts:</label>");
        out.println("<input type=\"text\"  name=\"nrOfAttempts\" > <br>");
        out.println("<input type=\"submit\" value=\"Submit\">");




        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");



    }



}

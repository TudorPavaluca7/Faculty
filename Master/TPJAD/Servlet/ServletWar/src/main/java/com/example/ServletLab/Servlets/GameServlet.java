package com.example.ServletLab.Servlets;

import com.example.ServletLab.Model.Game;
import com.example.ServletLab.Utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/game-servlet")
public class GameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {


        HttpSession session=request.getSession(false);
        Game game = (Game) session.getAttribute("game");
        String attemptsLeft = String.valueOf(game.getNrOfAttemptsLeft());
        String cssTag="<link rel='stylesheet' type='text/css' href='styles.css'>";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Guess the number</title>"+cssTag+"</head>");
        out.println("<body><h1>Guess the number</h1>");
        out.println("<form action=\"game-servlet\" method=\"post\"></br>");
        out.println("Choose a value: <input type=\"text\"  name=\"userValue\"><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("<div>"+game.getUserMessage()+"</div>");
        out.println("<div>Number of attempts left: "+attemptsLeft+" </div>");




        out.println("</form>");
        out.println("</body>");
        out.println("</html>");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userValue = request.getParameter("userValue");
        String errorMessage= Util.validateGameInput(userValue);
        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", "The input value must be an integer");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
        else {
            int userValueConverted = Integer.parseInt(userValue);
            HttpSession session = request.getSession();
            Game game = (Game) session.getAttribute("game");

            game.setNrOfAttemptsLeft(game.getNrOfAttemptsLeft() - 1);

            String userMessage;

            if (game.getRandomValue() == userValueConverted) {
                request.setAttribute("result", "You won");
                request.getRequestDispatcher("result.jsp").forward(request, response);
            } else {

                if (game.getNrOfAttemptsLeft() == 0) {
                    request.setAttribute("result", "You lost");
                    request.getRequestDispatcher("result.jsp").forward(request, response);
                }

                else {
                    if (game.getRandomValue() < userValueConverted)
                        userMessage = "Number is too high. Try Again!";
                    else
                        userMessage = "Number is too low. Try Again!";
                    game.setUserMessage(userMessage);
                    session.setAttribute("game", game);
                    //request.getRequestDispatcher("game.jsp").forward(request, response);
                    response.sendRedirect(request.getHeader("referer"));
                }
            }


        }
    }


}

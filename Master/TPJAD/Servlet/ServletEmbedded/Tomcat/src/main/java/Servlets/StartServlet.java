package Servlets;

import Model.Game;
import Utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;


public class StartServlet extends HttpServlet {



    public void init() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        String minRange = request.getParameter("minRange");
        String maxRange = request.getParameter("maxRange");
        String nrOfAttempts = request.getParameter("nrOfAttempts");

        String errorMessage= Util.validateStartInput(minRange, maxRange, nrOfAttempts);

        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);

            request.getRequestDispatcher(request.getContextPath()+"/error").forward(request, response);
        }
        else {
            int min = Integer.parseInt(minRange);
            int max = Integer.parseInt(maxRange);
            Random r = new Random();
            int generatedRandom = r.nextInt(max - min) + min;
            Game game = new Game(Integer.parseInt(nrOfAttempts), generatedRandom, Integer.parseInt(nrOfAttempts));

            HttpSession session = request.getSession();
            session.setAttribute("game", game);
            response.sendRedirect(request.getContextPath() + "/game-servlet");
        }

    }

    public void destroy() {
    }




}

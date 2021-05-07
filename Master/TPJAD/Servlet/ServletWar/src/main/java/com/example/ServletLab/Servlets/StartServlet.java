package com.example.ServletLab.Servlets;

import com.example.ServletLab.Model.Game;
import com.example.ServletLab.Utils.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/start-game")
public class StartServlet extends HttpServlet {





    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        String minRange = request.getParameter("minRange");
        String maxRange = request.getParameter("maxRange");
        String nrOfAttempts = request.getParameter("nrOfAttempts");

        String errorMessage= Util.validateStartInput(minRange, maxRange, nrOfAttempts);
        if (!errorMessage.isEmpty()) {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("error.jsp").forward(request, response);
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






}

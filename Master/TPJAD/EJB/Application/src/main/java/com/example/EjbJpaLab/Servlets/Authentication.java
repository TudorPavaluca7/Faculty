package com.example.EjbJpaLab.Servlets;

import com.example.EjbJpaLab.Interfaces.UserService;
import com.example.EjbJpaLab.Util.Utils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/auth")
public class Authentication extends HttpServlet {

    @EJB
    private UserService UserBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect(req.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Long userId = UserBean.validate(username, password);
        System.out.println(userId);
        if (username.isEmpty() || password.isEmpty())
            Utils.displayError(resp,1);
        else
        {
            if (userId>0) {

                HttpSession session = req.getSession();
                session.setAttribute("user", userId);
                resp.sendRedirect("books.jsp");

            }
            else
                Utils.displayError(resp,2);
        }


    }


}

package com.example.EjbJpaLab.Servlets;

import com.example.EjbJpaLab.Beans.BookBean;
import com.example.EjbJpaLab.Interfaces.BookService;
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

@WebServlet("/returnBook")
public class ReturnBook extends HttpServlet {

    @EJB
    private UserService UserBean;
    @EJB
    private BookService BookBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        HttpSession session = request.getSession();
        Long userId=(Long) session.getAttribute("user");
        Long bookId = UserBean.containsBook(userId, title, author);

        if (title.isEmpty() || author.isEmpty())
            Utils.displayError(response, 1);
        else {
            if (bookId > 0) {
                BookBean.returnBook(bookId, userId);
                response.sendRedirect("borrowedBooks.jsp");
            }
            else
                Utils.displayError(response, 3);
        }
    }




}

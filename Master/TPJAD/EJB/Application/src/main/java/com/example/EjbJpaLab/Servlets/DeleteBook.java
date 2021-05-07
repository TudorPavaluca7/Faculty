package com.example.EjbJpaLab.Servlets;

import com.example.EjbJpaLab.Interfaces.BookService;
import com.example.EjbJpaLab.Util.Utils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {
    @EJB
    private BookService BookBean;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Long bookId = BookBean.validate(title, author);

        if (title.isEmpty() || author.isEmpty())
            Utils.displayError(response, 1);
        else {
            if (bookId > 0) {
                BookBean.deleteBook(bookId);
                response.sendRedirect("books.jsp");
            }
            else
                Utils.displayError(response, 3);
        }
    }
}

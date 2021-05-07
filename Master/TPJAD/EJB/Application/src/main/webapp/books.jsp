<%@ page import="javax.ejb.EJB" %>
<%@ page import="com.example.EjbJpaLab.Interfaces.BookService" %>
<%@ page import="java.util.Properties" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="com.example.EjbJpaLab.Models.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tudor
  Date: 23.01.2021
  Time: 01:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookService bookService;
    Context context;



        Properties JNDIProps = new Properties();
        JNDIProps.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        JNDIProps.setProperty("java.naming.provider.url", "http-remoting://localhost:8083");
        context = new InitialContext(JNDIProps);
        bookService = (BookService) context.lookup("EjbJpaLab/BookBean!com.example.EjbJpaLab.Interfaces.BookService");
        List<Book> books = bookService.findAll();




%>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="books.css">
</head>
<body>

<table id="books">
    <tr>
        <th>Title</th>
        <th>Author</th>

    </tr>
    <%
        for (Book b: books) {
    %>
    <tr>

        <td><%=b.getTitle()%></td>
        <td><%=b.getAuthor()%></td>

    </tr>
    <%
        }
    %>
</table>

<div class="flex-container">

       <div>
        <form action="<%= request.getContextPath() %>/borrowedBooks.jsp" method="get">
            <br>
            <br>
            <br>
            <br>
            <label class="name">View your books</label>
            <input type="submit" value="View">
        </form>
       </div>
    <div>
        <form action="<%= request.getContextPath() %>/addBook" method="post">
            <label class="name">Add a new book</label> <br>
          <label >Title </label>
            <input type="text"  name="title" > <br>

          <label >Author </label>
        <input type="text"  name="author" > <br>



        <input type="submit" value="Add">
    </form>
    </div>
    <div>
        <form action="<%= request.getContextPath() %>/borrowBook" method="post">
            <label class="name">Borrow a book</label> <br>
            <label >Title </label>
            <input type="text"  name="title" > <br>

            <label >Author </label>
            <input type="text"  name="author" > <br>



            <input type="submit" value="Borrow">
        </form>
    </div>
    <div>
        <form action="<%= request.getContextPath() %>/deleteBook" method="post">
            <label class="name">Delete a book</label> <br>
            <label >Title </label>
            <input type="text"  name="title" > <br>

            <label >Author </label>
            <input type="text"  name="author" > <br>



            <input type="submit" value="Delete">
        </form>
    </div>
    <div>
        <form action="<%= request.getContextPath() %>/auth" method="get">
            <br>
            <br>
            <br>
            <input type="submit" value="Logout">
        </form>
    </div>
</div>

</body>
</html>


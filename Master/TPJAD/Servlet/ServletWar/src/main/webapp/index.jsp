<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1><%= "Guess the number" %> </h1>
<br/>



<div class="start">
    <form action="<%= request.getContextPath() %>/start-game" method="post">
        <label >Min Range </label>
        <input type="text"  name="minRange" > <br>

        <label >Max Range </label>
        <input type="text"  name="maxRange" > <br>

        <label >Select nr of attempts:</label>
        <input type="text"  name="nrOfAttempts" > <br>

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="box">
    <h2>Login</h2>
    <form action="<%= request.getContextPath() %>/auth" method="post">
        <div class="inputBox">
            <input type="text" name="username" >
            <label>Username</label>
        </div>
        <div class="inputBox">
            <input type="password" name="password">
            <label>Password</label>
        </div>
        <input type="submit" name="sign-in" value="Sign In">
    </form>
</div>

<script>

</script>

</body>
</html>

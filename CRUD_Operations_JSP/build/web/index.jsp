<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
    <center>
        <form action="loginServlet" method="get">
            <h1>Login Page!</h1>
            <br><br>
            <input type="text" placeholder="Enter Username" name="username">
            <br><br>
            <input type="Password" placeholder="Enter Password" name="password">
            <br><br>
            <input type="submit" value="Login">
            <br><br>
            <a href="register.jsp">Register Here!</a>
        </form>
    </center>
    </body>
</html>

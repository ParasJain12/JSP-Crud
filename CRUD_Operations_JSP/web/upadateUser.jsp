<%@page import="Dao.UserDao"%>
<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String mobile = request.getParameter("mobile");
    User user = new User(2,name,username,email,password,mobile);
    UserDao u = new UserDao();
    boolean result = u.updateUser(user);
    if(result)
    {
        response.sendRedirect("userhome.jsp");
    }
    else{
        out.print("<h1>Record not update...</h1>");
    }
%>
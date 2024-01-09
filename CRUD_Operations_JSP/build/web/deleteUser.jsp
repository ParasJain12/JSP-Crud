<%@page import="Dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    if(id != null)
    {
        int uid = Integer.parseInt(id);
        UserDao u = new UserDao();
        boolean result = u.deleteUser(uid);
        if(result)
        {
            response.sendRedirect("adminhome.jsp");
        }
        else{
            out.print("<h1>Data not delete...</h1>");
        }
    }
%>
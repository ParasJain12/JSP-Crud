<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession ses = request.getSession();
    User user = (User) ses.getAttribute("user");
    if(user != null)
    {
        ses.removeAttribute("user");
        ses.invalidate();
        response.sendRedirect("index.jsp");
    }
%>
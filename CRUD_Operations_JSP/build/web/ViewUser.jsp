<%@page import="bean.User"%>
<%@page import="Dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    if(id != null)
    {
        int uid = Integer.parseInt(id);
        UserDao u = new UserDao();
        User user = u.viewUser(uid);
        if(user != null)
        {
%>
<h1>
    <%= user.getId() %> : <%= user.getName() %> : <%= user.getUsername() %> : <%= user.getEmail() %> :
    <%= user.getPassword() %> : <%= user.getMobile() %>
</h1>
<%
        }
    }
%>
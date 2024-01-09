<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.UserDao"%>
<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   
   HttpSession ses = request.getSession();
   User user = (User) ses.getAttribute("user");
   
    UserDao u = new UserDao();
    ArrayList<User> alUser = u.getAllUserData();
    Iterator<User> itr = alUser.iterator();
  
%>

<html>
 <body bgcolor="yellowgreen">
  <h5 style="float:right">
    <%
     out.print(user.getName());
    %>    
    &nbsp;&nbsp
   <a style="float:right" href='logout.jsp'>Logout</a>
  </h5>
  <center>
    <table border='2px' cellspacing="7px" cellpadding='7px'> 
     <tr>
     <th>Id</th>
     <th>Name</th>
     <th>Username</th>
     <th>Mobile</th>
     <th>Operation</th>
     
    </tr>
    <%
       while(itr.hasNext())
       {
         User us = itr.next();
    %>
       <tr>
           <td><% out.print(us.getId()); %></td>
           <td><% out.print(us.getName()); %></td>
           <td><% out.print(us.getUsername()); %></td>
           <td><% out.print(us.getMobile()); %></td>
           <td><a href='viewUser.jsp?id=<% out.print(us.getId()); %>'>View</a> | <a href='deleteUser.jsp?id=<% out.print(us.getId());%>'>Delete</a></td>
       </tr>
    <%
     }
    %>   
    </table>  
  </center>    
 </body>    
</html>
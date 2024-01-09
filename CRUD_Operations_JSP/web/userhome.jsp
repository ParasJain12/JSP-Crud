<%@page import="Dao.UserDao"%>
<%@page import="Dao.UserDao"%>
<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   
   HttpSession ses = request.getSession();
   User user = (User) ses.getAttribute("user");
   
   UserDao dao = new UserDao();
   User u = dao.viewUser(user.getId());
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
     <h1>Update Record..</h1> 
     <form action="upadteUser.jsp" method="get"> 
     <input type="text" placeholder="Enter Name"
            name="name" value="<%out.print(u.getName());%>">
     <br><br>
     <input type="text" placeholder="Enter User Name" readonly
            name="username" value="<%out.print(u.getUsername());%>">
     <br><br>
     <input type="email" placeholder="Enter Email" readonly
            name="email" value="<%out.print(u.getEmail());%>">
     <br><br>
     <input type="password" placeholder="Enter Password"
            name="password" value="<%out.print(u.getPassword());%>">
     <br><br>
     <input type="text" placeholder="Enter Mobile"
            name="mobile" value="<%out.print(u.getMobile());%>">
     <br><br>
     <input type="submit" value="Update">
           
    </form>    
  </center>    
 </body>    
</html>
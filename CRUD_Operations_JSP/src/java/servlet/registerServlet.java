package servlet;

import Dao.UserDao;
import bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try
        {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String mobile = request.getParameter("mobile");     
            int type=2;
            User user = new User(type,name,username,email,password,mobile);
            UserDao u = new UserDao();
            int result = u.registerUser(user);
            if(result > 0)
            {
                response.sendRedirect("index.jsp");
            }
            else{
                System.out.println("Register failed...");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

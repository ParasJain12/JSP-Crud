package servlet;

import Dao.UserDao;
import bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.SystemConstants;

public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDao u = new UserDao();
            User user = u.loginUser(username, password);
            if(user != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                if(user.getType() == SystemConstants.ADMIN)
                {
                    response.sendRedirect("adminhome.jsp");
                }
                if(user.getType() == SystemConstants.USER)
                {
                    response.sendRedirect("userhome.jsp");
                }
            }
            else{
                System.out.println("Login failed....");
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

package Dao;

import Connection.GetConnection;
import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {
    Connection con;
    public UserDao()
    {
        con = GetConnection.getConnection();
    }
    public int registerUser(User user)
    {
        int result = 0;
        if(con != null)
        {
            try
            {
                String sql = "insert into user(name,username,email,password,mobile,type)values(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,user.getName());
                ps.setString(2,user.getUsername());
                ps.setString(3,user.getEmail());
                ps.setString(4,user.getPassword());
                ps.setString(5,user.getMobile());
                ps.setInt(6,user.getType());
                result = ps.executeUpdate();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        return result;
    }
    public User loginUser(String username,String password)
    {
        User user = null;
        if(con != null)
        {
            try
            {
                String sql = "select * from user where username=? and password=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                
                ResultSet res = ps.executeQuery();
                if(res.next())
                {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String uname = res.getString("username");
                    String email = res.getString("email");
                    String pword = res.getString("password");
                    String mobile = res.getString("mobile");
                    int type = res.getInt("type");
                    user = new User(id,type,name,username,email,password,mobile);
                }
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        else{
            System.out.println("Register Connection failed...");
        }
        return user;
    }
    public ArrayList<User> getAllUserData()
    {
       ArrayList<User> alUser = new ArrayList<>();
     
       if(con != null)
       {
         try
         {
           String sql = "select * from user";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet res = ps.executeQuery();
           while(res.next())
           {
           int id = res.getInt("id");
           String name = res.getString("name");
           String uname = res.getString("username");
           String email = res.getString("email");
           String pass = res.getString("password");
           String mobile = res.getString("mobile");
           int type = res.getInt("type");
        
           User user = new User(id,type, name, uname, email, pass, mobile);
           alUser.add(user);
          }
        }
        catch(Exception ex)
        {
          System.out.println("getAllUserData : "+ex.toString());
        }
     }
     else
     {
       System.out.println("getAllUserData Connection Problem : ");
     }
     return alUser;
  }
   public boolean deleteUser(int id)
  {
    boolean result=false;   
    if(con != null)
    {
      try
      {
        String sql = "delete from user where id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, id);
        
        int res = ps.executeUpdate();
        if(res>0)
        {
           result = true;
        }
        
      }
      catch(Exception ex)
      {
        System.out.println("Delete User : "+ex.toString());
      }
    }
    else
    {
        System.out.println("Delete Connection Failed...");
    }
    return result;
  }
   public User viewUser(int uid)
  {
     User user=null;   
    if(con != null)
    {
      try
      {
        String sql = "select * from user where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, uid);
        
        ResultSet res = ps.executeQuery();
        if(res.next())
        {
           int id = res.getInt("id");
           String name = res.getString("name");
           String uname = res.getString("username");
           String email = res.getString("email");
           String pass = res.getString("password");
           String mobile = res.getString("mobile");
           int type = res.getInt("type");
        
           user = new User(id,type, name, uname, email, pass, mobile);
        }
        
      }
      catch(Exception ex)
      {
        System.out.println("View User : "+ex.toString());
      }
    }
    else
    {
        System.out.println("View Connection Failed...");
    }
    return user;
  }
   public boolean updateUser(User u)
  {
    boolean result = false;
    if(con != null)
    {
      try
      {
        String sql = "update user set name=?,password=?,mobile=? where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, u.getName());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getMobile());
        ps.setString(4, u.getUsername());
        
        int res = ps.executeUpdate();
        if(res>0)
        {
            result = true;
        }
        
      }
      catch(Exception ex)
      {
        System.out.println("Update User : "+ex.toString());
      }
    }
    else
    {
        System.out.println("Update Connection Failed...");
    }
    return result;
  }
}


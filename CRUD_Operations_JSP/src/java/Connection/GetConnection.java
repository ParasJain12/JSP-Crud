package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.SystemConstants;

public class GetConnection {
    static Connection con = null;
    public static Connection getConnection()
    {
        try
        {
            Class.forName(SystemConstants.DRIVER);
            con = DriverManager.getConnection(SystemConstants.DB_USERNAME,SystemConstants.DB_PASSWORD,SystemConstants.URL);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e.toString());
        }
    return con;
    }   
}

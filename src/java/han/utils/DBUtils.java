package han.utils;

import jakarta.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author WINDOWS
 */
public class DBUtils extends HttpServlet {

    public static Connection makeConnection() throws SQLException {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databasename=WS_GameStore";
            Class.forName(driver);
            Connection cn = DriverManager.getConnection(url, "sa", "12345");
            return cn;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

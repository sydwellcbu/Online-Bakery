package za.online.db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToBD {

    private static final String url = "jdbc:mysql://localhost:3306/bakerystore?useSSL=false";
    private static final String userName = "mecer";
    private static final String password = "mecer";
    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection(url, userName, password);
                 System.out.println("Connection achieved");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("A connecton was not made. " + ex.getMessage());
            }
        }
        return con;
    }
}

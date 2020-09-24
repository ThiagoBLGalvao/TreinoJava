package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SchoolConnection {
    private static String DATABASE_URL = "jdbc:mysql://localhost:3306/School";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}

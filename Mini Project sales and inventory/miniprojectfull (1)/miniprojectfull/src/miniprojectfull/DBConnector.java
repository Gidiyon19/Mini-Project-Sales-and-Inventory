package miniprojectfull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/minipp";
    private static final String USER = "root";
    private static final String PASSWORD = "gidiyongidiyon22";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}

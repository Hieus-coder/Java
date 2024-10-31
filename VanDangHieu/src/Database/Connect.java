package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private Connection conn;

    public Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLSanpham;encrypt=true;trustServerCertificate=true;";
            conn = DriverManager.getConnection(connectionUrl, "sa", "12345");
            System.out.println("Connected.");
        } catch (ClassNotFoundException e) {
            System.out.println("Don't find driver JDBC: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Er: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        return conn;
    }
}

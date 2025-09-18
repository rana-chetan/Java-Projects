package banking;

import java.sql.DriverManager;

public class Connection {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }
}

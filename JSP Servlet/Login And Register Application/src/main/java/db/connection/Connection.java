package db.connection;

import java.sql.DriverManager;

public class Connection {

    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";
    private static final String PASSWORD = "chetan@123";

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

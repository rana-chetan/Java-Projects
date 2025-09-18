package controller;

import db.connection.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet("/view/register")
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (java.sql.Connection connection = Connection.getConnection()) {

            String checkQuery = "SELECT * FROM register WHERE email=?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
                checkStmt.setString(1, email);
                if (checkStmt.executeQuery().next()) {
                    req.setAttribute("message", "Email already registered!");
                    req.getRequestDispatcher("/view/registration.jsp").forward(req, resp);
                    return;
                }
            }

            String insertQuery = "INSERT INTO register (username, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setString(1, username);
                statement.setString(2, email);
                statement.setString(3, password);

                int i = statement.executeUpdate();
                if (i > 0) {
                    req.setAttribute("message", "Registration successful!");
                    req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Registration failed!");
                    req.getRequestDispatcher("/view/registration.jsp").forward(req, resp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Something went wrong!");
            req.getRequestDispatcher("/view/registration.jsp").forward(req, resp);
        }
    }
}

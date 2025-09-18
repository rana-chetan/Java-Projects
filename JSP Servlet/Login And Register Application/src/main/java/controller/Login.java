package controller;

import db.connection.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet("/view/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (java.sql.Connection connection = Connection.getConnection()) {

            String sql = "SELECT * FROM register WHERE username=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, username);
                try (java.sql.ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String dbPassword = rs.getString("password");

                        if (dbPassword.equals(password)) {
                            User user = new User();
                            user.setUsername(rs.getString("username"));

                            HttpSession session = req.getSession();
                            session.setAttribute("User_Info", user);

                            req.setAttribute("message", "Login successful!");
                            req.getRequestDispatcher("/view/profile.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("message", "Invalid password!");
                            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
                        }
                    } else {
                        req.setAttribute("message", "User not found!");
                        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Something went wrong!");
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        }
    }
}

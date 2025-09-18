package controller;

import db.connection.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet("/view/deleteStudent")
public class Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String studentId = req.getParameter("studentId");

        if (studentId == null || studentId.isEmpty()) {
            req.setAttribute("message", "Please enter student ID!");
            req.getRequestDispatcher("/view/delete.jsp").forward(req, resp);
            return;
        }

        String deleteQuery = "DELETE FROM StudentDetails WHERE id=?";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            statement.setString(1, studentId);
            int i = statement.executeUpdate();

            if (i > 0) {
                req.setAttribute("message", "Data deleted successfully.");
            } else {
                req.setAttribute("message", "No record found with given ID!");
            }

            req.getRequestDispatcher("/view/delete.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Server error!");
            req.getRequestDispatcher("/view/delete.jsp").forward(req, resp);
        }
    }
}

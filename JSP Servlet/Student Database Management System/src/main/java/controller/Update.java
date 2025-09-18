package controller;

import db.connection.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/view/updateStudent")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String studentId = req.getParameter("studentId");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String course = req.getParameter("course");

        if (studentId == null || studentId.isEmpty() ||
                name == null || name.isEmpty() ||
                age == null || age.isEmpty() ||
                course == null || course.isEmpty()) {
            req.setAttribute("message", "Please fill all fields!");
            req.getRequestDispatcher("/view/update.jsp").forward(req, resp);
            return;
        }

        String updateQuery = "UPDATE StudentDetails SET name=?, age=?, course=? WHERE id=?";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setString(1, name);
            statement.setString(2, age);
            statement.setString(3, course);
            statement.setString(4, studentId);

            int i = statement.executeUpdate();

            if (i > 0) {
                req.setAttribute("message", "Data updated successfully.");
            } else {
                req.setAttribute("message", "No record found with given ID!");
            }

            req.getRequestDispatcher("/view/update.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("message", "Server error!");
            req.getRequestDispatcher("/view/update.jsp").forward(req, resp);
        }
    }
}

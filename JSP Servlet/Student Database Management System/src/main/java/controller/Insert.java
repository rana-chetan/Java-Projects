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

@WebServlet("/view/insertStudent")
public class Insert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String course = req.getParameter("course");

        if (id == null || name == null || age == null || course == null ||
            id.isEmpty() || name.isEmpty() || age.isEmpty() || course.isEmpty()) {
            req.setAttribute("message", "Please fill all fields!");
            req.getRequestDispatcher("/view/insert.jsp").forward(req, resp);
            return;
        }

        String insertQuery = "INSERT INTO StudentDetails(id, name, age, course) VALUES(?,?,?,?)";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, age);
            statement.setString(4, course);

            int i = statement.executeUpdate();

            if (i > 0) {
                req.setAttribute("message", "Data inserted successfully.");
            } else {
                req.setAttribute("message", "Data insertion failed!");
            }

            req.getRequestDispatcher("/view/insert.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("message", "Student already enrolled!");
            req.getRequestDispatcher("/view/insert.jsp").forward(req, resp);
        }
    }
}

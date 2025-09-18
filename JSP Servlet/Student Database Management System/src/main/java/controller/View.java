package controller;

import db.connection.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentInfo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/view/studentInfo")
public class View extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentInfo> students = new ArrayList<>();

        String query = "SELECT * FROM StudentDetails";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet set = statement.executeQuery()) {

            while (set.next()) {
                String id = set.getString("id");
                String name = set.getString("name");
                String age = set.getString("age");
                String course = set.getString("course");

                students.add(new StudentInfo(id, name, age, course));
            }

            req.setAttribute("studentInfo", students);
            req.getRequestDispatcher("/view/view.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Unable to fetch data!");
            req.getRequestDispatcher("/view/view.jsp").forward(req, resp);
        }
    }
}

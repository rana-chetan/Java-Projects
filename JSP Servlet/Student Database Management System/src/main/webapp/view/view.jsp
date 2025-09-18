<%@ page import="java.util.List" %>
<%@page import="model.StudentInfo"%>

<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
    <link rel="stylesheet" type="text/css" href="../css/style1.css">
</head>

<body>
    <div class="container">
        <h1>View Students</h1>

        <table style="border-collapse: collapse; width: 100%;">
            <tr>
                <th style="border: 1px solid black; padding: 8px; text-align: center;">Student ID</th>
                <th style="border: 1px solid black; padding: 8px; text-align: center;">Name</th>
                <th style="border: 1px solid black; padding: 8px; text-align: center;">Age</th>
                <th style="border: 1px solid black; padding: 8px; text-align: center;">Course</th>
            </tr>
        <%
            List<StudentInfo> students = (List<StudentInfo>) request.getAttribute("studentInfo");
                if (students != null) {
                    for (StudentInfo student : students) {
        %>
            <tr>
                <td style="border: 1px solid black; padding: 8px;"><%= student.getId() %></td>
                <td style="border: 1px solid black; padding: 8px;"><%= student.getName() %></td>
                <td style="border: 1px solid black; padding: 8px;"><%= student.getAge() %></td>
                <td style="border: 1px solid black; padding: 8px;"><%= student.getCourse() %></td>
            </tr>
        <%
                }
            }
        %>
        </table>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
    <link rel="stylesheet" type="text/css" href="../css/style1.css">
</head>

<body>
    <div class="container">
        <h1>Delete Student</h1>
        <form action="deleteStudent" method="post">
            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" name="studentId">
            <input type="submit" value="Delete">
        </form>
    </div>

    <%
        String msg = (String) request.getAttribute("message");
        if(msg != null){
    %>
        <h3 style="text-align:center;"><%= msg %></h3>
    <%
        }
    %>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Insert Student</title>
    <link rel="stylesheet" type="text/css" href="../css/style1.css">
</head>

<body>
    <div class="container">
        <h1>Insert Student</h1>
        <form action="insertStudent" method="post">
             <label for="id">ID:</label>
             <input type="text" id="id" name="id"><br>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age"><br>

            <label for="course">Course:</label>
            <select id="course" name="course">
                <option value="">Select Course</option>
                <option value="Computer Science">Computer Science</option>
                <option value="Data Science">Data Science</option>
                <option value="Cyber Security">Cyber Security</option>
                <option value="Artificial Intelligence">Artificial Intelligence</option>
            </select>

            <input type="submit" value="Insert">
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

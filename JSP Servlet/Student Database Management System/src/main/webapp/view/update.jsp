<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
    <link rel="stylesheet" type="text/css" href="../css/style1.css">
</head>

<body>
    <div class="container">
        <h1>Update Student Details</h1>
        <form action="updateStudent" method="post">
            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" name="studentId"><br>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age"><br>

            <label for="course">Course:</label>
            <input type="text" id="course" name="course"><br>

            <input type="submit" value="Update">
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

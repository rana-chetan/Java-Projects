<%@page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
  <title>Profile Page</title>
  <link rel="stylesheet" type="text/css" href="../css/profile.css">
</head>
<body>
  <div class="container">
    <%
        User user = (User) session.getAttribute("User_Info");
    %>
    <h1> Profile Page </h1>
    <h2> Name: <%= user.getUsername() %> </h2>
    <a href="logout">Logout</a>
  </div>
</body>
</html>

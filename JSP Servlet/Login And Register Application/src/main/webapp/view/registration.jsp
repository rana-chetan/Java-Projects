<html>
<head>
  <title>Registration</title>
  <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
  <div class="container">
    <h1>Registration</h1>
    <form action="register" method="post">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
      </div>
      <button type="submit">Register</button>
    </form>
  </div>
  <%
    String msg=(String) request.getAttribute("message");
    if(msg !=null) {
  %>
  <div class="message"><%= msg %></div>
  <%
    }
  %>
</body>
</html>

<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
  <div class="container">
    <h1>Login</h1>
    <form action="login" method="post">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
      </div>
      <button type="submit">Login</button>
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

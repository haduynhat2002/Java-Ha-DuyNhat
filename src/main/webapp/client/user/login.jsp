<%--
  Created by IntelliJ IDEA.
  User: Hà Nhựt
  Date: 6/7/2022
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login form</h1>
<form action="/login" method="post">
    <div>
        User name<input type="text" name="username">
    </div>
    <div>
        Password<input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="Login">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>

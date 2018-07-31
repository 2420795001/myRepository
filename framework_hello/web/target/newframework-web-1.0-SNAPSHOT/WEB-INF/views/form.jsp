<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/4/8
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单</title>
</head>
<body>
<form method="post" action="${website}/user/new">
    userName:<input type="text" name="userName"><br>
    password:<input type="password" name="password"><br>
    passwordAgain:<input type="password" name="password2"><br>
    ${message}
    <input type="submit" value="注册">
</form>
</body>
</html>

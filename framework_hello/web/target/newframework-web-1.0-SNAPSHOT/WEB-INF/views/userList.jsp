<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/4/8
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>

<table style="text-align: center;font-size: 30px">
    ${message}
    <form method="post" action="${website}/user/listUser">
        <tr>
            <th>序号</th>
            <th>ID</th>
            <th>姓名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userList}" var="user" varStatus="status" >
            <tr>
                <td>${status.index+1}</td>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td><a href="${website}user/delete/${user.userName}">删除</a></td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
</html>
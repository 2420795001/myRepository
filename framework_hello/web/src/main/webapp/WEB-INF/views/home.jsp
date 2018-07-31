
<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2018/6/2
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>主页</title>
</head>
<body>
<div style="margin-top:150px;" align="center">
    <form name="form" action="${pageContext.request.contextPath}/person/search" method="post">
        <input type="text"style="width: 300px;height: 40px;border-radius:5px;border:1px;" name="keyword" placeholder="请输入您想查找的姓名" autocomplete="off">
        <input type="submit" value="搜索">
    </form>
    <table border="1" >
        <tr bgcolor="#a9a9a9">
            <th>编号</th><th>姓名</th><th>年龄</th><th>性别</th><th colspan="2" align="center">操作</th>
        </tr>
        <c:forEach items="${personList}"  var="person" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>
                        ${person.name}
                </td>
                <td>
                        ${person.age}
                </td>
                <td>
                        ${person.sex}
                </td>
                <td>
                    <a href="${website}person/toUpdate/${person.id}">修改</a>
                </td>
                <td>
                    <a href="${website}person/del/${person.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" align="right"><a href="/person/toAdd">添加</a></td>
        </tr>
    </table>
</div>
</body>
</html>

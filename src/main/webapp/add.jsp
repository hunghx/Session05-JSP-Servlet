<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 4/23/2024
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<h1>Thêm mới công viêc</h1>
<form action="/todo" method="post">
    <input type="text" name="title">
    <br>
    <textarea name="content" cols="30" rows="10"></textarea>
    <br>
    <input type="submit" name="action" value="ADD">
</form>
</body>
</html>

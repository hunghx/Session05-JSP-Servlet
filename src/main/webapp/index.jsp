<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%!
    // khai báo các biến,class, phương tức java
    int a =100;
%>
<%
    // code logic
    if (a>100){
        System.out.println("a lon hon 100");
    }else {
        System.out.println("a nho hon 100");
    }
%>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="/todo?action=GETALL">Danh sách công việc</a>
<p><%=a%></p>
</body>
</html>
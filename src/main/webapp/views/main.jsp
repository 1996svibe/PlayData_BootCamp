<%--
  Created by IntelliJ IDEA.
  User: Playdata_
  Date: 2023-06-19
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
</head>
<body>
<img src = "/img/ffsf.png">
<%
    String uname =(String)request.getAttribute("uname");
    for (int i = 0; i < 10; i++) {%>
<h1><%=uname%>"환영합니다"</h1>
<%}
%>
<%@ include file="todos.jsp" %>
<%@ include file="todolist.jsp" %>
</body>
</html>

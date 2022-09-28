<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-02-28
  Time: 오후 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    StringBuffer url = request.getRequestURL();

    out.println("url : " + url.toString());
    out.println("<br>");
%>
</body>
</html>

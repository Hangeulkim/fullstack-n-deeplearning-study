<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-02-28
  Time: 오후 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int v1 = (int)request.getAttribute("v1");
    int v2 = (int)request.getAttribute("v2");
    int result = (int) request.getAttribute("result");
%>
<%=v1 %> + <%=v2 %> = <%=result %>
</body>
</html>

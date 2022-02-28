<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-02-28
  Time: 오후 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int total = 0;
    for(int i=1;i<=10;i++){
        total += i;
    }
%>

1부터 10까지의 합 : <%=total %>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-03-02
  Time: 오후 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("p1", "page scope value");
  request.setAttribute("r1","request scope value");
  session.setAttribute("s1","session scope value");
  application.setAttribute("a1","application scope value");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
pageContext.getAttribute("p1") : ${pageScope.p1 }<br>
request.getAttribute("p1") : ${requestScope.r1 }<br>
session.getAttribute("p1") : ${sessionScope.s1 }<br>
application.getAttribute("p1") : ${applicationScope.a1 }<br>

pageContext.getAttribute("p1") : ${p1 }<br>
request.getAttribute("p1") : ${r1 }<br>
session.getAttribute("p1") : ${s1 }<br>
application.getAttribute("p1") : ${a1 }<br>
</body>
</html>

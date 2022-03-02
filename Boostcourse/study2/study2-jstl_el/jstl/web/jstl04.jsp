<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-03-02
  Time: 오후 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    list.add("!!!!");

    request.setAttribute("list",list);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list }" var="item" begin="1">
    ${item } <br>
</c:forEach>
</body>
</html>

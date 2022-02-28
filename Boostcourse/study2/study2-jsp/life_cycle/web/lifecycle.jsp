<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-02-28
  Time: 오후 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello~
<%
    System.out.println("jspService()");
%>

<%!
    public void jspInit(){
        System.out.println("jspInit()");
    }
%>

<%!
    public void jspDestroy(){
        System.out.println("jspDestroy()");
    }
%>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-02-28
  Time: 오후 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- html 주석 -->
<%--
jsp주석
--%>
<%
    //자바 주석
    /*
    여러줄 주석
     */
    for(int i=1;i<=5;i++){
%>
<h<%=i%>>아름다운 한글</h<%=i%>>
<%
   }
%>
</body>
</html>

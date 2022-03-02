<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-03-02
  Time: 오후 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="n" scope="request" value="10"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${n == 0 }">
    n과 0은 같습니다.
</c:if>
<c:if test="${n == 10 }">
    n과 10은 같습니다.
</c:if>
</body>
</html>

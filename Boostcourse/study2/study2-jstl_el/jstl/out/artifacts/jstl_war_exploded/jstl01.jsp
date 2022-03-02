<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-03-02
  Time: 오후 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="value1" scope="request" value="han"></c:set>
<html>
<head>
    <title>Title</title>
</head>
<body>
성 : ${value1 }<br>
<c:remove var="value1" scope="request"/>
성 : ${value1 }<br>
</body>
</html>

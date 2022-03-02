<%--
  Created by IntelliJ IDEA.
  User: ckswl
  Date: 2022-03-02
  Time: 오후 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="jstlValue.jsp"
          var="urlValue"
          scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
${urlValue }
</body>
</html>

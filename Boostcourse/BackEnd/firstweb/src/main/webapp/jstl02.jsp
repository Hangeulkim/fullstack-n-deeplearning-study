<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	request.setAttribute("n",10);
%> --%>
<c:set var="n" scope="request" value="10" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${n==0 }">
	n과 0은 같습니다.
</c:if>
<c:if test="${n==10 }">
	n과 10은 같습니다.
</c:if>
</body>
</html>


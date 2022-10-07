<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	pageContext.setAttribute("p1","page scope value");
	request.setAttribute("r1","request scope value");
	session.setAttribute("s1","session scope value");
	application.setAttribute("a1","application scope value");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
pageContext.getAttribtute("p1") : <%=pageContext.getAttribute("p1") %><br>
pageContext.getAttribtute("p1") : ${pageScope.p1}<br>
request.getAttribtute("r1") : ${requestScope.r1}<br>
session.getAttribtute("s1") : ${sessionScope.s1}<br>
application.getAttribtute("a1") : ${applicationScope.a1}<br>

pageContext.getAttribtute("p1") : ${p1}<br>
request.getAttribtute("r1") : ${r1}<br>
session.getAttribtute("s1") : ${s1}<br>
application.getAttribtute("a1") : ${a1}<br>
</body>
</html>


<%@ page language = "java" contentType = "text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int total = 0;
	for(int i = 1; i <= 10; i++){
		total = total + i;
	}

%>

1부터 10까지의 합 : <%=total %>
</body>
</head>
</html>
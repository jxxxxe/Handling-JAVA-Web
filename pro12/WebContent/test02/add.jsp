<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addException.jsp"%>
<%
int num=Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>합계 구하기</title>
</head>
<body>
<h1>합계 구하기</h1>
<h1>1부터 <%=num %>까지의 합은 <%
int result=0;
for(int i=1;i<=num;i++)
	result+=i;
%>
<%=result %>입니다
</h1>
</body>
</html>
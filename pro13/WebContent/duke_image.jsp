<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");
	String img=request.getParameter("img");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>듀크이미지</title>
</head>
<body>
<h1>이름은 <%=name %>입니다.</h1><br>
<img src="./image/<%=img%>"/>
</body>
</html>
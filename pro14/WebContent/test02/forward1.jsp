<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>

<%
request.setCharacterEncoding("utf-8");
request.setAttribute("id","hong");
request.setAttribute("pwd","1234");
session.setAttribute("name","홍길동");
application.setAttribute("email","hong@test.com");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
<jsp:forward page="member1.jsp"></jsp:forward>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>

<%
request.setCharacterEncoding("utf-8");
MemberBean member=new MemberBean("lee","1234","이순신","lee@test.com");
request.setAttribute("member",member);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>
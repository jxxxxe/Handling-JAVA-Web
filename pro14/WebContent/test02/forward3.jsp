<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>

<%
request.setCharacterEncoding("utf-8");
MemberBean m1=new MemberBean("lee","1234","이순신","lee@test.com");
MemberBean m2=new MemberBean("hong","2222","홍길동","hong@test.com");
List members=new ArrayList();
members.add(m1);
members.add(m2);
request.setAttribute("members",members);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
<jsp:forward page="member3.jsp"></jsp:forward>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과출력창</title>
</head>
<body>

<%response.setContentType("utf-8"); 
String user_id=request.getParameter("user_id");  
String user_pw=request.getParameter("user_pw");
%> <%-- 변수 선언도 스크립트릿 안에 다함; => 선언문에서는 멤버변수!!--%>
<h1>결과 출력</h1>
<h1>아이디 : <%=user_id %></h1>
<h1>비밀번호 : <%=user_pw %></h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");
String user_id=request.getParameter("user_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<%
	if(user_id==null || user_id.length()==0 ){
%>
<jsp:forward page="login.jsp">
 <jsp:param name="msg" value="아이디를 입력하지 않았습니다. 아이디를 입력해 주세요."/>
</jsp:forward>
<%} %>
<h1>환영합니다 <%=user_id %>님!!</h1>
</body>
</html>
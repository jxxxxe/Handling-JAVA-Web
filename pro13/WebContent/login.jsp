<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("utf-8");
String msg=request.getParameter("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
<%if(msg!=null) {%>
	<h1><%=msg %></h1>
<%} %> <!-- 단일문장이래도 스크립트릿에서는 {} 표시 해줘야 함 -->
<form name=frmLogin method="post" action="result.jsp" encType="UTF-8">
아이디 :<input type="text" name=user_id><br>
비밀번호 : <input type="password" name="user_pw"><br>
<input type="submit" value="로그인">
<input type="reset" value="다시입력">
</body>
</html>
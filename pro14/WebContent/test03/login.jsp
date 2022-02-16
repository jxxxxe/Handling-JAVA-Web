<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
request.setCharacterEncoding("utf-8");
String msg=request.getParameter("msg"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
<%if(msg!=null) {%>
	<h1><%=msg %></h1>
<%} %> 
<form name=frmLogin method="post" action="result.jsp" encType="UTF-8">
아이디 :<input type="text" name=user_id><br>
비밀번호 : <input type="password" name="user_pw"><br>
<input type="submit" value="로그인">
<input type="reset" value="다시입력"><br><br>
<a href="${contextPath}/test03/memberForm.jsp">회원가입하기</a>
</body>
</html>
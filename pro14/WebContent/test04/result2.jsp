<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="login" value="login.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<c:if test="${not empty param.user_id }">
	 <c:if test="${param.user_id =='admin'}">
	  <h1>관리자로 로그인 했습니다.</h1>
	  <form>
	  	<input type="button" value="회원정보 삭제하기"/>
	  	<input type="button" value="회원정보 수정하기"/>
	  </form>
	 </c:if>
	 <c:if test="${param.user_id !='admin'}">
	  <h1>환영합니다. ${param.user_id }님!!!</h1>
	 </c:if>
</c:if>
<c:if test="${empty param.user_id }">
 아이디를 입력하세요.<br>
 <a href=${login }>로그인 창</a></c:if>
</body>
</html>
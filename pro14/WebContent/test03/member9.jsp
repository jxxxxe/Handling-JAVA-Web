<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록창</title>
</head>
<body>
<table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	      <td width="7%" >아이디</td>
	      <td width="7%">비밀번호</td>
	      <td width="7%" >이름</td>
	      <td width="7%" >이메일</td>
	   </tr>
	<c:choose>
		<c:when test="${empty param.id }">
			<h1>아이디를 입력하세요</h1></c:when>
		<c:otherwise>
		   <tr align="center">
		       <td><c:out value="${param.id}"/></td>
		       <td><c:out value="${param.pwd}"/></td>
		       <td><c:out value="${param.name}"/></td>
		       <td><c:out value="${param.email}"/></td>
		   </tr> 
	   </c:otherwise>
	 </c:choose>

	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
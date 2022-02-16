<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
%>

<c:set var="id" value="hong"/>
<c:set var="pwd" value="1234"/>
<c:set var="name" value="홍길동"/>
<c:set var="age" value="22"/>
<c:set var="height" value="177"/>

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
	      <td width="7%" >나이</td>
	      <td width="7%" >키</td>
	   </tr>

	   <tr align="center">
	       <td>${id}</td>
	       <td>${pwd}</td>
	       <td>${name}</td>
	       <td>${age}</td>
	       <td>${height}</td> 
	   </tr> 

	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>

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
	      <td width="7%" >주소</td>
	   </tr>

	   <tr align="center">
	       <td>${param.id}</td>
	       <td>${param.pwd}</td>
	       <td>${param.name}</td>
	       <td>${param.email}</td>
	       <td>${requestScope.address }</td>
	   </tr> 

	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
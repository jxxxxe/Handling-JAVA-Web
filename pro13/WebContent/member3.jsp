<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<jsp:useBean id="memberBean" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="memberBean" property="*"/>

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
	   <tr align="center">
	       <td><jsp:getProperty name="memberBean" property="id" /></td>
	       <td><jsp:getProperty name="memberBean" property="pwd" /></td>
	       <td><jsp:getProperty name="memberBean" property="name" /></td>
	       <td><jsp:getProperty name="memberBean" property="email" /></td>
	   </tr>
	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
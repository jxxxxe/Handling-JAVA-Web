<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" isELIgnored="fasle"%>

<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean"></jsp:useBean>
<jsp:setProperty name="m" property="*"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<%
	MemberBean m2=new MemberBean("son","3231","손흥민","son@totnum.com");
	memberList.add(m);
	memberList.add(m2);
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
	       <td>${memberList[0].id}</td> 
	       <td>${memberList[0].pwd}</td>
	       <td>${memberList[0].name}</td>
	       <td>${memberList[0].email}</td>
	   </tr> 
	   <tr align="center">
	       <td>${memberList[1].id}</td> 
	       <td>${memberList[1].pwd}</td>
	       <td>${memberList[1].name}</td>
	       <td>${memberList[1].email}</td>
	   </tr> 

	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
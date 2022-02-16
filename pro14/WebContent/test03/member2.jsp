<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="membersList" class="java.util.ArrayList"/>
<jsp:useBean id="membersMap" class="java.util.HashMap"/>

<%
membersMap.put("id","hong");
membersMap.put("pwd","1223");
membersMap.put("name","홍길동");
membersMap.put("email","hong@test.com");

MemberBean m1=new MemberBean("park","1234","박지성","park@test.com");
MemberBean m2=new MemberBean("son","2321","손흥민","son@test.com");
membersList.add(m1);
membersList.add(m2);

membersMap.put("membersList",membersList);
%>
<c:set var="membersList" value="${membersMap.membersList }"/>

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
	       <td>${membersMap.id}</td>
	       <td>${membersMap.pwd}</td>
	       <td>${membersMap.name}</td>
	       <td>${membersMap.email}</td>
	   </tr> 
	   <tr align="center">
	       <td>${membersList[0].id}</td>
	       <td>${membersList[0].pwd}</td>
	       <td>${membersList[0].name}</td>
	       <td>${membersList[0].email}</td>
	   </tr> 
	   	   <tr align="center">
	       <td>${membersList[1].id}</td>
	       <td>${membersList[1].pwd}</td>
	       <td>${membersList[1].name}</td>
	       <td>${membersList[1].email}</td>
	   </tr> 

	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
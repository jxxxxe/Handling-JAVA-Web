<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" isELIgnored="false"%>

<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean"></jsp:useBean>
<jsp:setProperty name="m" property="*"/>

<jsp:useBean id="address" class="sec01.ex01.Address"/>
<jsp:setProperty name="address" property="city" value="NewYork"/>
<jsp:setProperty name="address" property="zipcode" value="07453"/>
<%
	m.setAddress(address);
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
	      <td width="7%" >도시</td>
	      <td width="7%" >우편번호</td>
	   </tr>
	   <tr align="center">
	       <td>${m.id}</td> 
	       <td>${m.pwd}</td>
	       <td>${m.name}</td>
	       <td>${m.email}</td>
	       <td>${m.address.city}</td>
	       <td>${m.address.zipcode }</td>
	   </tr> 

	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="6"></td>
	   </tr>
	</table>
</body>
</html>
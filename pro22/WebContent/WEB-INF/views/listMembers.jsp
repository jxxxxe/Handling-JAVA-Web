<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1" align="center" width="100%" >
   <tr align=center   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>이름</b></td>
      <td><b>이메일</b></td>
      <td><b>가입일</b></td>
   </tr>
   <c:forEach var="mem" items="${membersList }">
	   <tr align="center">
	      <td>${mem.id}</td>
	      <td>${mem.pwd}</td>
	      <td>${mem.name}</td>
	      <td>${mem.email}</td>
	      <td>${mem.joinDate }</td>
	    </tr>
    </c:forEach>
</table>
</body>
</html>
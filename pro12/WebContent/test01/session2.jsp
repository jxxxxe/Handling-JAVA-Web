<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 내장 객체 테스트2</title>
</head>
<body>
<%
String name=(String)session.getAttribute("name");
String address=(String)session.getAttribute("address");
%>
이름은 <%=name %>입니다.<br>
주소는 <%=address %>입니다.
</body>
</html>
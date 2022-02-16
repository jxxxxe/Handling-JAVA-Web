<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dan" value="${param.dan }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력 결과</title>
</head>
<body>
<h1>${dan }단 출력</h1>
<c:forEach var="i" begin="1" end="9" step="1">
 <c:out value="${dan }*${i } = ${dan*i }"/><br>
</c:forEach>
</body>
</html>
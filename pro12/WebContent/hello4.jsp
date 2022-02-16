<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String name= "이순신";
public String getName(){return name;}%>

<%//String age=request.getParameter("age"); %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주석문 연습</title>
</head>
<body>
<h1>주석문 예제입니다!!</h1>
<h1>나이는 <%--<%=age %>--%>살 입니다!!</h1>
</body>
</html>
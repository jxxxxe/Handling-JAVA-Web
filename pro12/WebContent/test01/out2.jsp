<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과출력창</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
String age=request.getParameter("age");
%>
<%if(name.length()==0 || name==null) {%>
	이름을 입력하세요<br>
	<a href='out1.jsp'>입력하기</a>
<%} else{ %>
	<h1><%=name %> , <%=age %></h1>
<%} %>
<%if(name.length()==0 || name==null) {%>
	이름을 입력하세요<br>
	<a href='out1.jsp'>입력하기</a>
<%} else{ %>
	<h1><% out.println(name +" , "+age); %></h1>
<%} %>
</body>
</html>
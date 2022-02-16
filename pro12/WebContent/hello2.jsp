<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String name= "이순신";
public String getName(){return name;}%>

<%String age=request.getParameter("age"); %> 
<!-- 서블릿 클래스에서 선언되므로 이전처럼 요청 매개변수 사용가능 -->
<!-- 요청의 바인딩은 ?뒤에 key=value로 함 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 연습</title>
</head>
<body>
<h1>안녕하세요 <%=name %>님!!</h1>
<h1>나이는 <%=age %>살 입니다!!</h1>
</body>
</html>
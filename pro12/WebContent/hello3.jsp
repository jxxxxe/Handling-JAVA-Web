<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String name= "이순신";
public String getName(){return name;}%>

<%String age=request.getParameter("age"); %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식 연습</title>
</head>
<body>
<h1>안녕하세요 <%=name %>님!!</h1> <!-- 변수 -->
<h1>나이는 <%=age %>살 입니다!!</h1>
<h1>키는 <%=180 %>cm입니다!!</h1> <!-- 값 -->
<h1>나이+10은 <%=Integer.parseInt(age)+10 %>살입니다!!</h1> <!-- 자바식, 여기선 변수값이 필요하므로 요청시 바인딩 안하면 오류남 -->
</body>
</html>
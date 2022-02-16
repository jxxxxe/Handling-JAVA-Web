<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setAttribute("name", "이순신");
request.setAttribute("address","서울시 강남구");
RequestDispatcher dispatcher=request.getRequestDispatcher("request2.jsp");
dispatcher.forward(request,response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 번째 서블릿</title>
</head>
<body>

</body>
</html>
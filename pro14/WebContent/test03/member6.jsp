<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
List dataList=new ArrayList();
dataList.add("hello");
dataList.add("world");
dataList.add("안녕하세요!");
%>

<c:set var="list" value="<%= dataList %>"/> <!-- 변수 선언 해줘야 함.. ${dataList}로 접근하면 안됐음; -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록창</title>
</head>
<body>
 <c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
  i=${i }   반복횟수 : ${loop.count }<br> </c:forEach> <!-- var 변수를 이용할 때 ${}안에 쓰기 -->

<br>
 <c:forEach var="i" begin="1" end="10" step="2">
  5 * ${i } = ${5*i }<br></c:forEach> <!-- 변수를 이용한 식을 쓰고 싶으면 ${}한번만 써서 변수 맘대로 쓰면 되는듯 -->
  
<br>
 <c:forEach var="item" items="${list }"> <!--  --> <!-- 선언한 변수 사용이므로 ${list} -->
  ${ item}<br></c:forEach> <!-- list가 만약 객체 리스트였음 ${item.id}식으로 하면 됨 -->
  
<br>
<c:set var="fruits" value="사과,파인애플,키위,바나나"/> <!-- 문자열을 토큰으로 분리 -->
<c:forTokens var="fruit" items="${fruits }" delims=",">
 ${fruit }<br>
</c:forTokens>
</body>
</html>
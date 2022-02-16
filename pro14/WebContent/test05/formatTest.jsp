<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.Date"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포매팅 태그 라이브러리 예제</title>
</head>
<body>
 <h2>formatNumber 예제</h2>
 <c:set var="price" value="100000000"/>
 <fmt:formatNumber value="${price }" type="number" var="priceNumber"/>
 통화로 표현 시: <fmt:formatNumber value="${price }" type="currency" currencySymbol="￦" groupingUsed="true"/><br> <%--통화 표시 특수문자에서 찾아서 해야 함.. --%>
 퍼센트로 표현 시 : <fmt:formatNumber value="${price }" type="percent" groupingUsed="false"/><br>
 일반 숫자로 표현 시 :  "${priceNumber }"<br> <%--일반 변수로 담았으므로 fmt사용하는게 아니라 바로 표현언어로 변수 값 출력 --%>
 
 <h2>formatDate 예제</h2>
 <c:set var="now" value="<%=new Date() %>"/> <%--import java.util.Date해야 함, 한국시간 생성 --%>
 <fmt:formatDate value="${now }" type="date" dateStyle="full" /><br>
 <fmt:formatDate value="${now }" type="date" dateStyle="short" /><br>
 <fmt:formatDate value="${now }" type="time"/><br>
  <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /><br>
   <fmt:formatDate value="${now }" pattern="YY-MM-DD hh:mm:ss"/><br>
   
  <br><br>
  한국 현재 시간:
 <fmt:formatDate value="${now }" type="both" timeStyle="full" dateStyle="full"/><br><br>
 <fmt:timeZone value="America/New York"> <%-- 표준시간 설정 --%>
  뉴욕 현재 시간 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
  </fmt:timeZone>
</body>
</html>
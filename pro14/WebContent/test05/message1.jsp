<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 다국어 기능</title>
</head>
<body>
<fmt:setLocale value="en_US"/>  <!-- locale을 영어로 지정 -->
 <%--<fmt:setLocale value="ko_KR"/>--%>  		
 <!-- locale을 한글로 지정, 둘 중 하나를 택하면 됨 -->
 <%--주석 시에 스크립트릿을 사용해야한다!!!ㅠ --%>
 <h1>회원정보<br><br>
 <fmt:bundle basename="resource.member" >  
  이름:<fmt:message key="mem.name" /><br>
  주소:<fmt:message key="mem.address" /><br>
  직업:<fmt:message key="mem.job" />
</fmt:bundle>
</h1>
</body>
</html>
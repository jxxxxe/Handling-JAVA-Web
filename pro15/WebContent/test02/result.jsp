<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${param.param1 }"/>
<c:set var="file2" value="${param.param2 }"/>

<title>이미지 파일 출력하기</title>
</head>
<body>
매개변수1 : <c:out value="${file1 }"/><br>
매개변수2 : <c:out value="${file2 }" /><br>
<img src="${contextPath }/download.do?fileName=${file1 }" width=300 height=300/><br>
<a href="${contextPath }/download.do?fileName=${file1 }">파일 내려 받기</a><br><br>

<img src="${contextPath }/download.do?fileName=${file2 }" width=300 height=300/><br>
<a href="${contextPath }/download.do?fileName=${file2 }">파일 내려 받기</a><br><br>
<%--이미지 경로를 소스파일 이름으로 설정하면 화면에 나타내는거고, 링크로 접속하면 다운받아 지는 것 --%>
</body>
</html>
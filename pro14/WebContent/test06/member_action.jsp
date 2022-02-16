<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec02.ex01.*"
    pageEncoding="UTF-8" %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="sec02.ex01.MemberBean"/>
<jsp:setProperty name="m" property="*"/>
<%
	MemberDAO dao=new MemberDAO();
	dao.addMember(m);
	List membersList=dao.listMember();
	request.setAttribute("membersList",membersList);
%>
</head>
<body>
<jsp:forward page="memberList.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec02.ex01.*"	
    pageEncoding="UTF-8"%> <%-- dao, vo객체를 위해서 임포트 --%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
	text-align:center;	
}<!-- <h1> 태그의 텍스트를 중앙에 정렬함-->
</style>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>

<body>
<h1>회원 정보 출력</h1>
<%
	request.setCharacterEncoding("utf-8");
	MemberVO memberVO=new MemberVO();
	memberVO.setName(request.getParameter("name"));
	MemberDAO dao=new MemberDAO();
	List<MemberVO> members=dao.listMembers(memberVO);
%>
<table border='1' width='800' align='center'>
   <tr align='center' bgcolor='#FFFF66'> 
     <td>아이디</td>
     <td>비밀번호</td>
     <td>이름</td>
     <td >이메일</td>
     <td>가입일자</td>
</tr>
<%
	for(int i=0;i<members.size();i++){
		MemberVO member=members.get(i);
		String id=member.getId();
		String pw=member.getPwd();
		String name=member.getName();
		String email=member.getEmail();
		Date joinDate=member.getJoinDate();
%>
	     <tr align=center>
	       <td><%= id %></td>
	       <td><%= pw %></td>
	       <td><%= name %></td>
	       <td><%= email %></td>
	       <td><%=joinDate  %></td>
	     </tr>
	   
	<%	
		
	}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<jsp:useBean id="memberBean" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:setProperty name="memberBean" property="*"/>

<%
request.setCharacterEncoding("utf-8");
/*
String user_id=request.getParameter("id");
String user_pwd=request.getParameter("pwd");
String user_name=request.getParameter("name");
String user_email=request.getParameter("email");
MemberBean memberBean=new MemberBean(user_id,user_pw,user_name,user_email);

memberBean.setId(user_id);
memberBean.setPwd(user_pwd);
memberBean.setName(user_name);
memberBean.setEmail(user_email);*/
MemberDAO dao=new MemberDAO();
dao.addMember(memberBean);
List members=dao.listMember();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록창</title>
</head>
<body>
<table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	      <td width="7%" >아이디</td>
	      <td width="7%">비밀번호</td>
	      <td width="5%" >이름</td>
	      <td width="11%" >이메일</td>
	      <td width="5%" >가입일</td>
	   </tr>
	<%
	   if(members.size()==0){
	%>
	  <tr>
	      <td colspan="5">
	        <p align="center"><b><span style="font-size:9pt;">
	                      등록된 회원이  없습니다.</span></b></p>
	      </td>
	  </tr>
	<%
	}else{
	   for( int i = 0; i < members.size(); i++ ) {
	      MemberBean bean = (MemberBean) members.get(i);
	%>
	   <tr align="center">
	       <td><%=bean.getId() %></td>
	       <td><%=bean.getPwd() %></td>
	       <td><%=bean.getName() %></td>
	       <td><%=bean.getEmail() %></td>
	       <td><%=bean.getJoinDate() %></td>
	   </tr>
	<%
	      } // end for
	
	   } // end if
	%>
	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
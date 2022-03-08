package com.spring.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO dao=new MemberDAO();
		MemberVO memberVO=new MemberVO();
		String nextPage="";
		String action=request.getParameter("action");
		
		if(action==null || action.contentEquals("listMembers")) {
			List<MemberVO> membersList=dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage="test03/listMembers.jsp";
		}
		else if(action.contentEquals("selectMemberById")) {
			String id=request.getParameter("value");
			memberVO=dao.selectMemberById(id);
			request.setAttribute("mem", memberVO);
			nextPage="test03/memberInfo.jsp";
		}
		else if(action.contentEquals("selectMemberByPwd")) {
			String pwd2=request.getParameter("value");
			List<MemberVO> membersList=dao.selectMemberByPwd(pwd2);
			request.setAttribute("membersList", membersList);
			nextPage="test03/listMembers.jsp";
		}
		else if(action.contentEquals("insertMember")) {
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			memberVO=new MemberVO(id,pwd,name,email);
			dao.insertMember(memberVO);
			nextPage="/mem4.do?action=listMembers";
		}
		else if(action.contentEquals("insertMember2")) {
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			Map memberMap=new HashMap();
			memberMap.put("id",id);
			memberMap.put("pwd", pwd);
			memberMap.put("name", name);
			memberMap.put("email", email);
			
			dao.insertMember2(memberMap);
			nextPage="/mem4.do?action=listMembers";
		}
		else if(action.contentEquals("updateMember")) {
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			memberVO=new MemberVO(id,pwd,name,email);
			dao.updateMember(memberVO);
			nextPage="/mem4.do?action=listMembers";
		}
		else if(action.contentEquals("deleteMember")) {
			String id=request.getParameter("id");
			dao.deleteMember(id);
			nextPage="/mem4.do?action=listMembers";
		}
		else if(action.contentEquals("searchMember")) {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			memberVO.setName(name);
			memberVO.setEmail(email);
			
			List<MemberVO> members=dao.selectMember(memberVO);
			request.setAttribute("membersList", members);
			nextPage="test03/listMembers.jsp";
		}
		else if(action.contentEquals("foreachSelect")){
			List<String> nameList=new ArrayList();
			nameList.add("차범근");
			nameList.add("이순신");
			nameList.add("홍길동");
			
			List<MemberVO> membersList=dao.foreachSelect(nameList);
			request.setAttribute("membersList", membersList);
			nextPage="test03/listMembers.jsp";
		}
		else if(action.contentEquals("foreachInsert")) {
			List<MemberVO> memList=new ArrayList();
			memList.add(new MemberVO("m1","1234","박길동","m1@test.com"));
			memList.add(new MemberVO("m2","1234","이길동","m2@test.com"));
			memList.add(new MemberVO("m3","1234","유길동","m3@test.com"));
			
			int result=dao.foreachInsert(memList);
			nextPage="/mem4.do?action=listMembers";
		}
		else if(action.contentEquals("selectLike")) {
			String name="길";
			List<MemberVO> membersList=dao.selectLike(name);
			
			request.setAttribute("membersList", membersList);
			nextPage="test03/listMembers.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
	}

}

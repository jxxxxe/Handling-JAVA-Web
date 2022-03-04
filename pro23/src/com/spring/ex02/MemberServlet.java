package com.spring.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/mem2.do")
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
		
		String name=dao.selectName();
		int pwd=dao.selectPwd();
		
		PrintWriter out=response.getWriter();
		out.write("<script> alert('이름 : "+name+" 비밀번호: "+pwd+"'); </script>");

		String nextPage="";
		String action=request.getParameter("action");
		if(action==null || action.contentEquals("listMembers")) {
			List<MemberVO> membersList=dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage="test01/listMembers.jsp";
		}
		else if(action.contentEquals("selectMemberById")) {
			String id=request.getParameter("value");
			memberVO=dao.selectMemberById(id);
			request.setAttribute("mem", memberVO);
			nextPage="test01/memberInfo.jsp";
		}
		else if(action.contentEquals("selectMemberByPwd")) {
			String pwd2=request.getParameter("value");
			List<MemberVO> membersList=dao.selectMemberByPwd(pwd2);
			request.setAttribute("membersList", membersList);
			nextPage="test01/listMembers.jsp";
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}

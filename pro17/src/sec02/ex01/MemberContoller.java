package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member/*")
public class MemberContoller extends HttpServlet {
	
	MemberDAO dao;
	
	public void init() throws ServletException{
		dao=new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nextPage="";
		String action=request.getPathInfo();
		
		if(action.equals("/listMembers.do")) {
			List<MemberVO> members=dao.listMember();
			request.setAttribute("members", members);
			nextPage="/test02/listMembers.jsp";
		}
		else if(action.equals("/addMember.do")){
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			MemberVO memberVO=new MemberVO(id,pwd,name,email);
			dao.addMember(memberVO);
			nextPage="/member/listMembers.do";
		}else if(action.equals("/memberForm.do")) {
			nextPage="/test02/memberForm.jsp";
		}else {
			List<MemberVO> members=dao.listMember();
			request.setAttribute("members", members);
			nextPage="/test02/listMembers.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}

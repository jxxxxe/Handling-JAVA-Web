package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login2")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");

		MemberVO memberVO=new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);

		
		MemberDAO dao=new MemberDAO();
		
		if(dao.isExisted(memberVO)) {
			HttpSession session=request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pw);
			out.print("�ȳ��ϼ��� "+user_id+"��!! <br>");
			out.print("<a href='show'>������ ����</a>");
		}else {
			out.print("���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.<br>");
			out.print("<a href='login3.html'>�ٽ� �α����ϱ�</a>");
		}
			
	}
	}

package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("user_id");
		String pw=request.getParameter("user_pw");
		
		System.out.println("아이디 : "+id);
		System.out.println("비밀번호 : "+pw);
		
		if(id!=null && (id.length()!=0)) {
			out.print("<html><body>"+id+"님!! 로그인 하셨습니다.</body></html>");
		} else {
			out.print("<html><body>아이디를 입력하세요!!!<br>");
			out.print("<a href='http://localhost:8090/pro06/test01/login.html'> 로그인 창으로 이동 </a> </body></html>");
		}

		
	}
	
}

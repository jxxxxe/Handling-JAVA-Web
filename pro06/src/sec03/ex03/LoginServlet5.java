package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("user_id");
		String pw=request.getParameter("user_pw");
		String address=request.getParameter("user_address");
		
		String data="<html> <body>";
		data+="아이디 : "+id+"<br>패스워드 :"+pw+"<br>주소 : "+address;
		data+="</body> </html>";
		
		out.print(data);
		
	}
	
}

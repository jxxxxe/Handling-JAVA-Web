package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		System.out.println("���̵�:"+user_id);
		System.out.println("��й�ȣ:"+user_pw); 
	}
	
}

package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		String data="�ȳ��ϼ���! <br> �α����ϼ̽��ϴ�<br><br>";
		data+="<html><body>";
		data+="���̵� : "+user_id;
		data+="<br>��й�ȣ : "+user_pw;
		data+="</html></body>";
		
		out.print(data);
	}

}

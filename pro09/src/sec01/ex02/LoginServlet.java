package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		String user_address=request.getParameter("user_address");
		String user_email=request.getParameter("user_email");
		String user_hp=request.getParameter("user_hp");
		
		String data="�ȳ��ϼ���! <br> �α����ϼ̽��ϴ�<br><br>";
		data+="<html><body>";
		data+="���̵� : "+user_id;
		data+="<br>��й�ȣ : "+user_pw;
		data+="<br>�ּ� : "+user_address;
		data+="<br>�̸��� : "+user_email;
		data+="<br>�޴���ȭ : "+user_hp;
		out.print(data);
		
		user_address=URLEncoder.encode(user_address,"utf-8"); //�ѱ��� �����ϱ� ���� ���ڵ�
		out.print("<br><a href='/pro09/second?user_id="+user_id+"&user_pw="+user_pw+"&user_address="+user_address+"'>�ι� ° �������� ������</a>");

		data="</html></body>";
		
		out.print(data);
	}

}

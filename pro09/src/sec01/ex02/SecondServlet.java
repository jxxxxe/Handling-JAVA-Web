package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String user_id=request.getParameter("user_id"); // ?�� ���еǾ� �������� name-value�� ��
		String user_pw=request.getParameter("user_pw");
		String user_address=request.getParameter("user_address");
		
		if(user_id!=null &&user_id.length()!=0) {
			String data="�̹� �α��� �����Դϴ�!<br><br>";
			data+="<html><body>";
			data+="ù ��° �������� �Ѱ��� ���̵� : "+user_id;
			data+="<br>ù ��° �������� �Ѱ��� ��й�ȣ : "+user_pw;
			data+="<br>ù ��° �������� �Ѱ��� �ּ� : "+user_address;
			data+="</html></body>";
			
			out.print(data);
		}else {
			out.print("�α��� ���� �ʾҽ��ϴ�.");
			out.print("�ٽ� �α����ϼ���!!");
			out.print("<a href='/pro09/login.html'> �α��� â���� �̵��ϱ�</a>");

		}
	}
}

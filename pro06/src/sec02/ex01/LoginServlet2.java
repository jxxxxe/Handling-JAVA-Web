package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //������ ������ ���� ����(html)
		PrintWriter out=response.getWriter(); //Ŭ��� �����͸� ����� �� ��½�Ʈ�� printWriter ��ü
		
		String id=request.getParameter("user_id");
		String pw=request.getParameter("user_pw");
		
		String data="<html> <body>";
		data+="���̵� : "+id+"<br>�н����� :"+pw;
		data+="</body> </html>";
		
		out.print(data); //HTML �±� ���ڿ��� �� �������� ���
	}

}

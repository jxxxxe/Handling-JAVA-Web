package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginTest extends HttpServlet {

	List user_list=new ArrayList();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		ServletContext ctx=getServletContext();
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		LoginImpl loginUser=new LoginImpl(user_id,user_pw); 
		
		if(session.isNew()) {
			user_list.add(user_id);
			ctx.setAttribute("user_list", user_list);
		}
		
		String data="�ȳ��ϼ���! <br> �α����ϼ̽��ϴ�<br><br>";
		data+="<html><body>";
		data+="���̵� : "+loginUser.user_id;
		data+="<br>�� �����ڼ� : "+LoginImpl.total_user;
		data+="<br>���� ���̵� : <br>";
		
		List list=(ArrayList)ctx.getAttribute("user_list");
		
		for(int i=0;i<list.size();i++) 
		{
			data+=list.get(i)+"<br>";
		}
		data+="<a href='logout?user_id="+user_id+"'>�α׾ƿ�</a></html></body>";
		
		out.print(data);
		}
	}

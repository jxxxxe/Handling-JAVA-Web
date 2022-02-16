package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
public class LoginTest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		LoginImpl loginUser=new LoginImpl(user_id,user_pw); 
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser); //loginImpl의 valueBound메서드 호출
		}
		
		String data="안녕하세요! <br> 로그인하셨습니다<br><br>"; //history.go(0)==새로고침, setTimeout(코드,시간)
		data+="<head><script type='text/javascript'> setTimeout('history.go(0);',5000)</script></head>";
		data+="<html><body>";
		data+="아이디 : "+loginUser.user_id;
		data+="<br>총 접속자수 : "+LoginImpl.total_user;
		data+="</html></body>";
		
		out.print(data);
	}

}

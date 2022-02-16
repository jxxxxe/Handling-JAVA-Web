package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess3")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		String data="세션 아이디 : "+session.getId();
		data+="<br>최초 세션 생성 시각 : "+new Date(session.getCreationTime());
		data+="<br>최근 세션 접근 시각 : "+new Date(session.getLastAccessedTime());
		data+="<br>세션 유효 시간 : "+session.getMaxInactiveInterval();
		
		out.print(data);
		
		if(session.isNew()) {
			out.print("<br>새 세션이 만들어졌습니다.");
		}
		session.invalidate();
	}

}

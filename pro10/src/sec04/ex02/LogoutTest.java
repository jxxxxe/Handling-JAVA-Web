package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		ServletContext ctx=getServletContext();
		
		String user_id=request.getParameter("user_id");
		
		session.invalidate();
		
		List list=(List) ctx.getAttribute("user_list");
		ctx.removeAttribute("user_list");
		list.remove(user_id);
		ctx.setAttribute("user_list", list);
		
		String data="로그아웃했습니다<br><br>"; 
		
		out.print(data);
	}

}

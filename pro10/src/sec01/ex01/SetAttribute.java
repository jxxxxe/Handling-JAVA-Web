package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/set")
public class SetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		ServletContext ctx=getServletContext();
		
		request.setAttribute("request", "request�� ���ε��˴ϴ�.<br>");
		session.setAttribute("session", "session�� ���ε��˴ϴ�.<br>");
		ctx.setAttribute("context", "context�� ���ε��˴ϴ�.<br>");
		
		out.print("���ε��� �����մϴ�.");
	}

}

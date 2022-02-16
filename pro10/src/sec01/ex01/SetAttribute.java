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
		
		request.setAttribute("request", "request에 바인딩됩니다.<br>");
		session.setAttribute("session", "session에 바인딩됩니다.<br>");
		ctx.setAttribute("context", "context에 바인딩됩니다.<br>");
		
		out.print("바인딩을 수행합니다.");
	}

}

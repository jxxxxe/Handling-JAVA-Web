package sec05.ex02;

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

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();	
		
		ServletContext context=getServletContext();
		String menu_member=context.getInitParameter("menu_member");
		String menu_order=context.getInitParameter("menu_order");
		String menu_goods=context.getInitParameter("menu_goods");

		out.print("<html><body> <table border=1 cellspacing=0><tr>�޴� �̸�</tr>");
		out.print("<tr><td>"+menu_member+"</tr></td>");
		out.print("<tr><td>"+menu_order+"</tr></td>");
		out.print("<tr><td>"+menu_goods+"</tr></td>");
		out.print("</table></body></html>");
	}

}

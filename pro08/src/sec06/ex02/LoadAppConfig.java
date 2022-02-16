package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadAppConfig
 */
@WebServlet(name = "loadConfig", urlPatterns = { "/loadConfig" })//,loadOnStartup=1)
public class LoadAppConfig extends HttpServlet {
	private ServletContext context;
	public void init(ServletConfig config) throws ServletException { //톰캣 실행 시 이것만 실행, 요청을해야 doGet실행
		System.out.println("init호출");
		context=config.getServletContext(); //config이다
		String menu_member=context.getInitParameter("menu_member");
		String menu_order=context.getInitParameter("menu_order");
		String menu_goods=context.getInitParameter("menu_goods");	//web.xml에서 읽어드림
		context.setAttribute("menu_member", menu_member);	//컨텍스트 객체에 바인딩 >> 요청 시 web.xml(파일)보다 객체에서 가져오는게 더 빠름
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet호출");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String menu_member=(String)context.getAttribute("menu_member");
		String menu_order=(String)context.getAttribute("menu_order");
		String menu_goods=(String)context.getAttribute("menu_goods");
		
		out.print("<html><body> <table border=1 cellspacing=0><tr>메뉴 이름</tr>");
		out.print("<tr><td>"+menu_member+"</tr></td>");
		out.print("<tr><td>"+menu_order+"</tr></td>");
		out.print("<tr><td>"+menu_goods+"</tr></td>");
		out.print("</table></body></html>");
	}

}

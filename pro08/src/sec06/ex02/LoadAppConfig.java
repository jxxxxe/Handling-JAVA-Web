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
	public void init(ServletConfig config) throws ServletException { //��Ĺ ���� �� �̰͸� ����, ��û���ؾ� doGet����
		System.out.println("initȣ��");
		context=config.getServletContext(); //config�̴�
		String menu_member=context.getInitParameter("menu_member");
		String menu_order=context.getInitParameter("menu_order");
		String menu_goods=context.getInitParameter("menu_goods");	//web.xml���� �о�帲
		context.setAttribute("menu_member", menu_member);	//���ؽ�Ʈ ��ü�� ���ε� >> ��û �� web.xml(����)���� ��ü���� �������°� �� ����
		context.setAttribute("menu_order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGetȣ��");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String menu_member=(String)context.getAttribute("menu_member");
		String menu_order=(String)context.getAttribute("menu_order");
		String menu_goods=(String)context.getAttribute("menu_goods");
		
		out.print("<html><body> <table border=1 cellspacing=0><tr>�޴� �̸�</tr>");
		out.print("<tr><td>"+menu_member+"</tr></td>");
		out.print("<tr><td>"+menu_order+"</tr></td>");
		out.print("<tr><td>"+menu_goods+"</tr></td>");
		out.print("</table></body></html>");
	}

}

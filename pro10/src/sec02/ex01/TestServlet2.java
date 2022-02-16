package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.print("<body bgcolor='yellow'>");
		out.print("컨텍스트 이름 : "+request.getContextPath());
		out.print("<br>전체 경로 : "+request.getRequestURL().toString());
		out.print("<br>매핑 이름 : "+request.getServletPath());
		out.print("<br>URI : "+request.getRequestURI());

	}

}

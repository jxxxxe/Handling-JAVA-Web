package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer=response.getWriter();
		
		JSONObject totalObject=new JSONObject();
		
		JSONArray membersArray = new JSONArray();
		
		JSONObject memberInfo=new JSONObject();
		memberInfo.put("name","박지성");
		memberInfo.put("age","41");
		memberInfo.put("gender","남성");
		memberInfo.put("nickname", "날쌘돌이");
		membersArray.add(memberInfo);
		
		memberInfo=new JSONObject();
		memberInfo.put("name","김연아");
		memberInfo.put("age","31");
		memberInfo.put("gender","여성");
		memberInfo.put("nickname", "연느");
		membersArray.add(memberInfo);
		
		totalObject.put("members",membersArray);
		
		String jsonInfo=totalObject.toJSONString();
		writer.print(jsonInfo);
		
	}

}

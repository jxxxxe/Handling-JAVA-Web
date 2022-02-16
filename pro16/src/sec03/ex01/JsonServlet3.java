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



@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {

	
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
		
		JSONArray bookArray=new JSONArray();
		JSONObject bookInfo=new JSONObject();
		bookInfo.put("title", "초보자를 위한 자바 프로그래밍");
		bookInfo.put("writer", "이병승");
		bookInfo.put("price", "30000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8090/pro16/image/image1.jpg");
		bookArray.add(bookInfo);
		
		bookInfo=new JSONObject();
		bookInfo.put("title", "모두의 파이썬");
		bookInfo.put("writer", "이승찬");
		bookInfo.put("price", "12000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8090/pro16/image/image2.jpg");
		bookArray.add(bookInfo);
		
		totalObject.put("books",bookArray);
		
		String jsonInfo=totalObject.toJSONString();
		System.out.print(jsonInfo);
		writer.print(jsonInfo);
		
	}

}

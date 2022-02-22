package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName=getViewName(request);
		ModelAndView mav=new ModelAndView(viewName);
		
		request.setCharacterEncoding("utf-8");
		String userID=request.getParameter("userID");
		String passwd=request.getParameter("passwd");
		
		mav.addObject("userID",userID);
		mav.addObject("passwd",passwd);
		
		return mav;
	}


	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName=getViewName(request);
		ModelAndView mav=new ModelAndView(viewName);
		
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		mav.addObject("id",id);
		mav.addObject("pwd",pwd);
		mav.addObject("name",name);
		mav.addObject("email",email);
		
		return mav;
	}	
	
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath=request.getContextPath();
		String uri=(String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null || uri.trim().contentEquals("")) {
			uri=request.getRequestURI();
		}
		
		int begin=0;
		if(!((contextPath==null)||("".contentEquals(contextPath)))) {
			begin=contextPath.length();
		}
		
		int end;
		if(uri.indexOf(";")!=-1) {
			end=uri.indexOf(";");
		} else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");
		} else {
			end=uri.length();
		}
		
		String fileName=uri.substring(begin, end);
		if(fileName.indexOf(".")!=-1) {
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		}
		if(fileName.indexOf("/")!=-1) {
			fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
		}
				
		return fileName;
	}
}

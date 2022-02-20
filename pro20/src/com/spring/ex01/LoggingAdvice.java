package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메서드 호출 전 : LoggingAdvice");
		System.out.println(invocation.getMethod()+" 메서드 호출 전"); //메서드 호출 전 수행
		
		invocation.proceed();	//타깃 메서드 호출!!!
		
		System.out.println("[메서드 호출 후 : LoggingAdvice");
		System.out.println(invocation.getMethod()+" 메서드 호출 후");	//메서드 호출 후 수행

		return null;
	}

}

package com.spring.ex01;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("AOPTest.xml"); //后 积己
		Calculator cal=(Calculator) context.getBean("proxyCal"); //后俊 立辟
		cal.add(100, 20);
		System.out.println();
		cal.subtract(100, 20);
		System.out.println();
	}

}

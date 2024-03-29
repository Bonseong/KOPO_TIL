package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * Spring aop 특징
 * 1. Runtime 기반
 * 2. Proxy 기반
 * 3. 인터페이스 기반
 */

public class EmpMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("aop-xml.xml");
		
		Employee e = context.getBean("programmer", Employee.class);
		e.work();
		
	
		
	}
}

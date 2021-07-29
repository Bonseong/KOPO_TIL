package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("beanContainer.xml"); // 더 권고되는 방법
				// new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
				//new ClassPathXmlApplicationContext("beanContainer.xml");
		
		Hello obj = (Hello)context.getBean("hello"); // return : Object
		
		obj.prnMsg();
		
		Hello obj2 = context.getBean("hello2", Hello.class); // return : Hello
		obj2.prnMsg();
		/*
		 * Hello hello = new Hello(); hello.prnMsg();
		 */
	}
}

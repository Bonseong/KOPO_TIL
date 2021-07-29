package di.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di.test01.xml");

		MyCalculator cal = context.getBean("myCalculator", MyCalculator.class);
		cal.add();

	}

}

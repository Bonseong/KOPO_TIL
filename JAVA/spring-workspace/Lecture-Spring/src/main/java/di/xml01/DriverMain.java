package di.xml01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di-xml01.xml");
		
		Car car = (Car)context.getBean("car2");
		car.prnTireBrand(); // 만약 다른 타이어를 호출하고 싶으면 xml파일에서 ref을 수정하기
		
		
		
		
		/*
		 * // 방법 1 Car car = (Car)context.getBean("car"); Tire tire =
		 * (Tire)context.getBean("tire");
		 * 
		 * car.setTire(tire); car.prnTireBrand();
		 */
		/*
		 * Car car = new Car(); Tire tire = new HankookTire();
		 * 
		 * car.setTire(tire);
		 * 
		 * car.prnTireBrand();
		 */
	}
}

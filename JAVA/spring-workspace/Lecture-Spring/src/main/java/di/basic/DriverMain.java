package di.basic;

public class DriverMain {
	public static void main(String[] args) {
		
		HankookTire han = new HankookTire();
		KumhoTire kum = new KumhoTire();
		
		Car car = new Car();
		car.setTire(han);
		car.prnTireBrand();
		
		/*// 생성자 주입방식
		 * Car car = new Car(kum); car.prnTireBrand();
		 */
		
	}

}

package di.anno02;

import javax.annotation.Resource;

public class Car {

	private Tire tire;

	public Car() {
		System.out.println("Car()...");
	}
	
	// @Resource -> 생성자에는 붙일수 없음
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}

	@Resource // Resource : set에만 할수있음
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setter");
	}

	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

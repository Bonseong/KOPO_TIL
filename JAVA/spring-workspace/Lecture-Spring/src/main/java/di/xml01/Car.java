package di.xml01;

public class Car {
	private Tire tire;

	// setter 주입
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) 호출");
	}

	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}

     
}

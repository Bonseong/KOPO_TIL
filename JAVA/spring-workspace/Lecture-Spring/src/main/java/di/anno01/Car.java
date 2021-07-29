package di.anno01;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

	@Autowired
	private Tire tire; // Car라는 클래스에 의존성을 띄는 상태
	
	public Car() { // 기본생성자가 아니라 매개변수가 있는 생성자를 호출하고자 함 -> new Car(Tire tire)
		System.out.println("Car()...");
	}


	// @Autowired : 생성자가 호출될때 자동으로 주입됨 -> 스프링컨테이너에게 알맞은 객체를 찾아 주입을 시켜주라고 함 -> xml에 찾으러감
	// Autowired 매칭 순서 : Type -> id
	
	//@Autowired 
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}

//	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setter");
	}

	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

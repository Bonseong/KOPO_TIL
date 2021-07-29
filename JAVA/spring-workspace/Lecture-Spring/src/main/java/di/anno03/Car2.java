package di.anno03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car2 {

	@Autowired //(required=false) // 삽입하고자 하는 객체가 있을경우 만들고, 없으면 null
	@Qualifier("kumhoTire")
	
	private Tire tire;

	public Car2() {
		System.out.println("Car()...");
	}
	
//	public Car(@Qualifier("hankookTire") Tire tire) { // 생성자에는 몇개의 매개변수가 들어갈지 모르기때문에 변수 앞에 지정해주어야 함
//		this.tire = tire;
//		System.out.println("Car(Tire)...");
//	}

//	@Autowired
//	@Qualifier("kumhoTire")
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setter");
	}

	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}

package di.anno03;

import org.springframework.stereotype.Component;

//@Component("tire") // resource는 이름매칭이 우선, 넥센은 Tire타입이 아님 -> 에러
public class NexenTire {
	public String getBrand() {
		return "넥센타이어";
	}
}

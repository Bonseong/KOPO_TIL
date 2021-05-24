package kr.ac.kopo.week3.day11;

public class CastMain02 {
	public static void main(String[] args) {
		//Child01 c = (Child01)new Parent(); 
		// 자식의 크기가 더 큼 -> 타입을 형변환을 통해 맞춰 줌
		// 메모리는 parent만 잡혔는데, child로 형변환을 하면 실행 시 오류
		
		Parent p = new Child02();
		p.info();
		
		Child02 c = (Child02)p; // 원래 Parent형 이지만, Child형을 가지고 싶다.
		c.info();
		c.sing();
		c.play();
		
	}
}

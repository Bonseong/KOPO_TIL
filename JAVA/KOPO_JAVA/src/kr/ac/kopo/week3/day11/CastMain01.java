package kr.ac.kopo.week3.day11;

public class CastMain01 {
	
	/*
	public static void print(Child01 c){ // 메인클래스이기에 반드시 static
		c.info();
	}
	
	public static void print(Child02 c) {
		c.info();
	}
	*/
	
	public static void print(Parent p) {
		p.info();
		if(p instanceof Child01) {
			Child01 c = (Child01)p;
			c.sleep();
			c.study();
		} else if(p instanceof Child02) {
			Child02 c= (Child02)p;
			c.sing();
			c.play();
			
		}
		
		
		/*
		System.out.println("p instanceof Child01 : " + (p instanceof Child01)); //p가 child01의 객체니? / 같은타입이나 상속관계일 경우만 사용
		System.out.println("p instanceof Child02 : " + (p instanceof Child02));
		System.out.println("p instanceof Parent : " + (p instanceof Parent));
		
		//System.out.println(p instanceof Child02); //p가 child01의 객체니? / 같은타입이나 상속관계일 경우만 사용
		  
		 */
		
	}
	
	/* child와 parent는 서로 상속 관계
	 * 굳이 child에 대한 print를 정의할 필요가 없음
	 * 매개변수 Parent p 에 대한 묵시적 형변환에 의해 child형으로 변형됨
	 * 따라서 자식클래스에 있는 info 실행 (오버라이드 된 메소드)
	 * 
	 */
	
	public static void main(String[] args) {
		
		Child01 c01 = new Child01();
		print(c01);
		
		
		Child02 c02 = new Child02();
		print(c02);
		
		Parent p = new Parent();
		print(p);
		
		/*
		Parent p = new Child01(); // 묵시적 형변환 발생 (좌변 : 부모, 우변 : 자식)
		System.out.println(p.name+ ", " + p.age);
		p.info(); // 오버라이드 된 메소드 -> 주소값이 변경됨
		*/
		
		// 오버라이드는 변수와 아무런 관계가 없음. 오직 메소드만
		
		
		/*
		Child01 c01 = new Child01();
		System.out.println(c01.name + ", " + c01.age);
		c01.info();
		
		Parent p = new Parent();
		System.out.println(p.name + ", " + p.age);
		p.info();
		*/
	}
}

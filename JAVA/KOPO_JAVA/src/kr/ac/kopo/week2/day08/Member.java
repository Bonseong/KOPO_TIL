package kr.ac.kopo.week2.day08;

public class Member {
	String name;
	int age;
	String bloodType;

	// 생성자는 일반적으로 멤버변수와 코드 사이

	Member() {
		this("알수없음"); // 이름 초기화
		//this("알수없음", -1, "알수없음");
	}

	Member(String name) {
		this(name, -1); // 나이 초기화
		
	}

	Member(String name, int age) {
		this(name, age, "알수없음"); // 혈액형 초기화
		// 매개변수 3개에게 전달, this는 항상 맨 처음에 실행해야 함
		// 2개를 전달받아도, 3개의 매개변수로서 호출 
	}
	
	Member(String name, int age, String bloodType){
		this.name = name;
		this.age = age;
		this.bloodType = bloodType;
	}

	// 지역변수와 멤버변수의 구별 필요
	// 멤버변수와 지역변수에 같은 이름이 존재한다면, 지역변수가 우선
	// 멤버변수와 지역변수간 구별이 필요할 때
	// 주로 생성자와 메소드의 매개변수 이름이 필드와 동일한 경우, 인스턴스 멤버인 필드임을 명시하고자 할때 사용
	
	// 단계별로 진행되는 메소드이기 때문에 부하가 존재
	
	void info() {
		System.out.println("이름 : " + name + ", 나이 : " + age + ", 혈액형 : " + bloodType);
	}
}

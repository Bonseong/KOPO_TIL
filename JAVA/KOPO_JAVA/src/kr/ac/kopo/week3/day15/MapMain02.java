package kr.ac.kopo.week3.day15;

import java.util.HashMap;
import java.util.Map;

class MemberInfo {
	private Member m;
	private Car c;

	MemberInfo(Member m, Car c) {
		this.m = m;
		this.c = c;
	}
}
/*
class Test {
	public Map<String, Object> returnTest2() {
		Member m = new Member();
		Car c = new Car();

		Map<String, Object> map = new HashMap<>();
		map.put("member", m);
		map.put("car", c);

		return map;
	}

	public MemberInfo returnTest3() {
		Member m = new Member();
		Car c = new Car();

		MemberInfo info = new MemberInfo(m, c);
		return info;

	}

	public Object[] returnTest() {

		Member m = new Member();
		Car c = new Car();

		Object[] arr = new Object[2];
		arr[0] = m;
		arr[1] = c;

		return arr; // 리턴 값을 여러개 넘겨줄 경우, 배열을 사용 (단, 반드시 주석을 달아줄 것)
	}
}
*/

class Member {
	private String name;

	private String phone;

	public Member(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	// source - Generate hashCode() and equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	
	
	/*
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Member mem = (Member)obj;
		name.equals(mem.name); // name은 member형인데, obj는 Object형임 -> 묵시적 형변환, 명시적 형변환이 필요
		if(name.equals(mem.name) && phone.equals(mem.phone)) {
			result = true;
		}
		return result;
	}
	*/
	

}

class Car {
	private String name;
	private String id; // 차량번호

	public Car(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

}

public class MapMain02 {
	public static void main(String[] args) {

		Map<Member, Car> carList = new HashMap<>();
		carList.put(new Member("홍길동", "010-1111-2222"), new Car("소나타", "12소1322"));
		carList.put(new Member("윤길동", "010-3333-4444"), new Car("모닝", "95소9872"));
		carList.put(new Member("박길동", "010-5555-6666"), new Car("그렌저", "54소1654"));
		carList.put(new Member("강길동", "010-7777-8888"), new Car("카니발", "65소1542"));

		System.out.println("등록대수 : " + carList.size());

		carList.put(new Member("홍길동", "010-8888-7777"), new Car("SM3", "25다2342"));
		System.out.println("등록대수 : " + carList.size());

		carList.put(new Member("홍길동", "010-1111-2222"), new Car("제네시스", "21다2423"));
		
		// new를 통해 만들었기 때문에 첫번째 홍길동과 주소값이 다름
		// map은 서로 key값을 비교하기 위해 == 이 아닌 equals를 이용함
		// object클래스 내에 equals는 주소값만 비교함
		// map에서 equals의 조건은 값도 같아야 하지만, 해시코드도 같아야 함
		// equals를 오버라이딩하여 자신이 원하는 조건으로 만들 수 있음
		

		System.out.println("등록대수 : " + carList.size()); // 6대

		
		/*
		Member m1 = new Member("테스트", "010-1111-2222");
		Member m2 = new Member("테스트", "010-1111-2222");
		
		if (m1.equals(m2)) {
			System.out.println("같은 사람입니다");
		}else {
			System.out.println("같은 사람이 아닙니다.");
		}
		*/

	}

}

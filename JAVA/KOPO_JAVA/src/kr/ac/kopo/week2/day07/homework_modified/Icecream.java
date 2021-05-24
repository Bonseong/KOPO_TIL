package kr.ac.kopo.week2.day07.homework_modified;

public class Icecream {
	String iceName;
	int price;

	void set(String n, int p) {
		iceName = n;
		price = p;
	}

	String getName() {
		return iceName;
	}

	int getPrice() {
		return price;
	}

	// 멤버변수가 아닌 메소드로 통신 -> 이름을 변경해도 에러가 나지 않음

}

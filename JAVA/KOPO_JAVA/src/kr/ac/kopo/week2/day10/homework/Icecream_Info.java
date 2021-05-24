package kr.ac.kopo.week2.day10.homework;

public class Icecream_Info {
	String ice_name;
	int ice_price;

	public String getName() {
		return ice_name;
	}

	public int getPrice() {
		return ice_price;
	}

	void set(String n, int p) {
		ice_name = n;
		ice_price = p;

//	public void setPrice(int price) {
//		ice_price = price;
//	}

//	public void setName(String name) {
//		ice_name = name;
//	}
	}
}

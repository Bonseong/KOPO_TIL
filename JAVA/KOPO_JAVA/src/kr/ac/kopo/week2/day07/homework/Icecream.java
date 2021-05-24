package kr.ac.kopo.week2.day07.homework;

public class Icecream {
	String name;
	int price;

	public Icecream() {

	}

	public Icecream(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return this.name + "\t" + this.price;
	}

}
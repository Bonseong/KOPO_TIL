package di.test01;

public class Calculator {
	public void add(int firstNum, int secondNum) {
		System.out.println("덧셈");
		System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
	}
	public void sub(int firstNum, int secondNum) {
		System.out.println("뺄셈");
		System.out.println(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
	}
	public void mul(int firstNum, int secondNum) {
		System.out.println("곱셈");
		System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
	}
	public void div(int firstNum, int secondNum) {
		System.out.println("나눗셈");
		System.out.println(firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
	}
}

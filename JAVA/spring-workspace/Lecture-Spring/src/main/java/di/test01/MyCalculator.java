package di.test01;

public class MyCalculator {
	private int firstNum;
	private int secondNum;
	private Calculator calculator;

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public void add() {
		calculator.add(firstNum, secondNum);
	}

	public void sub() {
		calculator.sub(firstNum, secondNum);
	}

	public void mul() {
		calculator.mul(firstNum, secondNum);
	}

	public void div() {
		calculator.div(firstNum, secondNum);
	}
}

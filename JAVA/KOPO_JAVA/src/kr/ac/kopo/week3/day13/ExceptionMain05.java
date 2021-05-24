package kr.ac.kopo.week3.day13;

import java.io.FileReader;

abstract class Parent {
	public abstract void print();
	public abstract void scan() throws Exception; // 추상메소드에 대한 간접처리
}

class Child extends Parent{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan() throws Exception {
		// TODO Auto-generated method stub
		
	}


}



public class ExceptionMain05 {
	public static void main(String[] args){
		
		Child obj = new Child();
		obj.print();
		try {
			obj.scan(); // scan 메소드에 대해 에러가 발생할 수 있다. -> 개발자 입장에서 좀 더 안전한 설계를 할 수 있음
		} catch (Exception e) {
			
		}
		
		
		//b();
		
		/*
		try{
			b();
		} catch (Exception e) {
			System.out.println("main() 예외처리...");
			e.printStackTrace();
		}
		*/
		//a();
	}

	public static void b() throws Exception{ // b에 대한 예외처리를 main으로 넘겨버림
		System.out.println("b() 메소드 호출...");
		String str = null;
		System.out.println(str.charAt(0));
		System.out.println(1/0);
	}
	
	
	public static void a() { // main 내 메소드이기 때문에 반드시 static
		System.out.println("a() 메소드 호출...");

		try {
			FileReader fr = new FileReader("a.txt");
		} catch (Exception e) {
			{
				e.printStackTrace();
			}

		}
	}
}
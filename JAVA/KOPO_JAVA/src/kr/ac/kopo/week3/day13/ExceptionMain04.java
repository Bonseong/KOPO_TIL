package kr.ac.kopo.week3.day13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionMain04 {
	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("a.txt"); // 컴파일 시점의 예외처리 (checked exception)
		} catch (FileNotFoundException fnfe) {
			try { // 이중 예외처리
				FileWriter fw = new FileWriter("error.log");
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	}
}

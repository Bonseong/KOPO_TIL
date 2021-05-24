package kr.ac.kopo.week3.day15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.ac.kopo.util.FileClose;

public class FileIOMain04 {
	public static void write() {

		char c = 'A';
		int i = 20;
		double d = 12.34;

		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("iodata/test.dat");
			dos = new DataOutputStream(fos);

			dos.writeChar(c);
			dos.writeInt(i);
			dos.writeDouble(d);
			System.out.println("쓰기 완료...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(dos);
			FileClose.close(fos);
		}

	}

	public static void read() {
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("iodata/test.dat");
			dis = new DataInputStream(fis);

			char c = dis.readChar();
			int i = dis.readInt();
			double d = dis.readDouble(); // 반드시 쓰여진 순서대로 읽어야 함!

			System.out.println("읽어온 데이터 출력");
			System.out.println("문자 : " + c);
			System.out.println("정수 : " + i);
			System.out.println("실수 : " + d);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(dis, fis);
		}
	}

	public static void main(String[] args) {
		write();
		read();
	}
}
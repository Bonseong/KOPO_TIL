package kr.ac.kopo.week3.day15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import kr.ac.kopo.util.FileClose;

public class FileIOMain06 {
	public static void main(String[] args) {

		write();
		read();

	}

	public static void write() {
		Dog d = new Dog("앙꼬", 4, "푸들");
		Dog d2 = new Dog("공주", 2, "요크셔테리어"); // 두개있을때는??

		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("iodata/dogInfo.txt");
			dos = new DataOutputStream(fos);

			dos.writeUTF(d.getName() + ":" + d.getAge() + ":" + d.getKind()); // utf-8
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(dos, fos);
		}
		System.out.println("dogInfo.txt에 저장완료...");
	}

	public static void read() {
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("iodata/dogInfo.txt");
			dis = new DataInputStream(fis);

			String data = dis.readUTF();
			System.out.println(data);

			String[] strArr = data.split(":");
			System.out.println(Arrays.toString(strArr));

			Dog d = new Dog(strArr[0], Integer.parseInt(strArr[1]), strArr[2]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(dis, fis);
		}
	}
}

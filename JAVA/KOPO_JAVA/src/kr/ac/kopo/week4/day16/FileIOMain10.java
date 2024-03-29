package kr.ac.kopo.week4.day16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import kr.ac.kopo.util.FileClose;

public class FileIOMain10 {
	
	public static void write() throws Exception {
		UserInfo user = new UserInfo("홍길동", 25, "서울시 서초구");
		FileWriter fw = new FileWriter("iodata/userInfo.txt");
		
		//BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(fw); // 내부적으로 buffer를 사용함
		
		pw.println(user.getName());
		pw.println(user.getAge());
		pw.println(user.getAddr());
		
		pw.flush();
		FileClose.close(pw);
		FileClose.close(fw);
		System.out.println("userInfo.txt에 저장을 완료했습니다.");
		
		// byte 형식이 아니라 문자형태로 저장했기 때문에 한글을 저장할 수 있음
	}
	
	public static void read() throws Exception{
		FileReader fr = new FileReader("iodata/userInfo.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String name = br.readLine();
		int age = Integer.parseInt(br.readLine());
		String addr = br.readLine();
		
		UserInfo user = new UserInfo(name, age, addr);
		
		FileClose.close(br);
		FileClose.close(fr);
		
		System.out.println("파일 로드를 완료하였습니다.");
		System.out.println(user);
		
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			write();
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}

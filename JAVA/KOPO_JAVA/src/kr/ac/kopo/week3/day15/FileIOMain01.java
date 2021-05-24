package kr.ac.kopo.week3.day15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIOMain01 {
	public static void main(String[] args) {
		System.out.println("입력을 하세요. ctrl+z를 누르면 종료합니다.");

		InputStream is = System.in; // 바이트 단위로 input을 받겠다.
		InputStreamReader isr = new InputStreamReader(is); // 바이트로 들어온걸 문자스트림으로 변경하겠다

		try {
			while (true) {
				int c = isr.read(); // 문자 스트림으로 읽어옴
				if (c == -1)
					break;
				System.out.print((char) c); // 입출력에 문제가 없음
			}
		} catch (IOException e) { // 입출력을 받는 것에 대해서는 반드시 예외처리가 있어야 함! (장치가 없을수도 있기 때문에)
			e.printStackTrace();
		}
		
		
		
		
		/*
		while (true) {
			int c = is.read(); // 1바이트씩 읽어옴
			if (c == -1)
				break; // 라인의 첫 열에서 ctrl + z
				System.out.print((char)c);
			// 키보드로 입력받은 모든 아스키코드는 >0, 입력받은 것이 실패했으면 -1 리턴
			// 입력버퍼를 사용하기 때문에 한번에 입력받아 한번에 출력함
			// 입력은 byte단위로 받지만, 한글은 2byte 이므로 처리할 수 없음 => InputStream을 Reader로 받아야 함
		}
		*/
	}
}

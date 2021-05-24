package kr.ac.kopo.week3.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOMain02 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			
			long start =System.currentTimeMillis();
					
			// 1. stream open
			fis = new FileInputStream("iodata/dog.jpg");
			fos = new FileOutputStream("iodata/dog2.jpg"); // 0byte, stream 연결

			// 2. read/write

			while (true) {
				int c = fis.read();

				if (c == -1)
					break;
				fos.write(c);
			}

			System.out.println("복사완료...");
			long end =System.currentTimeMillis();
			System.out.println("소요시간 : " + (end-start)/1000. + "초");

			// while (true);
			// 데이터의 일관성 유지를 위해 메소드가 끝나기 전까지 파일을 사용할 수 없음 (lock) => 0byte
			// lock은 메소드가 끝나면 해제됨 (현재는 무한루프 중이기 때문에 사용할 수 없음)

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 반드시 자원해제 해줘야함
			// 3. stream close
			try {
				fis.close();
			} catch (IOException e) { // 파일이 없다면? -> 이것또한 예외처리 필요
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// FileOutputStream fos = new FileOutputStream("aa.txt."); // path를 입력하지 않으면
		// 워크스페이스 내 java폴더 (패키지 익스플로러는 실시간 연동되지 않음)
		// 1byte씩 옮기면 너무 느림 -> BuffuerdInputStream

	}

}

package kr.ac.kopo.week3.day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.ac.kopo.util.FileClose;

public class FileIOMain03 {

	// dog.jpg -> dog3.jpg 복사
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			long start = System.currentTimeMillis();
			fis = new FileInputStream("iodata/dog.jpg");
			fos = new FileOutputStream("iodata/dog.jpg");

			// 버퍼사용 객체연결
			bis = new BufferedInputStream(fis); // fis에서 받은 데이터를 모아뒀다가 한번에 송신함
			bos = new BufferedOutputStream(fos);

			// 복사수행
			while (true) {
				int c = bis.read();
				if (c == -1)
					break;
				bos.write(c);
			}
			System.out.println("dog3.jpg에 복사완료...");
			long end = System.currentTimeMillis();
			System.out.println("소요시간 : " + (end-start)/1000. + "초");

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 닫는 것은 열었던 것 순서 반대로
			FileClose.close(bis,fis);
			FileClose.close(bos,fos);
			
			
			
//			FileClose.close(bis);
//			FileClose.close(bos);
//			FileClose.close(fis);
//			FileClose.close(fis); // 오버로딩
			
			/*	
			if (bis != null) {
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (bos != null) {
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (fis != null) {
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (fos != null) {
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			*/
		}

	}
}

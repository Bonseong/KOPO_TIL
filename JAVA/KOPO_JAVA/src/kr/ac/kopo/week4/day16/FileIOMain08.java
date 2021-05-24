package kr.ac.kopo.week4.day16;

import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;

/*
 * FileIOMain08 원본파일명 복사파일명
 */

public class FileIOMain08 {

	public static void main(String[] args) {
		// args가 2개의 배열을 가져서 첫번째에 원본파일명, 두번째에 복사할파일명을 가짐

		if (args.length != 2) {
			System.out.println("======================================================");
			System.out.println("\t 사용법 : FileIOMain08 원본파일명 복사할파일명");
			System.out.println("======================================================");
			System.exit(0);
			;
		}
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("iodata/" + args[0]);
			fw = new FileWriter("iodata/" + args[1]);

			while (true) {
				int c = fr.read();
				if (c == -1)
					break;
				fw.write(c);
			}
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fr, fw);
			System.out.println("파일 복사를 완료하였습니다.");
		}

	}
}

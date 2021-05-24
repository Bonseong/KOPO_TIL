package kr.ac.kopo.week4.day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;

// iodata/FileIOMain04.java -> iodata/FileIOMain04.java.txt 에 복사

public class FileIOMain09 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;

		BufferedReader br = null; // 버퍼사용, 효율이 높아짐
		BufferedWriter bw = null;

		try {
			fr = new FileReader("iodata/FileIOMain04.java");
			fw = new FileWriter("iodata/FileIOMain04_2.java.txt");

			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				bw.write(data);
				// bw.write('\r\n'); // OS에 따라 Enter의 기호가 달라짐
				bw.newLine();
			}
			bw.flush();

			System.out.println("파일 복사를 완료하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(br, bw);
			FileClose.close(fr, fw);

		}
	}
}

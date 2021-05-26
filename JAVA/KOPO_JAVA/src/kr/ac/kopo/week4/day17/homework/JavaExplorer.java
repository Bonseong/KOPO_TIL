package kr.ac.kopo.week4.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;




public class JavaExplorer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		File dirObj = new File("iodata");
		System.out.println("========================================================================");
		System.out.println("\t\t\t\t" + dirObj.getName() + " 정보");
		System.out.println("========================================================================");
		System.out.println("이름                          종류             크기       마지막수정날짜");
		System.out.println("------------------------------------------------------------------------");

		File[] list = dirObj.listFiles();

		for (File name : list) {
			File fileObj = new File(dirObj.getName());

			boolean bool = fileObj.isFile();
			String isFile = (bool ? "파일" : "폴더");

			long time = name.lastModified();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			System.out.printf("%-30s", name.getName());
			System.out.printf("%-3s", isFile);
			System.out.printf("%20s", name.length() + "byte(s)" + "  ");
			System.out.printf("%-20s", sdf.format(new Date(time)));
			System.out.println();

		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("[M]새폴더  [R]이름변경  [D]삭제 [.]상위폴더이동 [move]하위폴더 이동");


		
		String inputMenu = sc.nextLine();
		switch (inputMenu) {
		case "M":
			break;
		case "R":
			break;
		case "D":
			break;
		case ".":
			break;
		case "move":
			break;
		}

	}

}

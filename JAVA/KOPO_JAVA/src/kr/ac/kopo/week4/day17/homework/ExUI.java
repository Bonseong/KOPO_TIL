package kr.ac.kopo.week4.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ExUI {
	StringBuilder addr = new StringBuilder();
	String first_addr = "iodata";

	void showUI() {
		addr.append(first_addr);
		boolean isRunning = true;
		while (isRunning) {
			isRunning = menuShow();
		}
	}

	boolean menuShow() {
		File dirObj = new File(addr.toString());

		File[] list = dirObj.listFiles();
		System.out.println("-------------------------------------------");
		System.out.println("\t" + dirObj.getName() + "정보");
		System.out.println("-------------------------------------------");

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
		System.out.println("-------------------------------------------");
		System.out.println("[M]새폴더  [R]이름변경  [D]삭제 [.]상위폴더이동 [move]하위폴더 이동 [exit]종료");

		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		switch (num) {
		case "M":
			// menuLogin();
			return true;
		case "R":
			// menuRegister();
			return true;
		case "D":

			return true;
		case ".":
			return true;
		case "move":
			System.out.print("이동할 하위폴더 이름을 입력하세요");
			String addr_append = sc.nextLine();

			if (Arrays.asList(list).contains(addr_append)) {
				addr.append("\\");
				addr.append(addr_append);
			} else {
				System.out.println("해당 폴더가 존재하지 않습니다");
			}

			return true;
		case "exit":
			System.out.println("프로그램을 종료합니다");
			return false;
		default:
			System.out.println("올바른 명령이 아닙니다");
			return true;
		}

	}
}

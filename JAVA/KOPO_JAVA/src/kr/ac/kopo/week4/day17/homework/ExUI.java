package kr.ac.kopo.week4.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class ExUI {
	StringBuilder addr = new StringBuilder();
	Scanner sc = new Scanner(System.in);
	File dirObj;
	


	public void changObj(String path) {
		dirObj = new File(path);
	}
	
	void showUI() {
		String first_addr = "iodata";
		addr.append(first_addr);
		boolean isRunning = true;
		while (isRunning) {
			isRunning = menuShow();
		}
	}

	boolean menuShow() {
//		dirObj = new File(addr.toString());\
		changObj(addr.toString());
		File[] list = dirObj.listFiles();
		System.out.println("==========================================================================");
		System.out.println("\t\t\t\t" + dirObj.getName() + " 정보");
		System.out.println("==========================================================================");
		System.out.println("이름                          종류             크기       마지막수정날짜");
		System.out.println("--------------------------------------------------------------------------");

		for (File name : list) {

			boolean bool = name.isFile();
			String isFile = (bool ? "파일" : "폴더");

			long time = name.lastModified();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			System.out.printf("%-30s", name.getName());
			System.out.printf("%-3s", isFile);
			System.out.printf("%20s", name.length() + "byte(s)" + "  ");
			System.out.printf("%-20s", sdf.format(new Date(time)));
			System.out.println();

		}
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("[M]새폴더  [R]이름변경  [D]삭제 [.]상위폴더이동 [move]하위폴더 이동 [exit]종료");

		String num = sc.nextLine();
		switch (num) {
		case "M":
			mkDir();
			return true;
		case "R":
			changeName();
			return true;
		case "D":
			deleteObject();
			return true;
		case ".":
			enterParentDir();
			return true;
		case "move":
			enterChildDir();
			return true;
		case "exit":
			System.out.println("프로그램을 종료합니다");
			return false;
		default:
			System.out.println("올바른 명령이 아닙니다");
			return true;
		}

	}

	void mkDir() {

		System.out.print("생성할 폴더 이름을 입력하세요 : ");
		File newFolder = new File(addr.toString() + "\\" + sc.nextLine());

		boolean bool = newFolder.mkdir();
		System.out.println(bool ? "폴더를 생성하였습니다" : "이미 존재하는 폴더입니다");
	}

	void changeName() {
		File dirObj = new File(addr.toString());

		System.out.print("변경할 파일 이름을 입력하세요 : ");
		String beforeName = sc.nextLine();

		File[] list = dirObj.listFiles();

		boolean chk = false;
		for (File name : list) {

			if (beforeName.equals(name.getName())) {

				System.out.print("원하는 파일 이름을 입력하세요 : ");
				String afterName = sc.nextLine();
				File fileNew = new File(addr + "\\" + afterName);
				name.renameTo(fileNew);
				chk = true;
				break;

			}
		}

		if (chk == false) {
			System.out.println("파일이 존재하지 않습니다");
		}

	}

	void deleteObject() { 
		File dirObj = new File(addr.toString());

		System.out.print("삭제하고자 하는 파일이나 폴더 이름을 입력하세요 : ");
		String deleteName = sc.nextLine();

		File[] list = dirObj.listFiles();

		boolean chk = false;
		for (File name : list) {

			if (deleteName.equals(name.getName())) {
				name.delete();

				chk = true;
				break;

			}
		}

		if (chk == false) {
			System.out.println("삭제하고자 하는 파일이나 폴더가 존재하지 않습니다");
		}
	}

	void enterParentDir() {
		File dirObj = new File(addr.toString());
		String temp = dirObj.getName();

		try {

			addr.setLength(0);
			addr.append(dirObj.getParent().toString());
		} catch (NullPointerException e) {
			System.out.println("최상위 폴더입니다");
			addr.append(temp);
		}

	}

	void enterChildDir() {
		File dirObj = new File(addr.toString());
		File[] list = dirObj.listFiles();
		
		
		System.out.print("이동할 하위폴더 이름을 입력하세요 : ");
		String addr_append = sc.nextLine();

		changObj(dirObj.getPath() + "\\" + addr_append);
		boolean chk = false;

		for (File name : list) {

			if (addr_append.equals(name.getName())) {
				if (name.isDirectory()) {
					addr.append("\\");
					addr.append(addr_append);
					chk = true;
				} else {
					System.out.println("해당 파일은 폴더가 아닙니다.");
					chk = true;
				}
			}
		}

		if (chk == false) {
			System.out.println("해당 폴더는 존재하지 않습니다.");
		}
	}
}

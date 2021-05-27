package kr.ac.kopo.week4.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExUI2 {

	Scanner sc = new Scanner(System.in);
	File dirObj;
	String path;
	File[] list;

	public ExUI2() {
		path = "iodata";
		dirObj = new File(path);
		list = dirObj.listFiles();
	}

	public void changeObj(String path) {
		dirObj = new File(path);

	}

	public void changeList() {
		list = dirObj.listFiles(); // 리스트 갱신
	}

	void showUI() {
		boolean isRunning = true;
		while (isRunning) {
			changeList();
			isRunning = menuShow();
		}
	}

	boolean menuShow() {

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
		File newFolder = new File(dirObj.getName() + "\\" + sc.nextLine());
		boolean bool = newFolder.mkdir();
		System.out.println(bool ? "폴더를 생성하였습니다" : "이미 존재하는 폴더입니다");

	}

	void changeName() {

		System.out.print("변경할 파일 이름을 입력하세요 : ");
		String beforeName = sc.nextLine();

		boolean chk = false;

		check1: for (File checkbeforeName : list) {

			if (beforeName.equals(checkbeforeName.getName())) {

				System.out.print("원하는 파일 이름을 입력하세요 : ");
				String afterName = sc.nextLine();
				File fileNew = new File(dirObj.getName() + "\\" + afterName);

				for (File checkafterName : list) {
					if (afterName.equals(checkafterName.getName())) {
						System.out.println("[" + afterName + "]은 이미 존재하는 파일 또는 폴더입니다.");
						chk = true;
						break check1;
					}

				}

				checkbeforeName.renameTo(fileNew);

				chk = true;
				System.out.println("[" + beforeName + "]을 [" + afterName + "] 으로 변경했습니다.");
				break;

			}
		}

		if (chk == false) {
			System.out.println("[" + beforeName + "] 파일이 존재하지 않습니다");
		}

	}

	void deleteObject() {

		System.out.print("삭제하고자 하는 파일이나 폴더 이름을 입력하세요 : ");
		String deleteName = sc.nextLine();
		File delFile = new File(dirObj.getName() + "\\" + deleteName);
		System.out.println(delFile.delete() ? "파일 삭제에 성공했습니다." : "삭제하고자 하는 파일이나 폴더가 존재하지 않습니다.");

	}

	void enterParentDir() {

		try {
			changeObj(dirObj.getParent().toString());
		} catch (NullPointerException e) {
			System.out.println("최상위 폴더입니다.");
		}

	}

	void enterChildDir() {
		list = dirObj.listFiles();

		System.out.print("이동할 하위폴더 이름을 입력하세요 : ");
		String addr_append = sc.nextLine();

		boolean chk = false;
		for (File name : list) {

			if (addr_append.equals(name.getName())) {
				if (name.isDirectory()) {
					changeObj(dirObj.getPath() + "\\" + addr_append);
					chk = true;
					break;
				} else {
					System.out.println("폴더가 아니라 파일입니다.");
					chk = true;
				}

			}
		}

		if (chk == false) {
			System.out.println("해당 하위폴더가 존재하지 않습니다");
		}

	}
}

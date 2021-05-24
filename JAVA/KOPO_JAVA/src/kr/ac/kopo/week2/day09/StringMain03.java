package kr.ac.kopo.week2.day09;

public class StringMain03 {
	public static void main(String[] args) {
		String str = new String("hello");
		String str2 = new String("Hello"); // 서로 다른 문자열이 서로 다른 주소값을 가지고 있는 문자를 가리킴 -> queals로 해곃

//		String str = "hello";
//		String str2 = "hello"; // 하나의 문자열을 같이 가리킴

		System.out.println("str  : [" + str + "]");
		System.out.println("str2 : [" + str2 + "]");

		// 주소비교
		if (str == str2) {
			System.out.println("str == str2");
		} else {
			System.out.println("str!=str2");
		}

		// 문자열 비교
		boolean bool = str.equals(str2);
		if (bool) {
			System.out.println("equals() : str == str2");
		} else {
			System.out.println("equals() : str != str2");
		}

		// 문자열 비교 (대소문자 무시)
		bool = str.equalsIgnoreCase(str2);

		if (bool) {
			System.out.println("equalsIgnoreCase() : str == str2");
		} else {
			System.out.println("equalsIgnoreCase() : str != str2");
		}

		// 시작 문자열 확인
		str = "hello!!!";
		str2 = "hello world";

		String sub = "hello";
		bool = str.startsWith(sub);

		if (bool) {
			System.out.println("[" + str + "]은 [" + sub + "]문자열로 시작합니다.");
		} else {
			System.out.println("[" + str + "]은 [" + sub + "]문자열로 시작하지 않습니다.");
		}

		// 종료 문자열 확인
		str = "hello.txt";
		bool = str.endsWith(".txt");
		if (bool) {
			System.out.println("[" + str + "]은 텍스트파일입니다.");
		} else {
			System.out.println("[" + str + "]은 텍스트파일이 아닙니다.");
		}

		// 크기 비교
		str = "boat";
		// str2 = "board";
		str2 = "zoo";

		int compare = str.compareTo(str2);

		if (compare == 0) {
			System.out.println(str + " == " + str2);
		} else if (compare < 0) {
			System.out.println(str + " < " + str2);
		} else {
			System.out.println(str + " > " + str2);
		}

		String[] names = { "강길동", "홍길동", "홍길순", "김길동", "윤길동", "박홍철", "홍길동" };

		System.out.println("< 이름이 홍길동인 사람 검색 >");

		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {
				System.out.println(names[i]);
			}
		}

		System.out.println("< 홍씨성을 가진 사람 검색 >");
		for (String name : names) {
			if (name.startsWith("홍")) {
				System.out.println(name);
			}

		}

		System.out.println("< 이름이 길동인 사람 검색 >");
		for (String name : names) {
			if (name.endsWith("길동")) {
				System.out.println(name);
			}
		}

		System.out.println("< 홍이 포함된 사람 검색 >");
		for (String name : names) {
			if (name.contains("홍")) {
				System.out.println(name);
			}
		}

		str = "hello world";
		int searchIdx = str.indexOf("o");
		System.out.println("\"o\" indexOf() 위치 : " + searchIdx);

		searchIdx = str.indexOf("o", 5); // 5번지부터 찾겠다.
		System.out.println("\"o\" indexOf(5) 위치 : " + searchIdx);

		searchIdx = str.lastIndexOf("o");
		System.out.println("\"o\" lastIndexOf() 위치 : " + searchIdx);

		char ch = 'l';
		System.out.println("<" + str + "에서 \"l\" 위치 >");

		searchIdx = str.indexOf(ch);
		while (searchIdx != -1) {
			System.out.println("검색된 위치 : " + searchIdx);
			searchIdx = str.indexOf(ch, searchIdx + 1);

		}
		// ====================
		System.out.println("앞에서 부터 탐색");
		searchIdx = -1;
		while ((searchIdx = str.indexOf(ch, searchIdx + 1)) != -1) {
			System.out.println("검색된 위치 : " + searchIdx);

		}

		// ====================
		System.out.println("뒤에서 부터 탐색");
		searchIdx = str.length() + 1;
		while ((searchIdx = str.lastIndexOf(ch, searchIdx - 1)) != -1) {
			System.out.println("검색된 위치 : " + searchIdx);

		}
		
		

	}
}

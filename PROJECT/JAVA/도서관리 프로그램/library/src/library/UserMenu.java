package library;

import java.util.Scanner;

public class UserMenu implements User {
	UserManager userManager;
	BookManager bookManager;
	Scanner sc = new Scanner(System.in);

	UserMenu() {
		this.userManager = new UserManager();
		this.bookManager = new BookManager();
		for (Book book : bookManager.getBookList()) {
			if (book.getBorrowedId() != null) {
				userManager.getUserMap().get(book.getBorrowedId()).getBorrowedBookList().add(book);
			}
		}
	}

	void showUI() {
		boolean isRunning = true;
		try {
			while (isRunning) {
				if (userManager.userState) {
					if (userManager.currentLoginUser.getId().equals("admin")) {
						menuAdmin();
					} else {
						menuShowLogin();
					}
				} else {
					isRunning = menuShow();
				}
			}
		} finally {
			bookManager.save();
			userManager.save();
		}
	}

	boolean menuShow() {

		System.out.println("=============================");
		System.out.println("도서관리 프로그램에 오신것을 환영합니다.");

		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("1 : 로그인   /   2 : 회원가입   /   3 : 종료");

		String num = sc.nextLine();
		switch (num) {
		case "1":
			menuLogin();
			return true;
		case "2":
			menuRegister();
			return true;
		case "3":
			System.out.println("프로그램을 종료합니다.");
			return false;
		default:
			System.out.println("올바르지 않은 명령입니다. 다시 입력해주세요.");
			return true;
		}
	}

	void menuShowLogin() {

		System.out.println("=============================");
		System.out.println("원하시는 메뉴를 선택하여 주세요");
		System.out.println("1 : 도서검색   /   2 : 도서대여   /   3 : 도서반납");
		System.out.println("4 : 도서목록   /   5 : 로그아웃   /   6 : 회원정보");
		System.out.println("7 : 회원탈퇴");

		String num = sc.nextLine();

		switch (num) {
		case "1":
			findBook();
			break;
		case "2":
			borrowBook();
			break;
		case "3":
			returnBook();
			break;
		case "4":
			listBook();
			break;
		case "5":
			menuLogout();
			break;
		case "6":
			printUserInfo();
			break;
		case "7":
			menuWithDraw();
			break;
		default:
			System.out.println("올바르지 않은 명령입니다. 다시 입력해주세요.");
			break;
		}
	}

	void menuAdmin() {
		System.out.println("=============================");
		System.out.println("도서관리 관리자 메뉴입니다.");

		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("1 : 도서등록   /   2 : 도서목록   /   3 : 인기도서");
		System.out.println("4 : 도서삭제   /   5 : 회원목록   /   6 : 회원삭제");
		System.out.println("7 : 로그아웃");

		String num = sc.nextLine();
		switch (num) {
		case "1":
			addBook();
			break;
		case "2":
			adminlistBook();
			break;
		case "3":
			printBestSeller();
			break;
		case "4":
			deleteBook();
			break;
		case "5":
			showuserList();
			break;
		case "6":
			deleteUser();
			break;
		case "7":
			menuLogout();
			break;
		default:
			System.out.println("올바르지 않은 명령입니다. 다시 입력해주세요.");
			break;
		}
	}

	// 도서추가
	void addBook() {
		System.out.println("도서 등록 메뉴입니다.");
		System.out.print("도서 제목을 입력해주세요 : ");
		String title = sc.nextLine();
		if (bookManager.findBook(title) != null) {
			System.out.println("이미 있는 도서 제목입니다.");
			return;
		}
		System.out.print("도서 장르를 입력해주세요: ");
		String genre = sc.nextLine();
		Book newBook = new Book(title, genre);
		bookManager.addBook(newBook);
		System.out.println("도서 추가되었습니다.");
	}

	// 도서삭제
	void deleteBook() {
		System.out.println("도서 삭제 메뉴입니다.");
		System.out.print("삭제할 도서 제목을 입력해주세요 : ");
		String title = sc.nextLine();
		Book book = bookManager.findBook(title);
		if (book == null) {
			System.out.println("찾으시는 도서가 없습니다.");
			return;
		}

		if (book.isBorrowed()) {
			System.out.println("해당 도서는 대여중인 도서이기에 삭제할 수 없습니다.");
			return;
		}

		bookManager.deleteBook(book);
		System.out.println("도서가 삭제되었습니다.");

	}

	void showuserList() {
		System.out.println("회원목록 메뉴입니다.");
		System.out.println("현재 가입되어 있는 회원은 다음과 같습니다.");
		for (UserInfo user : userManager.userMap.values()) {
			System.out.println(user.getId());
		}
	}

	// 유저삭제
	void deleteUser() {
		System.out.println("회원 삭제 메뉴입니다.");
		System.out.print("삭제할 회원 ID를 입력해주세요 : ");
		String id = sc.nextLine();
		UserInfo userInfo = userManager.getUserMap().get(id);

		if (userInfo == null) {
			System.out.println("찾으시는 회원이 없습니다.");
			return;
		}

		int book_check = userInfo.getBorrowedBookList().size();
		if (book_check != 0) {
			System.out.println("이미 대여중인 " + book_check + "권의 도서가 있습니다.");
			System.out.println("도서 반납 후 회원 삭제를 진행해 주세요.");
			return;
		}

		userManager.getUserMap().remove(id);
		System.out.println("회원 삭제되었습니다.");
	}

	// 베스트셀러 출력
	void printBestSeller() {
		System.out.println("인기도서 메뉴입니다.");
		Book bestSeller = null;
		for (Book book : bookManager.getBookList()) {
			if (bestSeller == null || book.getBorrowCount() > bestSeller.getBorrowCount()) {
				bestSeller = book;
			}
		}
		if (bestSeller == null) {
			System.out.println("인기도서 도서가 없습니다.");
			return;
		}
		System.out.println("인기도서 정보입니다.");
		System.out.println("제목 : " + bestSeller.getTitle());
		System.out.println("장르 : " + bestSeller.getGenre());
		System.out.println("대여 여부 : " + bestSeller.isBorrowed());
		if (bestSeller.isBorrowed()) {
			System.out.println("대여자 ID : " + bestSeller.getBorrowedId());
			System.out.println("대여일 : " + bestSeller.getBorrowedDate());

		}
	}

	// 도서검색
	public void findBook() {
		System.out.println("도서 검색 메뉴입니다.");
		System.out.print("찾으시는 도서 제목을 입력해주세요 : ");
		String title = sc.nextLine();
		Book book = bookManager.findBook(title);
		if (book == null) {
			System.out.println("찾으시는 도서이 없습니다.");
			return;
		}
		System.out.println("찾은 도서 정보입니다.");
		System.out.println("제목: " + book.getTitle());
		System.out.println("장르: " + book.getGenre());
		System.out.println("대여 여부: " + book.isBorrowed());
		if (book.isBorrowed()) {
			System.out.println("대여일: " + book.getBorrowedDate());
		}
	}

	// 도서대여
	public void borrowBook() {
		System.out.println("도서 대여 메뉴입니다.");
		System.out.print("대여할 도서 제목을 입력해주세요: ");
		String title = sc.nextLine();
		boolean result = bookManager.borrowBook(userManager.currentLoginUser, title);
		if (result) {
			System.out.println("도서 대여되었습니다.");
		} else {
			System.out.println("도서 대여에 실패했습니다.");
		}
	}

	// 도서반납
	public void returnBook() {
		System.out.println("도서 반납 메뉴입니다.");
		System.out.print("반납할 도서 제목을 입력해주세요 : ");
		String title = sc.nextLine();
		boolean result = bookManager.returnBook(userManager.currentLoginUser, title);
		if (result) {
			System.out.println("도서 반납되었습니다.");
		} else {
			System.out.println("도서 반납에 실패했습니다.");
		}
	}

	// 도서목록 호출 메소드
	public void listBook() {
		System.out.println("도서 목록 메뉴입니다.");
		bookManager.printBookList();
	}

	// 관리자 도서목록 호출 메소드
	void adminlistBook() {
		System.out.println("관리자 도서 목록 메뉴입니다.");
		bookManager.printAdminBookList();
	}

	String insertId(String msg) {
		while (true) {
			System.out.print(msg);
			String id = sc.nextLine();
			if (id.length() == 0 || !isAlphabet(id.charAt(0))) {
				System.out.println("ID는 첫 글자 영문자로 입력해주세요.");
				continue;
			}
			return id;
		}
	}

	boolean isAlphabet(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	String insertPw(String msg) {
		while (true) {
			System.out.print(msg);
			String pw = sc.nextLine();
			if (pw.length() > 10) {
				System.out.println("PW는 10자리를 넘어갈 수 없습니다.");
				continue;
			}
			return pw;
		}
	}

	// 메뉴 로그인
	void menuLogin() {
		int loginCount = 0;
		System.out.println("로그인 입니다.");
		while (true) {
			String id = insertId("ID를 입력해주세요 : ");
			String pw = insertPw("패스워드를 입력해주세요 : ");
			boolean result = userManager.login(id, pw);
			if (!result) {
				loginCount++;
				System.out.println("ID 또는 패스워드가 틀렸습니다. 현재 로그인 시도: " + loginCount + "/3");
				if (loginCount >= 3) {
					System.out.println("잘못된 로그인 시도가 3회이상이므로 종료합니다.");
					System.exit(1);
				}
			} else {
				break;
			}
		}
	}

	// 자동가입방지 문자입력
	boolean checkAutoRegister() {
		String captcha = "";
		for (int i = 1; i <= 6; i++) {
			captcha += (char) ((Math.random() * 26) + 65);
		}
		System.out.println("자동 가입 방지 문자 : " + captcha);
		System.out.print("위 문자를 입력해주세요 : ");
		String userInput = sc.nextLine();
		if (captcha.equals(userInput)) {
			return true;
		} else {
			System.out.println("잘못 입력하셨습니다.");
			return false;
		}
	}

	// 회원가입
	void menuRegister() {
		System.out.println("회원가입 입니다.");
		while (true) {
			String id = insertId("ID를 입력해주세요 : ");
			String pw = insertPw("패스워드를 입력해주세요 : ");
			if (!checkAutoRegister()) {
				break;
			}
			boolean result = userManager.register(id, pw);
			if (result) {
				break;
			}
		}
	}

	// 로그아웃
	public void menuLogout() {
		userManager.userCheck();
		System.out.println("로그아웃 하셨습니다.");
	}

	// 회원탈퇴
	public void menuWithDraw() {
		System.out.println("회원 탈퇴 메뉴입니다.");
		System.out.print("비밀번호를 다시 입력해주세요: ");
		String pw = sc.nextLine();
		if (!userManager.currentLoginUser.getPw().equals(pw)) {
			System.out.println("비밀번호가 다릅니다.");
			return;
		}
		userManager.userWithdrawal();
	}

	// 회원정보
	public void printUserInfo() {
		userManager.printUserInfo();
	}
}

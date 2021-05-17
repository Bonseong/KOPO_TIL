package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
	private static File BOOK_FILE = new File("./src/library/book.txt");
	private List<Book> bookList;

	public BookManager() {
		bookList = new ArrayList<>();
		try {
			if (!BOOK_FILE.exists()) {
				System.out.println("Book 저장 파일이 없습니다.");
				return;
			}
			BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE));
			String input = "";
			while ((input = br.readLine()) != null) {
				String[] inputSplit = input.split("\t");
				String title = inputSplit[0];
				String genre = inputSplit[1];
				Book newBook = new Book(title, genre);
				boolean isBorrowed = Boolean.parseBoolean(inputSplit[2]);
				newBook.setBorrowed(isBorrowed);
				if (isBorrowed) {
					String borrowedId = inputSplit[3];
					String borrowedDate = inputSplit[4];
					newBook.setBorrowedId(borrowedId);
					newBook.setBorrowedDate(borrowedDate);
				}
				bookList.add(newBook);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Book> getBookList() {
		return bookList;
	}

	// 도서등록
	public void addBook(Book newBook) {
		bookList.add(newBook);
	}

	// 도서삭제
	public void deleteBook(Book book) {
		bookList.remove(book);
	}

	// 도서대여
	public boolean borrowBook(UserInfo userInfo, String title) {
		Book book = findBook(title);
		if (book == null) {
			System.out.println("찾으시는 도서가 없습니다. 입력한 도서 제목 : " + title);
			return false;
		}
		if (userInfo.getBorrowedBookList().size() >= 3) {
			System.out.println("도서 대여는 총 3권까지만 가능합니다. 현재 대여 권수 : " + userInfo.getBorrowedBookList().size());
			return false;
		}
		if (book.isBorrowed()) {
			System.out.println("해당 도서는 이미 대여중입니다.");
			return false;
		}
		book.setBorrowed(true);
		book.setBorrowedId(userInfo.getId());
		book.setBorrowedDate(DateUtils.getToday());
		book.setBorrowCount(book.getBorrowCount() + 1);
		userInfo.getBorrowedBookList().add(book);
		return true;
	}

	// 도서반납
	public boolean returnBook(UserInfo userInfo, String title) {
		Book book = findBook(title);
		if (book == null) {
			System.out.println("찾는 도서가 없습니다. 입력한 도서 제목 : " + title);
			return false;
		}
		if (!userInfo.getBorrowedBookList().contains(book)) {
			System.out.println("대여한 도서가 아닙니다.");
			return false;
		}
		book.setBorrowed(false);
		book.setBorrowedId(null);
		book.setBorrowedDate(null);
		userInfo.getBorrowedBookList().remove(book);
		return true;
	}

	// 도서검색
	public Book findBook(String title) {
		for (Book book : bookList) {
			if (title.equals(book.getTitle())) {
				return book;
			}
		}
		return null;
	}

	// 책 파일 저장
	public void save() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(BOOK_FILE));
			for (Book book : bookList) {
				bw.write(book.toString());
				bw.newLine();
			}
			System.out.println("도서 정보를 저장했습니다. (File : " + BOOK_FILE.getName() + ")");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 유저 도서목록
	public void printBookList() {
		System.out.println("제목\t\t\t장르\t\t대여 여부\t\t대여 날짜\t\t");
		System.out.println("================================================================================");

		for (Book book : bookList) {
			System.out.print(book.getTitle() + "\t\t");
			System.out.print(book.getGenre() + "\t\t");
			System.out.print(book.isBorrowed() + "\t\t\t");
			if (book.isBorrowed()) {
				System.out.print(book.getBorrowedDate() + "\t\t");
			}
			System.out.println();

		}
	}

	// 관리자 도서목록
	public void printAdminBookList() {
		System.out.println("제목\t\t\t장르\t\t대여 여부\t\t회원ID\t\t대여 날짜");
		System.out.println("================================================================================");

		for (Book book : bookList) {
			System.out.print(book.getTitle() + "\t\t");
			System.out.print(book.getGenre() + "\t\t");
			System.out.print(book.isBorrowed() + "\t\t");
			if (book.isBorrowed()) {
				System.out.print(book.getBorrowedId() + "\t\t");
				System.out.print(book.getBorrowedDate() + "\t\t");
			}
			System.out.println();

		}
	}
}

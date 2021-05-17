package library;

public interface User {
	public void findBook(); // 도서검색

	public void borrowBook(); // 도서대여

	public void returnBook(); // 도서반납

	public void listBook(); // 도서목록

	public void menuLogout(); // 로그아웃

	public void printUserInfo(); // 회원정보

	public void menuWithDraw(); // 회원탈퇴

}

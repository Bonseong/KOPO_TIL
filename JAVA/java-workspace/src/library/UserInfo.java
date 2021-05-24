package library;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	private String id;
	private String pw;
	private List<Book> borrowedBookList;

	UserInfo(String id, String pw) {
		this.id = id;
		this.pw = pw;
		borrowedBookList = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public List<Book> getBorrowedBookList() {
		return borrowedBookList;
	}

    @Override
    public String toString() {
        return id + "\t" + pw;
    }
}
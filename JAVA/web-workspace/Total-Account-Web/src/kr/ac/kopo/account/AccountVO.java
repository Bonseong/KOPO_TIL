package kr.ac.kopo.account;

public class AccountVO {
	private String acc_no;
	private String bank_name;
	private String bank_code;
	private String id;
	private int balance;
	private String password;
	private String nickname;
	private String creatingDate;
	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountVO(String acc_no, String bank_name, String bank_code, String id, int balance, String password,
			String nickname, String creatingDate) {
		super();
		this.acc_no = acc_no;
		this.bank_name = bank_name;
		this.bank_code = bank_code;
		this.id = id;
		this.balance = balance;
		this.password = password;
		this.nickname = nickname;
		this.creatingDate = creatingDate;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCreatingDate() {
		return creatingDate;
	}
	public void setCreatingDate(String creatingDate) {
		this.creatingDate = creatingDate;
	}
	@Override
	public String toString() {
		return "AccountVO [acc_no=" + acc_no + ", bank_name=" + bank_name + ", bank_code=" + bank_code + ", id=" + id
				+ ", balance=" + balance + ", password=" + password + ", nickname=" + nickname + ", creatingDate="
				+ creatingDate + "]";
	}
	
	
	
	
}
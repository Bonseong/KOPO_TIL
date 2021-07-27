package kr.ac.kopo.openBank;

public class OpenBankVO {

	private String openBankName;
	private String openAccNo;
	private String id;
	private String password;
	private String rrn;
	private String openAccList;
	private int balance;

	public OpenBankVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpenBankVO(String openBankName, String openAccNo, String id, String password, String rrn, String openAccList,
			int balance) {
		super();
		this.openBankName = openBankName;
		this.openAccNo = openAccNo;
		this.id = id;
		this.password = password;
		this.rrn = rrn;
		this.openAccList = openAccList;
		this.balance = balance;
	}

	public String getOpenBankName() {
		return openBankName;
	}

	public void setOpenBankName(String openBankName) {
		this.openBankName = openBankName;
	}

	public String getOpenAccNo() {
		return openAccNo;
	}

	public void setOpenAccNo(String openAccNo) {
		this.openAccNo = openAccNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getOpenAccList() {
		return openAccList;
	}

	public void setOpenAccList(String openAccList) {
		this.openAccList = openAccList;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "OpenBankVO [openBankName=" + openBankName + ", openAccNo=" + openAccNo + ", id=" + id + ", password="
				+ password + ", rrn=" + rrn + ", openAccList=" + openAccList + ", balance=" + balance + "]";
	}

}

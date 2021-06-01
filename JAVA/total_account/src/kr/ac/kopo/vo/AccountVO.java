package kr.ac.kopo.vo;

public class AccountVO {
	private int accId;
	private String bankCode;
	private int userNo;
	private String accNo;
	private int balance;
	private String accPw;
	private String accNickname;
	public AccountVO() {
		super();
	}
	public AccountVO(int accId, String bankCode, int userNo, String accNo, int balance, String accPw,
			String accNickname) {
		super();
		this.accId = accId;
		this.bankCode = bankCode;
		this.userNo = userNo;
		this.accNo = accNo;
		this.balance = balance;
		this.accPw = accPw;
		this.accNickname = accNickname;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccPw() {
		return accPw;
	}
	public void setAccPw(String accPw) {
		this.accPw = accPw;
	}
	public String getAccNickname() {
		return accNickname;
	}
	public void setAccNickname(String accNickname) {
		this.accNickname = accNickname;
	}
	@Override
	public String toString() {
		return "AccountVO [accId=" + accId + ", bankCode=" + bankCode + ", userNo=" + userNo + ", accNo=" + accNo
				+ ", balance=" + balance + ", accPw=" + accPw + ", accNickname=" + accNickname + "]";
	}

	
	
		
}

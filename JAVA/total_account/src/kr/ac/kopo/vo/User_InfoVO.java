package kr.ac.kopo.vo;

public class User_InfoVO {
	private int userNo;
	private String id;
	private String pw;
	private String userName;
	private String mobileNo;
	public User_InfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_InfoVO(int userNo, String id, String pw, String userName, String mobileNo) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.mobileNo = mobileNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "User_InfoVO [userNo=" + userNo + ", id=" + id + ", pw=" + pw + ", userName=" + userName + ", mobileNo="
				+ mobileNo + "]";
	}
	
}

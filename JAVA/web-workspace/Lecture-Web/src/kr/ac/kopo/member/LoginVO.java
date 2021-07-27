package kr.ac.kopo.member;

public class LoginVO {
	private String id;
	private String name;
	private String password;
	private String rrn;
	private String email;
	private String email_domain;
	private String tel1;
	private String tel2;
	private String tel3;
	private String post;
	private String basic_addr;
	private String detail_addr;
	private String type;
	private String reg_date;

	public LoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginVO(String id, String name, String password, String rrn, String email, String email_domain, String tel1,
			String tel2, String tel3, String post, String basic_addr, String detail_addr, String type,
			String reg_date) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.rrn = rrn;
		this.email = email;
		this.email_domain = email_domain;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.post = post;
		this.basic_addr = basic_addr;
		this.detail_addr = detail_addr;
		this.type = type;
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_domain() {
		return email_domain;
	}

	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBasic_addr() {
		return basic_addr;
	}

	public void setBasic_addr(String basic_addr) {
		this.basic_addr = basic_addr;
	}

	public String getDetail_addr() {
		return detail_addr;
	}

	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", name=" + name + ", password=" + password + ", rrn=" + rrn + ", email=" + email
				+ ", email_domain=" + email_domain + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", post="
				+ post + ", basic_addr=" + basic_addr + ", detail_addr=" + detail_addr + ", type=" + type
				+ ", reg_date=" + reg_date + "]";
	}

}

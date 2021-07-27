package kr.ac.kopo.bank;

public class BankVO {
	private int bank_code;
	private String bank_name;
	private String bank_name_eng;
	public BankVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankVO(int bank_code, String bank_name, String bank_name_eng) {
		super();
		this.bank_code = bank_code;
		this.bank_name = bank_name;
		this.bank_name_eng = bank_name_eng;
	}
	public int getBank_code() {
		return bank_code;
	}
	public void setBank_code(int bank_code) {
		this.bank_code = bank_code;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_name_eng() {
		return bank_name_eng;
	}
	public void setBank_name_eng(String bank_name_eng) {
		this.bank_name_eng = bank_name_eng;
	}
	@Override
	public String toString() {
		return "BankVO [bank_code=" + bank_code + ", bank_name=" + bank_name + ", bank_name_eng=" + bank_name_eng + "]";
	}
	
	

	

}

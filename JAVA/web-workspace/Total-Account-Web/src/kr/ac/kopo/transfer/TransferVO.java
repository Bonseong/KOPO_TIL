package kr.ac.kopo.transfer;

public class TransferVO {
	private String logDate;
	private String sendingBankName;
	private String sendingAccNO;
	private int beforeBalance;
	private int remittance;
	private int afterBalance;
	private String receivingBankName;
	private String receivingAccNO;
	public TransferVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransferVO(String logDate, String sendingBankName, String sendingAccNO, int beforeBalance, int remittance,
			int afterBalance, String receivingBankName, String receivingAccNO) {
		super();
		this.logDate = logDate;
		this.sendingBankName = sendingBankName;
		this.sendingAccNO = sendingAccNO;
		this.beforeBalance = beforeBalance;
		this.remittance = remittance;
		this.afterBalance = afterBalance;
		this.receivingBankName = receivingBankName;
		this.receivingAccNO = receivingAccNO;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getSendingBankName() {
		return sendingBankName;
	}
	public void setSendingBankName(String sendingBankName) {
		this.sendingBankName = sendingBankName;
	}
	public String getSendingAccNO() {
		return sendingAccNO;
	}
	public void setSendingAccNO(String sendingAccNO) {
		this.sendingAccNO = sendingAccNO;
	}
	public int getBeforeBalance() {
		return beforeBalance;
	}
	public void setBeforeBalance(int beforeBalance) {
		this.beforeBalance = beforeBalance;
	}
	public int getRemittance() {
		return remittance;
	}
	public void setRemittance(int remittance) {
		this.remittance = remittance;
	}
	public int getAfterBalance() {
		return afterBalance;
	}
	public void setAfterBalance(int afterBalance) {
		this.afterBalance = afterBalance;
	}
	public String getReceivingBankName() {
		return receivingBankName;
	}
	public void setReceivingBankName(String receivingBankName) {
		this.receivingBankName = receivingBankName;
	}
	public String getReceivingAccNO() {
		return receivingAccNO;
	}
	public void setReceivingAccNO(String receivingAccNO) {
		this.receivingAccNO = receivingAccNO;
	}
	@Override
	public String toString() {
		return "TransferVO [logDate=" + logDate + ", sendingBankName=" + sendingBankName + ", sendingAccNO="
				+ sendingAccNO + ", beforeBalance=" + beforeBalance + ", remittance=" + remittance + ", afterBalance="
				+ afterBalance + ", receivingBankName=" + receivingBankName + ", receivingAccNO=" + receivingAccNO
				+ "]";
	}
	
	
	
}

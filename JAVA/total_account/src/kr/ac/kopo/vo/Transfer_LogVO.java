package kr.ac.kopo.vo;

public class Transfer_LogVO {
	private int logNO;
	private String logDate;
	private int sendingAccId;
	private int receivingAccId;
	private int remittance;
	public Transfer_LogVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transfer_LogVO(int logNO, String logDate, int sendingAccId, int receivingAccId, int remittance) {
		super();
		this.logNO = logNO;
		this.logDate = logDate;
		this.sendingAccId = sendingAccId;
		this.receivingAccId = receivingAccId;
		this.remittance = remittance;
	}
	public int getLogNO() {
		return logNO;
	}
	public void setLogNO(int logNO) {
		this.logNO = logNO;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public int getSendingAccId() {
		return sendingAccId;
	}
	public void setSendingAccId(int sendingAccId) {
		this.sendingAccId = sendingAccId;
	}
	public int getReceivingAccId() {
		return receivingAccId;
	}
	public void setReceivingAccId(int receivingAccId) {
		this.receivingAccId = receivingAccId;
	}
	public int getRemittance() {
		return remittance;
	}
	public void setRemittance(int remittance) {
		this.remittance = remittance;
	}
	@Override
	public String toString() {
		return "Transfer_LogVO [logNO=" + logNO + ", logDate=" + logDate + ", sendingAccId=" + sendingAccId
				+ ", receivingAccId=" + receivingAccId + ", remittance=" + remittance + "]";
	}
	
	
	
	
}

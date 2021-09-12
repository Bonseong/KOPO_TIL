package kr.ac.kopo.card.vo;

public class HistoryVO {
	private String historyDate;
	private String category;
	private int amount;
	private String store;
	private String cardName;
	private String cardNo;
	private String cardCode;

	private int start;
	private int end;

	public HistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoryVO(String historyDate, String category, int amount, String store, String cardName, String cardNo,
			String cardCode, int start, int end) {
		super();
		this.historyDate = historyDate;
		this.category = category;
		this.amount = amount;
		this.store = store;
		this.cardName = cardName;
		this.cardNo = cardNo;
		this.cardCode = cardCode;
		this.start = start;
		this.end = end;
	}

	public String getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "HistoryVO [historyDate=" + historyDate + ", category=" + category + ", amount=" + amount + ", store="
				+ store + ", cardName=" + cardName + ", cardNo=" + cardNo + ", cardCode=" + cardCode + ", start="
				+ start + ", end=" + end + "]";
	}

}

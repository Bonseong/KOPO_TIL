package kr.ac.kopo.card.vo;

public class CardVO {
	private String cardNo;
	private int memberNo;
	private String cardName;
	private String cardPassword;
	private String validDate;
	private String cardType;
	private String cvcNo;

	public CardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardVO(String cardNo, int memberNo, String cardName, String cardPassword, String validDate, String cardType,
			String cvcNo) {
		super();
		this.cardNo = cardNo;
		this.memberNo = memberNo;
		this.cardName = cardName;
		this.cardPassword = cardPassword;
		this.validDate = validDate;
		this.cardType = cardType;
		this.cvcNo = cvcNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardPassword() {
		return cardPassword;
	}

	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCvcNo() {
		return cvcNo;
	}

	public void setCvcNo(String cvcNo) {
		this.cvcNo = cvcNo;
	}

	@Override
	public String toString() {
		return "CardVO [cardNo=" + cardNo + ", memberNo=" + memberNo + ", cardName=" + cardName + ", cardPassword="
				+ cardPassword + ", validDate=" + validDate + ", cardType=" + cardType + ", cvcNo=" + cvcNo + "]";
	}

}

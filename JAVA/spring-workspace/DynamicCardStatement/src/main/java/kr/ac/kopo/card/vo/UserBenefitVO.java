package kr.ac.kopo.card.vo;

public class UserBenefitVO {
	private String cardName;
	private String cardType;
	private String annualFeeType;
	private String annualFeeRange;
	
	private String communication;
	private String air_mileage;
	private String cafe_bakery;
	private String always_discount;
	private String beauty;
	private String cvs;
	private String movie;
	private String education;
	private String hypermart;
	private String culture;
	private String OIL;
	private String public_transportation;
	private String shopping;
	private String leisure;
	private String point_cashback;
	private String medical;
	private String eat_out;
	private String maintenance;
	private String easy_pay;
	public UserBenefitVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBenefitVO(String cardName, String cardType, String annualFeeType, String annualFeeRange,
			String communication, String air_mileage, String cafe_bakery, String always_discount, String beauty,
			String cvs, String movie, String education, String hypermart, String culture, String oIL,
			String public_transportation, String shopping, String leisure, String point_cashback, String medical,
			String eat_out, String maintenance, String easy_pay) {
		super();
		this.cardName = cardName;
		this.cardType = cardType;
		this.annualFeeType = annualFeeType;
		this.annualFeeRange = annualFeeRange;
		this.communication = communication;
		this.air_mileage = air_mileage;
		this.cafe_bakery = cafe_bakery;
		this.always_discount = always_discount;
		this.beauty = beauty;
		this.cvs = cvs;
		this.movie = movie;
		this.education = education;
		this.hypermart = hypermart;
		this.culture = culture;
		OIL = oIL;
		this.public_transportation = public_transportation;
		this.shopping = shopping;
		this.leisure = leisure;
		this.point_cashback = point_cashback;
		this.medical = medical;
		this.eat_out = eat_out;
		this.maintenance = maintenance;
		this.easy_pay = easy_pay;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getAnnualFeeType() {
		return annualFeeType;
	}
	public void setAnnualFeeType(String annualFeeType) {
		this.annualFeeType = annualFeeType;
	}
	public String getAnnualFeeRange() {
		return annualFeeRange;
	}
	public void setAnnualFeeRange(String annualFeeRange) {
		this.annualFeeRange = annualFeeRange;
	}
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	public String getAir_mileage() {
		return air_mileage;
	}
	public void setAir_mileage(String air_mileage) {
		this.air_mileage = air_mileage;
	}
	public String getCafe_bakery() {
		return cafe_bakery;
	}
	public void setCafe_bakery(String cafe_bakery) {
		this.cafe_bakery = cafe_bakery;
	}
	public String getAlways_discount() {
		return always_discount;
	}
	public void setAlways_discount(String always_discount) {
		this.always_discount = always_discount;
	}
	public String getBeauty() {
		return beauty;
	}
	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}
	public String getCvs() {
		return cvs;
	}
	public void setCvs(String cvs) {
		this.cvs = cvs;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getHypermart() {
		return hypermart;
	}
	public void setHypermart(String hypermart) {
		this.hypermart = hypermart;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public String getOIL() {
		return OIL;
	}
	public void setOIL(String oIL) {
		OIL = oIL;
	}
	public String getPublic_transportation() {
		return public_transportation;
	}
	public void setPublic_transportation(String public_transportation) {
		this.public_transportation = public_transportation;
	}
	public String getShopping() {
		return shopping;
	}
	public void setShopping(String shopping) {
		this.shopping = shopping;
	}
	public String getLeisure() {
		return leisure;
	}
	public void setLeisure(String leisure) {
		this.leisure = leisure;
	}
	public String getPoint_cashback() {
		return point_cashback;
	}
	public void setPoint_cashback(String point_cashback) {
		this.point_cashback = point_cashback;
	}
	public String getMedical() {
		return medical;
	}
	public void setMedical(String medical) {
		this.medical = medical;
	}
	public String getEat_out() {
		return eat_out;
	}
	public void setEat_out(String eat_out) {
		this.eat_out = eat_out;
	}
	public String getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}
	public String getEasy_pay() {
		return easy_pay;
	}
	public void setEasy_pay(String easy_pay) {
		this.easy_pay = easy_pay;
	}
	@Override
	public String toString() {
		return "UserBenefitVO [cardName=" + cardName + ", cardType=" + cardType + ", annualFeeType=" + annualFeeType
				+ ", annualFeeRange=" + annualFeeRange + ", communication=" + communication + ", air_mileage="
				+ air_mileage + ", cafe_bakery=" + cafe_bakery + ", always_discount=" + always_discount + ", beauty="
				+ beauty + ", cvs=" + cvs + ", movie=" + movie + ", education=" + education + ", hypermart=" + hypermart
				+ ", culture=" + culture + ", OIL=" + OIL + ", public_transportation=" + public_transportation
				+ ", shopping=" + shopping + ", leisure=" + leisure + ", point_cashback=" + point_cashback
				+ ", medical=" + medical + ", eat_out=" + eat_out + ", maintenance=" + maintenance + ", easy_pay="
				+ easy_pay + "]";
	}
			
}

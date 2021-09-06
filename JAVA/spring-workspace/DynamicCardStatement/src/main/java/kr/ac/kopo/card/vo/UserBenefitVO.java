package kr.ac.kopo.card.vo;

public class UserBenefitVO {

	private String paramName;
	private int paramMin;
	private String paramValue;
	private int paramMax;
	public UserBenefitVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBenefitVO(String paramName, int paramMin, String paramValue, int paramMax) {
		super();
		this.paramName = paramName;
		this.paramMin = paramMin;
		this.paramValue = paramValue;
		this.paramMax = paramMax;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public int getParamMin() {
		return paramMin;
	}
	public void setParamMin(int paramMin) {
		this.paramMin = paramMin;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public int getParamMax() {
		return paramMax;
	}
	public void setParamMax(int paramMax) {
		this.paramMax = paramMax;
	}
	@Override
	public String toString() {
		return "UserBenefitVO [paramName=" + paramName + ", paramMin=" + paramMin + ", paramValue=" + paramValue
				+ ", paramMax=" + paramMax + "]";
	}
		
}

package kr.ac.kopo.card.vo;

public class BenefitVO {
	private String category;
	private String categoryKor;
	public BenefitVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BenefitVO(String category, String categoryKor) {
		super();
		this.category = category;
		this.categoryKor = categoryKor;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryKor() {
		return categoryKor;
	}
	public void setCategoryKor(String categoryKor) {
		this.categoryKor = categoryKor;
	}
	@Override
	public String toString() {
		return "BenefitVO [category=" + category + ", categoryKor=" + categoryKor + "]";
	}
		
}

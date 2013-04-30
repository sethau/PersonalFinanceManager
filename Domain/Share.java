package Domain;

public class Share {
	
	private int value;
	private String company;
	
	public Share(int value, String company) {
		this.value = value;
		this.company = company;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getCompany() {
		return company;
	}
}
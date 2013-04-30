package Domain;

public class Stock {

	private String company;
	private int numShares;
	private double perShareValue;
	
	public Stock(String company, int numShares, double perShareValue) {
		this.company = company;
		this.numShares = numShares;
		this.perShareValue = perShareValue;
	}
	
	public String getCompany() {
		return company;
	}
	
	public int getNumShares() {
		return numShares;
	}
	
	public double getPerShareValue() {
		return perShareValue;
	}
}
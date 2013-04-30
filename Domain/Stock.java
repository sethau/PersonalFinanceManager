package Domain;

public class Stock {

	private String company;
	private int numShares;
	
	public Stock(String company, int numShares) {
		this.company = company;
		this.numShares = numShares;
	}
	
	public String getCompany() {
		return company;
	}
	
	public int getNumShares() {
		return numShares;
	}
	
	public boolean setNumShares(int numShares) {
		this.numShares = numShares;
		return true;
	}
}
package Domain;

public class Portfolio {

	private String profile;
	private double balance;
	
	public Portfolio(String profile, double balance) {
		this.profile = profile;
		this.balance = balance;
	}
	
	public Portfolio(String profile) {
		this(profile, 0);
	}
	
	public String getProfile() {
		return profile;
	}
	
	public double getBalance() {
		return balance;
	}
}
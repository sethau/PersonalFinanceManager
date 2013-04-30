package Domain;

public class CreditAccount extends Account {

	private double limit;
	
	public CreditAccount(String profile, String name, double balance, double interest) {
		super(profile, name, balance, interest);
	}
	
	public CreditAccount(String profile, String name, double balance) {
		super(profile, name, balance);
	}
	
	public CreditAccount(String profile, String name) {
		super(profile, name);
	}
	
	public double getLimit() {
		return limit;
	}
	
	public boolean setLimit(double limit) {
		this.limit = limit;
		return true;
	}
}
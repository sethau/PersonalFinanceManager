package Domain;

public class LoanAccount extends Account {

	public LoanAccount(String profile, String name, double balance, double interest) {
		super(profile, name, balance, interest);
	}
	
	public LoanAccount(String profile, String name, double balance) {
		super(profile, name, balance);
	}
	
	public LoanAccount(String profile, String name) {
		super(profile, name);
	}
}
package Domain;

public class SavingsAccount extends Account {

	public SavingsAccount(String profile, String name, double balance, double interest) {
		super(profile, name, balance, interest);
	}
	
	public SavingsAccount(String profile, String name, double balance) {
		super(profile, name, balance);
	}
	
	public SavingsAccount(String profile, String name) {
		super(profile, name);
	}
}
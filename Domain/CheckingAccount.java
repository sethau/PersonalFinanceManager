package Domain;

public class CheckingAccount extends Account{

	public CheckingAccount(String profile, String name, double balance, double interest) {
		super(profile, name, balance, interest);
	}
	
	public CheckingAccount(String profile, String name, double balance) {
		super(profile, name, balance);
	}
	
	public CheckingAccount(String profile, String name) {
		super(profile, name);
	}
}

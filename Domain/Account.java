package Domain;

public abstract class Account {
	
	private String name, profile;
	private double balance, interest;
	private int status;
	public static final int OPEN = 0, CLOSED = 1;
	public static final int LOAN = 0, CREDIT = 1, CHECKING = 2, SAVINGS = 3;
	
	public Account(String profile, String name, double balance, double interest) {
		this.profile = profile;
		this.name = name;
		this.interest = interest;
		this.balance = balance;
		status = OPEN;
	}
	
	public Account(String profile, String name, double balance) {
		this(profile, name, 0, balance);
	}
	
	public Account(String profile, String name) {
		this(profile, name, 0, 0);
	}
	
	//might be removed later
	public Account() {
		this(null, null, 0, 0);
	}
	
	public String getProfile() {
		return profile;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterest() {
		return interest;
	}
	
	public int getStatus() {
		return status;
	}
	
	public boolean changeBalance(double amount) {
		balance += amount;
		return true;
	}
	
	public boolean closeAccount() {
		status = CLOSED;
		return true;
	}
}
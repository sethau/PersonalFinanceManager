package Domain;
import java.util.ArrayList;

public class Profile {
	
	String username, password;
	ArrayList<Account> accounts;
	Portfolio portfolio;
	
	public Profile(String username, String password) {
		this.username = username;
		this.password = password;
		updateAccounts();
		updatePortfolio();
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public Portfolio getPortfolio() {
		return portfolio;
	}
	
	public boolean updateAccounts() {
		
		
		return true;
	}
	
	public boolean updatePortfolio() {
		
		
		return true;
	}
	
	public boolean addAccount(Account account) {
		
		
		return true;
	}
	
	public boolean deleteAccount(String name) {
		
		
		return true;
	}
	
	public double getNetWorth() {
		
		
		return -1;
	}
}
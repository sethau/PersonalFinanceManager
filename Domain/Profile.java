package Domain;
import java.util.ArrayList;

public class Profile {
	
	String username, password;
	ArrayList<String> accounts;
	
	public Profile(String username, String password) {
		this.username = username;
		this.password = password;
		updateAccounts();
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ArrayList<String> getAccounts() {
		return accounts;
	}
	
	public boolean updateAccounts() {
		
		
		return true;
	}
	
	public boolean addAccount(Account account) {
		
		
		return true;
	}
	
	public boolean deleteAccounte(String name) {
		
		
		return true;
	}
	
	public double getNetWorth() {
		
		
		return -1;
	}
}
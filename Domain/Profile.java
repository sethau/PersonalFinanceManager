package Domain;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Controllers.AccountController;
import Controllers.PortfolioController;

public class Profile {
	
	String username, password;
	ArrayList<Account> accounts;
	Portfolio portfolio;
	
	public Profile(String username, String password) throws FileNotFoundException {
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
	
	public boolean updateAccounts() throws FileNotFoundException {
		accounts = AccountController.getAll(this);
		
		return true;
	}
	
	public boolean updatePortfolio() throws FileNotFoundException {
		portfolio = PortfolioController.get(this);
		
		return true;
	}
	
	public boolean addAccount(Account account) throws IOException {
		accounts.add(account);
		AccountController.saveEntire(this, account);
		
		return true;
	}
	
	public boolean deleteAccount(String name) throws IOException {
		Account account = AccountController.get(this, name);
		accounts.remove(account);
		AccountController.remove(this, account);
		
		return true;
	}
}
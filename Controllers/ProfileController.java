package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Account;
import Domain.CheckingAccount;
import Domain.CreditAccount;
import Domain.LoanAccount;
import Domain.Profile;
import Domain.RepositoryAdaptor;

public class ProfileController {
	
	public ProfileController() {}
	
	public static boolean save(Profile profile) throws IOException {
		return RepositoryAdaptor.saveProfile(profile);
	}
	
	public static boolean saveEntire(Profile profile) throws IOException {
		return RepositoryAdaptor.saveEntireProfile(profile);
	}

	public static boolean remove(Profile profile) throws IOException {
		return RepositoryAdaptor.deleteProfile(profile);
	}

	public static Profile get(String username) throws FileNotFoundException {
		return RepositoryAdaptor.getProfile(username);
	}

	public static ArrayList<Profile> getAll() throws FileNotFoundException {
		return RepositoryAdaptor.getProfiles();
	}
	
	public double getNetWorth(Profile profile) throws FileNotFoundException {
		ArrayList<Account> accounts = AccountController.getAll(profile);
		
		double accountValue = 0;
		for (Account account : accounts) {
			if (account instanceof LoanAccount) {
				accountValue -= account.getBalance();
			} else if (account instanceof CreditAccount) {
				accountValue -= account.getBalance();
			} else if (account instanceof CheckingAccount) {
				accountValue += account.getBalance();
			} else {
				accountValue += account.getBalance();
			}
		}
		double portfolioValue = PortfolioController.getStockValue(profile);
		
		return accountValue + portfolioValue;
	}
	
	public static Object createForm(String id) {
		
		
		return null;
	}
	
	public static String viewAccounts(Profile profile) {
		
		
		return null;
	}
	
	public static String viewPortfolio(Profile profile) {
		
		
		return null;
	}
}
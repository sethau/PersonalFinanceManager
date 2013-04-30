package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Account;
import Domain.Profile;
import Domain.RepositoryAdaptor;

public class AccountController {
	
	public AccountController() {}
	
	public static boolean save(Profile profile, Account account) throws IOException {
		return RepositoryAdaptor.saveAccount(profile, account);
	}
	
	public static boolean saveEntire(Profile profile, Account account) throws IOException {
		return RepositoryAdaptor.saveEntireAccount(profile, account);
	}

	public static boolean remove(Profile profile, Account account) throws IOException {
		return RepositoryAdaptor.deleteAccount(profile, account);
	}

	public static Account get(Profile profile, String name) throws FileNotFoundException {
		return RepositoryAdaptor.getAccount(profile, name);
	}
	
	public static ArrayList<Account> getAll(Profile profile) throws FileNotFoundException {
		return RepositoryAdaptor.getAccounts(profile);
	}
	
	public static int viewAccounts(Profile profile) {
		return AccountForm.viewAccounts(getAll(profile));
	}
	
	public static String createForm(String menuOption, Profile profile, int selection) {
		ArrayList<Account> accounts = getAll(profile);
		Account account;
		int index;
		if (menuOption.equals("Create Account")) {
			account = AccountForm.newAccount(profile);
			if (account == null) {
				return "Back";
			}
			else {
				save(profile, account);
				return "Created";
			}
		}
		else if (menuOption.equals("Close Account")) {
			index = AccountForm.closeAccount(accounts);
			String result;
			
			if (index == 0) {
				return "Back";
			}
			else {
				remove(profile, accounts.get(index));
				return "Created";
			}
		}
		else if (menuOption.equals("View Account")) {
			account = accounts.get(selection - 4);
			result = AccountForm.viewAccount(account);
			if (result.equals("View Transactions")
				|| result.equals("New Transaction")) {
				TransactionController.createForm(result, profile, account);
			}
			return result;
		}
	}
}

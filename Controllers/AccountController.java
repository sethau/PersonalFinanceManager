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
}

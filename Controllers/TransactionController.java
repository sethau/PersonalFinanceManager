package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Account;
import Domain.Profile;
import Domain.RepositoryAdaptor;
import Domain.Transaction;

public class TransactionController extends Controller {
	
	public TransactionController() {}
	
	public static boolean save(Profile profile, Account account, Transaction transaction) throws IOException {
		return RepositoryAdaptor.saveTransaction(profile, account, transaction);
	}

	public static boolean remove(Profile profile, Account account, Transaction transaction) throws IOException {
		return RepositoryAdaptor.deleteTransaction(profile, account, transaction);
	}

	public static Transaction get(Account account, long timestamp) throws FileNotFoundException {
		return RepositoryAdaptor.getTransaction(account, timestamp);
	}
	
	public static ArrayList<Transaction> getAll(Account account) throws FileNotFoundException {
		return RepositoryAdaptor.getTransactions(account);
	}
	
	public static String createForm(String menuOption, Profile profile, Account account) {
		if (menuOption.equals("View Transactions") {
			String result = TransactionForm.viewTransactions(profile, account);
			if (result.equals("Back")) {
			
			}
			else if (result.equals("All")) {
			
			}
			else if (result.equals("Date")) {
			
			}
			else if (result.equals("Vendor")) {
			
			}
			else if (result.equals("Category")) {
			
			}
		}
		else if (result.equals("New Transaction")) {
			save(profile, account, TransactionForm.newTransaction(account));
		}
		return "Back";		
	}
}
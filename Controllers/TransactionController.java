package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Account;
import Domain.Profile;
import Domain.RepositoryAdaptor;
import Domain.Transaction;
import Forms.TransactionForm;

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
	
	public static String createForm(String menuOption, Profile profile, Account account) throws IOException {
		if (menuOption.equals("View Transactions")) {
			String result = TransactionForm.viewTransactions();
			if (result.equals("All")) {
				ArrayList<Transaction> transactions = getAll(account);
				TransactionForm.displayTransactions(transactions);
			}
			else if (result.equals("Vendor")) {
				String vendor = TransactionForm.getVendor();
				ArrayList<Transaction> transactions = getAll(account);
				ArrayList<Transaction> transForVendor = new ArrayList<Transaction>();
				for (Transaction transaction : transactions) {
					if (transaction.getVendor().equals(vendor)) {
						transForVendor.add(transaction);
					}
				}
				TransactionForm.displayTransactions(transForVendor);
			}
			else if (result.equals("Category")) {
				String category = TransactionForm.getCategory();
				ArrayList<Transaction> transactions = getAll(account);
				ArrayList<Transaction> transForCategory = new ArrayList<Transaction>();
				for (Transaction transaction : transactions) {
					if (transaction.getCategory().equals(category)) {
						transForCategory.add(transaction);
					}
				}
				TransactionForm.displayTransactions(transForCategory);
			}
		}
		else if (menuOption.equals("New Transaction")) {
			save(profile, account, TransactionForm.newTransaction(account));
		}
		return "Back";		
	}
}
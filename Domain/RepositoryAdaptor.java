package Domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class RepositoryAdaptor {
	
	public static final String DATA_PATH = "../Profiles";
	
	public RepositoryAdaptor() {
		
	}
	
	public static Profile getProfile(String username) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + username);
		if (dir.exists()) {
			File profInfo = new File(DATA_PATH + "/" + username + "/password.txt");
			if (!profInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(profInfo);
			String password = scan.nextLine();
			return new Profile(username, password);
		}
		
		return null;
	}
	
	public static ArrayList<Profile> getProfiles() throws FileNotFoundException {
		File dir = new File(DATA_PATH);
		String[] profDirs = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		for (String profDir : profDirs) {
			Profile prof = getProfile(profDir);
			profiles.add(prof);
		}
		return profiles;
	}
	
	public static Account getAccount(Profile profile, String name) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername() + "/" + name);
		if (dir.exists()) {
			File acctInfo = new File(DATA_PATH + "/" + profile.getUsername() + "/" + name
				+ "/accountInfo.txt");
			if (!acctInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(acctInfo);
			double balance, interest;
			int type;
			balance = Double.parseDouble(scan.nextLine());
			interest = Double.parseDouble(scan.nextLine());
			type = Integer.parseInt(scan.nextLine());
			switch (type) {
			case Account.LOAN:
				return new LoanAccount(profile.getUsername(), name, interest, balance);
			case Account.CREDIT:
				return new CreditAccount(profile.getUsername(), name, interest, balance);
			case Account.CHECKING:
				return new CheckingAccount(profile.getUsername(), name, interest, balance);
			case Account.SAVINGS:
				return new SavingsAccount(profile.getUsername(), name, interest, balance);
			default:
				return null;
			}
		}
		return null;
	}
	
	public static ArrayList<Account> getAccounts(Profile profile) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername());
		String[] acctDirs = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		ArrayList<Account> accounts = new ArrayList<Account>();
		for (String acctDir : acctDirs) {
			Account acct = getAccount(profile, acctDir);
			accounts.add(acct);
		}
		return accounts;
	}
	
	public static Transaction getTransaction(Account account, long timestamp) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + account.getProfile() + "/" + account.getName());
		if (dir.exists()) {
			File transInfo = new File(DATA_PATH + "/" + account.getProfile() + "/"
				+ account.getName() + "/Transactions/" + timestamp + ".txt");
			if (!transInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(transInfo);
			double amount;
			String vendor;
			amount = Double.parseDouble(scan.nextLine());
			vendor = scan.nextLine();
			return new Transaction(amount, vendor, timestamp);
		}
		return null;
	}
	
	public static ArrayList<Transaction> getTransactions(Account account) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + account.getProfile() + "/" + account.getName()
				+ "/Transactions");
		String[] transDirs = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isFile();
			}
		});
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		for (String transDir : transDirs) {
			Long timestamp = Long.parseLong(transDir);
			Transaction trans = getTransaction(account, timestamp);
			transactions.add(trans);
		}
		return transactions;
	}
	
	public static Portfolio getPortfolio(Profile profile) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio");
		if (dir.exists()) {
			File portInfo = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio"
				+ "/portfolioInfo.txt");
			if (!portInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(portInfo);
			double balance;
			balance = Double.parseDouble(scan.nextLine());
			return new Portfolio(profile.getUsername(), balance);
		}
		return null;
	}
	
	public static Trade getTrade(Portfolio portfolio, long timestamp) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + portfolio.getProfile() + "/Portfolio/Trades");
		if (dir.exists()) {
			File tradeInfo = new File(DATA_PATH + "/" + portfolio.getProfile() + "/Portfolio"
				+ "/Trades/" + timestamp + ".txt");
			if (!tradeInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(tradeInfo);
			int numStocks;
			String company;
			numStocks = Integer.parseInt(scan.nextLine());
			company = scan.nextLine();
			return new Trade(numStocks, company, timestamp);
		}
		return null;
	}
	
	public static ArrayList<Trade> getTrades(Portfolio portfolio) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + portfolio.getProfile() + "/Portfolio/Trades");
		String[] tradeDirs = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isFile();
			}
		});
		ArrayList<Trade> trades = new ArrayList<Trade>();
		for (String tradeDir : tradeDirs) {
			Long timestamp = Long.parseLong(tradeDir);
			Trade trade = getTrade(portfolio, timestamp);
			trades.add(trade);
		}
		return trades;
	}
	
	public static Stock getStock(Portfolio portfolio, String company) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + portfolio.getProfile() + "/Portfolio/Stocks");
		if (dir.exists()) {
			File stockInfo = new File(DATA_PATH + "/" + portfolio.getProfile() + "/Portfolio"
				+ "/Stocks/" + company + ".txt");
			if (!stockInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(stockInfo);
			int numShares;
			double perShareValue;
			numShares = Integer.parseInt(scan.nextLine());
			perShareValue = Double.parseDouble(scan.nextLine());
			return new Stock(company, numShares, perShareValue);
		}
		return null;
	}
	
	public static ArrayList<Stock> getStocks(Portfolio portfolio) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + portfolio.getProfile() + "/Portfolio/Stocks");
		String[] stockDirs = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isFile();
			}
		});
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		for (String stockDir : stockDirs) {
			Stock stock = getStock(portfolio, stockDir);
			stocks.add(stock);
		}
		return stocks;
	}
}

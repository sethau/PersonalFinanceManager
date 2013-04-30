package Domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
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
				return new LoanAccount(profile.getUsername(), name, balance, interest);
			case Account.CREDIT:
				return new CreditAccount(profile.getUsername(), name, balance, interest);
			case Account.CHECKING:
				return new CheckingAccount(profile.getUsername(), name, balance, interest);
			case Account.SAVINGS:
				return new SavingsAccount(profile.getUsername(), name, balance, interest);
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
			String vendor, category;
			amount = Double.parseDouble(scan.nextLine());
			vendor = scan.nextLine();
			category = scan.nextLine();
			return new Transaction(amount, vendor, category, timestamp);
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
			
			Long timestamp = Long.parseLong(transDir.replaceAll(".txt", ""));
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
	
	public static Trade getTrade(Profile profile, long timestamp) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Trades");
		if (dir.exists()) {
			File tradeInfo = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio"
				+ "/Trades/" + timestamp + ".txt");
			if (!tradeInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(tradeInfo);
			int numStocks;
			String company;
			double price;
			numStocks = Integer.parseInt(scan.nextLine());
			company = scan.nextLine();
			price = Double.parseDouble(scan.nextLine());
			return new Trade(numStocks, company, price, timestamp);
		}
		return null;
	}
	
	public static ArrayList<Trade> getTrades(Profile profile) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Trades");
		String[] tradeDirs = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isFile();
			}
		});
		ArrayList<Trade> trades = new ArrayList<Trade>();
		for (String tradeDir : tradeDirs) {
			Long timestamp = Long.parseLong(tradeDir.replaceAll(".txt", ""));
			Trade trade = getTrade(profile, timestamp);
			trades.add(trade);
		}
		return trades;
	}
	
	public static Stock getStock(Profile profile, String company) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Stocks");
		if (dir.exists()) {
			File stockInfo = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio"
				+ "/Stocks/" + company + ".txt");
			if (!stockInfo.exists()) {
				return null;
			}
			Scanner scan = new Scanner(stockInfo);
			int numShares;
			numShares = Integer.parseInt(scan.nextLine());
			return new Stock(company, numShares);
		}
		return null;
	}
	
	public static ArrayList<Stock> getStocks(Profile profile) throws FileNotFoundException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Stocks");
		String[] stockDirs = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isFile();
			}
		});
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		for (String stockDir : stockDirs) {
			Stock stock = getStock(profile, stockDir.replaceAll(".txt", ""));
			stocks.add(stock);
		}
		return stocks;
	}
	
	public static boolean saveProfile(Profile profile) throws IOException {
		File profFile = new File(DATA_PATH + "/" + profile.getUsername() + "/password.txt");
		File profDir = new File(DATA_PATH + "/" + profile.getUsername());
		if (!profDir.exists()) {
			profDir.mkdir();
			File portDir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio");
			portDir.mkdir();
			File stockDir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Stocks");
			stockDir.mkdir();
			File tradeDir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Trades");
			tradeDir.mkdir();
			File portFile = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/"
					+ "portfolioInfo.txt");
			portFile.createNewFile();
			profFile.createNewFile();
		}
		PrintWriter out = new PrintWriter(profFile);
		out.println(profile.getPassword());
		out.close();
		return true;
	}
	
	public static boolean saveEntireProfile(Profile profile) throws IOException {
		File profFile = new File(DATA_PATH + "/" + profile.getUsername() + "/password.txt");
		File profDir = new File(DATA_PATH + "/" + profile.getUsername());
		if (!profDir.exists()) {
			profDir.mkdir();
			File portDir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio");
			portDir.mkdir();
			File stockDir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Stocks");
			stockDir.mkdir();
			File tradeDir = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Trades");
			tradeDir.mkdir();
			File portFile = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/"
					+ "portfolioInfo.txt");
			portFile.createNewFile();
			profFile.createNewFile();
		}
		PrintWriter out = new PrintWriter(profFile);
		out.println(profile.getPassword());
		out.close();
		
		saveEntirePortfolio(profile, getPortfolio(profile));
		
		ArrayList<Account> accounts = getAccounts(profile);
		for (Account account : accounts) {
			saveEntireAccount(profile, account);
		}
		
		return true;
	}
	
	public static boolean savePortfolio(Profile profile, Portfolio portfolio) throws FileNotFoundException {
		File portFile = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/"
			+ "portfolioInfo.txt");
		PrintWriter out = new PrintWriter(portFile);
		out.println(portfolio.getBalance());
		out.close();
		return true;
	}
	
	public static boolean saveEntirePortfolio(Profile profile, Portfolio portfolio) throws IOException {
		File portFile = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/"
			+ "portfolioInfo.txt");
		PrintWriter out = new PrintWriter(portFile);
		out.println(portfolio.getBalance());
		out.close();
		
		ArrayList<Stock> stocks = getStocks(profile);
		for (Stock stock : stocks) {
			saveStock(profile, stock);
		}
		
		ArrayList<Trade> trades = getTrades(profile);
		for (Trade trade : trades) {
			saveTrade(profile, trade);
		}
		
		return true;
	}
	
	public static boolean saveAccount(Profile profile, Account account) throws IOException {
		File acctFile = new File(DATA_PATH + "/" + profile.getUsername() + "/" + account.getName()
			+ "/accountInfo.txt");
		File acctDir = new File(DATA_PATH + "/" + profile.getUsername() + "/" + account.getName());
		if (!acctDir.exists()) {
			acctDir.mkdir();
			File transDir = new File(DATA_PATH + "/" + profile.getUsername() + "/"
				+ account.getName() + "/Transactions");
			transDir.mkdir();
			acctFile.createNewFile();
		}
		PrintWriter out = new PrintWriter(acctFile);
		out.println(account.getBalance());
		out.println(account.getInterest());
		int type;
		if (account instanceof LoanAccount) {
			type = Account.LOAN;
		} else if (account instanceof CreditAccount) {
			type = Account.CREDIT;
		} else if (account instanceof CheckingAccount) {
			type = Account.CHECKING;
		} else {
			type = Account.SAVINGS;
		}
		out.println(type);
		out.close();
		return true;
	}
	
	public static boolean saveEntireAccount(Profile profile, Account account) throws IOException {
		File acctFile = new File(DATA_PATH + "/" + profile.getUsername() + "/" + account.getName()
			+ "/accountInfo.txt");
		File acctDir = new File(DATA_PATH + "/" + profile.getUsername() + "/" + account.getName());
		if (!acctDir.exists()) {
			acctDir.mkdir();
			File transDir = new File(DATA_PATH + "/" + profile.getUsername() + "/"
				+ account.getName() + "/Transactions");
			transDir.mkdir();
			acctFile.createNewFile();
		}
		PrintWriter out = new PrintWriter(acctFile);
		out.println(account.getBalance());
		out.println(account.getInterest());
		int type;
		if (account instanceof LoanAccount) {
			type = Account.LOAN;
		} else if (account instanceof CreditAccount) {
			type = Account.CREDIT;
		} else if (account instanceof CheckingAccount) {
			type = Account.CHECKING;
		} else {
			type = Account.SAVINGS;
		}
		out.println(type);
		out.close();
		
		ArrayList<Transaction> transactions = getTransactions(account);
		for (Transaction transaction : transactions) {
			saveTransaction(profile, account, transaction);
		}
		
		return true;
	}
	
	public static boolean saveStock(Profile profile, Stock stock) throws IOException {
		File stockFile = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Stocks/"
			+ stock.getCompany() + ".txt");
		if (!stockFile.exists()) {
			stockFile.createNewFile();
		}
		PrintWriter out = new PrintWriter(stockFile);
		out.println(stock.getNumShares());
		out.close();
		return true;
	}
	
	public static boolean saveTrade(Profile profile, Trade trade) throws IOException {
		File tradeFile = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Trades/"
			+ trade.getDate() + ".txt");
		if (!tradeFile.exists()) {
			tradeFile.createNewFile();
		}
		PrintWriter out = new PrintWriter(tradeFile);
		out.println(trade.getNumStocks());
		out.println(trade.getCompany());
		out.println(trade.getPrice());
		out.close();
		Stock stock = getStock(profile, trade.getCompany());
		if (stock == null) {
			stock = new Stock(trade.getCompany(), trade.getNumStocks());
		} else {
			stock.setNumShares(stock.getNumShares() + trade.getNumStocks());
		}
		saveStock(profile, stock);
		
		return true;
	}
	
	public static boolean saveTransaction(Profile profile, Account account, Transaction transaction) throws IOException {
		File transFile = new File(DATA_PATH + "/" + profile.getUsername() + "/" + account.getName()
			+ "/Transactions/" + transaction.getDate() + ".txt");
		if (!transFile.exists()) {
			transFile.createNewFile();
		}
		PrintWriter out = new PrintWriter(transFile);
		out.println(transaction.getAmount());
		out.println(transaction.getVendor());
		out.println(transaction.getCategory());
		out.close();
		return true;
	}
	
	public static boolean deleteProfile(Profile profile) throws IOException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername());
		if (dir.exists()) {
			delete(dir);
		}
		return true;
	}
	
	public static boolean deleteAccount(Profile profile, Account account) throws IOException {
		File dir = new File(DATA_PATH + "/" + profile.getUsername() + "/" + account.getName());
		if (dir.exists()) {
			delete(dir);
		}
		return true;
	}
	
	public static boolean deleteStock(Profile profile, Stock stock) throws IOException {
		File file = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Stocks/"
			+ stock.getCompany() + ".txt");
		if (file.exists()) {
			delete(file);
		}
		return true;
	}
	
	public static boolean deleteTrade(Profile profile, Trade trade) throws IOException {
		File file = new File(DATA_PATH + "/" + profile.getUsername() + "/Portfolio/Trades/"
			+ trade.getDate() + ".txt");
		if (file.exists()) {
			Stock stock = getStock(profile, trade.getCompany());
			stock.setNumShares(stock.getNumShares() - trade.getNumStocks());
			saveStock(profile, stock);
			
			delete(file);
		}
		return true;
	}
	
	public static boolean deleteTransaction(Profile profile, Account account, Transaction transaction) throws IOException {
		File file = new File(DATA_PATH + "/" + profile.getUsername() + "/" + account.getName()
			+ "/Transactions/" + transaction.getDate() + ".txt");
		if (file.exists()) {
			delete(file);
		}
		return true;
	}

	private static boolean delete(File file) throws IOException {
		if(file.isDirectory()) {
			if (file.list().length == 0) {
				file.delete();
			} else {
				String files[] = file.list();
				
				for (String temp : files) {
					File fileDelete = new File(file, temp);
					delete(fileDelete);
				}
				if (file.list().length == 0) {
					file.delete();
				}
			}
		} else {
			file.delete();
		}
		return true;
	}
}

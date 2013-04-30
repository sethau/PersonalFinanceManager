package Domain;

import java.util.ArrayList;

public class Portfolio {

	private String profile;
	private double balance;
	private ArrayList<Trade> trades;
	private ArrayList<Stock> stocks;
	
	public Portfolio(String profile, double balance) {
		this.profile = profile;
		this.balance = balance;
		updateTrades();
		updateStocks();
	}
	
	public Portfolio(String profile) {
		this(profile, 0);
	}
	
	public String getProfile() {
		return profile;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public ArrayList<Trade> getTrades() {
		return trades;
	}
	
	public ArrayList<Stock> getStocks() {
		return stocks;
	}
	
	public boolean updateTrades() {
		
		
		return true;
	}
	
	public boolean updateStocks() {
		
		
		return true;
	}
}
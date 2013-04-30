package Domain;

import java.util.ArrayList;

public class Portfolio {

	private double balance;
	private ArrayList<Trade> trades;
	
	public Portfolio(double balance) {
		this.balance = balance;
		updateTrades();
	}
	
	public Portfolio() {
		this(0);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public ArrayList<Trade> getTrades() {
		return trades;
	}
	
	public boolean updateTrades() {
		
		
		return true;
	}
}
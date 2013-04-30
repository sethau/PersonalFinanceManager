package Domain;

import java.util.Date;

public class Trade {

	private int numStocks;
	private String company;
	private double price;
	private long date;
	
	public Trade(int numStocks, String company, double price, long date) {
		this.numStocks = numStocks;
		this.company = company;
		this.date = date;
		this.price = price;
	}
	
	public Trade(int numStocks, String company, double price) {
		this.numStocks = numStocks;
		this.company = company;
		Date creation = new Date();
		date = creation.getTime();
		this.price = price;
	}
	
	public int getNumStocks() {
		return numStocks;
	}
	
	public String getCompany() {
		return company;
	}
	
	public long getDate() {
		return date;
	}
	
	public double getPrice() {
		return price;
	}
}
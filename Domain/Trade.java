package Domain;

import java.util.Date;

public class Trade {

	private int numStocks;
	private String company;
	private long date;
	
	public Trade(int numStocks, String company, long date) {
		this.numStocks = numStocks;
		this.company = company;
		this.date = date;
	}
	
	public Trade(int numStocks, String company) {
		this.numStocks = numStocks;
		this.company = company;
		Date creation = new Date();
		date = creation.getTime();
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
}
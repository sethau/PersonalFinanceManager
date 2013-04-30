package Domain;

import java.util.Date;

public class Transaction {
	
	private double amount;
	private long date;
	private String vendor;
	
	public Transaction(double amount, String vendor, long date) {
		this.amount = amount;
		this.vendor = vendor;
		this.date = date;
	}
	
	public Transaction(double amount, String vendor) {
		this.amount = amount;
		this.vendor = vendor;
		Date creation = new Date();
		date = creation.getTime();
	}
	
	public Transaction(double amount) {
		this(amount, "");
	}
	
	public double getAmount() {
		return amount;
	}
	
	public long getDate() {
		return date;
	}
	
	public String getVendor() {
		return vendor;
	}
}
package Domain;

import java.util.Date;

public class Transaction {
	
	private double amount;
	private long date;
	private String vendor, category;
	
	public Transaction(double amount, String vendor, String category, long date) {
		this.amount = amount;
		this.vendor = vendor;
		this.date = date;
		this.category = category;
	}
	
	public Transaction(double amount, String vendor, String category) {
		this.amount = amount;
		this.vendor = vendor;
		Date creation = new Date();
		date = creation.getTime();
		this.category = category;
	}
	
	public Transaction(double amount) {
		this(amount, "", "");
	}
	
	public Transaction() {
		this(0, "", "");
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
	
	public String getCategory() {
		return category;
	}
	
	public boolean setAmount(double amount) {
		this.amount = amount;
		return true;
	}
	
	public boolean setDate(long date) {
		this.date = date;
		return true;
	}
	
	public boolean setVendor(String vendor) {
		this.vendor = vendor;
		return true;
	}
	
	public boolean setCategory(String category) {
		this.category = category;
		return true;
	}
}
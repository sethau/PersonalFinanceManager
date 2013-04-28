package Domain;

public abstract class Account {
	
	private String name;
	private double balance, interest;
	private int status;
	private Transaction[] tranHist;
	public static final int OPEN = 0, CLOSED = 1;
	
	public Account() {
		
	}
}
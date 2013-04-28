package Controllers;

import java.util.ArrayList;

import Domain.Transaction;

public class TransactionController extends Controller {
	
	public TransactionController() {}
	
	public static boolean create(Object obj) {
		Transaction transaction = (Transaction) obj;
		
		return true;
	}

	public static boolean remove(String id) {
		
		
		return true;
	}

	public static Object get(String id) {
		
		
		return null;
	}
	
	public static ArrayList<Object> getAll(Object obj) {
		
		
		return null;
	}
}
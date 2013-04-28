package Controllers;

import java.util.ArrayList;

import Domain.Account;

public class AccountController extends Controller {
	
	public AccountController() {}
	
	public static boolean create(Object obj) {
		Account account = (Account) obj;
		
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

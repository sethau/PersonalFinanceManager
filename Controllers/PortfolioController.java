package Controllers;

import java.util.ArrayList;

import Domain.Portfolio;

public class PortfolioController extends Controller {
	
	public PortfolioController() {}
	
	public static boolean create(Object obj) {
		Portfolio portfolio = (Portfolio) obj;
		
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
package Controllers;

import java.util.ArrayList;

import Domain.Trade;

public class TradeController extends Controller {
	
	public TradeController() {}
	
	public static boolean create(Object obj) {
		Trade trade = (Trade) obj;
		
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
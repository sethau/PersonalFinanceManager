package Controllers;

import java.util.ArrayList;

import Domain.Profile;

public class ProfileController extends Controller {
	
	public ProfileController() {}
	
	public static boolean create(Object obj) {
		Profile profile = (Profile) obj;
		
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
	
	public static Object createForm(String id) {
		
		
		return null;
	}
	
	public static String viewAccounts(Profile profile) {
		
		
		return null;
	}
	
	public static String viewPortfolio(Profile profile) {
		
		
		return null;
	}
}
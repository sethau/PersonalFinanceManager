package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Profile;
import Domain.RepositoryAdaptor;

public class ProfileController {
	
	public ProfileController() {}
	
	public static boolean save(Profile profile) throws IOException {
		return RepositoryAdaptor.saveProfile(profile);
	}
	
	public static boolean saveEntire(Profile profile) throws IOException {
		return RepositoryAdaptor.saveEntireProfile(profile);
	}

	public static boolean remove(Profile profile) throws IOException {
		return RepositoryAdaptor.deleteProfile(profile);
	}

	public static Profile get(String username) throws FileNotFoundException {
		return RepositoryAdaptor.getProfile(username);
	}

	public static ArrayList<Profile> getAll() throws FileNotFoundException {
		return RepositoryAdaptor.getProfiles();
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
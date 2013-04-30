package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import Domain.Portfolio;
import Domain.Profile;
import Domain.RepositoryAdaptor;

public class PortfolioController {
	
	public PortfolioController() {}
	
	public static boolean save(Profile profile, Portfolio portfolio) throws FileNotFoundException {
		return RepositoryAdaptor.savePortfolio(profile, portfolio);
	}
	
	public static boolean saveEntire(Profile profile, Portfolio portfolio) throws IOException {
		return RepositoryAdaptor.saveEntirePortfolio(profile, portfolio);
	}

	public static Portfolio get(Profile profile) throws FileNotFoundException {
		return RepositoryAdaptor.getPortfolio(profile);
	}
}
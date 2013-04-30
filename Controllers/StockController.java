package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Profile;
import Domain.RepositoryAdaptor;
import Domain.Stock;

public class StockController {
	
	public StockController() {}
	
	public static boolean save(Profile profile, Stock stock) throws IOException {
		return RepositoryAdaptor.saveStock(profile, stock);
	}

	public static boolean remove(Profile profile, Stock stock) throws IOException {
		return RepositoryAdaptor.deleteStock(profile, stock);
	}

	public static Stock get(Profile profile, String company) throws FileNotFoundException {
		return RepositoryAdaptor.getStock(profile, company);
	}

	public static ArrayList<Stock> getAll(Profile profile) throws FileNotFoundException {
		return RepositoryAdaptor.getStocks(profile);
	}
}
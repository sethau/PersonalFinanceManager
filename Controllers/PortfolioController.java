package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Portfolio;
import Domain.Profile;
import Domain.RepositoryAdaptor;
import Domain.Stock;

public class PortfolioController {
	
	public static boolean save(Profile profile, Portfolio portfolio) throws FileNotFoundException {
		return RepositoryAdaptor.savePortfolio(profile, portfolio);
	}
	
	public static boolean saveEntire(Profile profile, Portfolio portfolio) throws IOException {
		return RepositoryAdaptor.saveEntirePortfolio(profile, portfolio);
	}

	public static Portfolio get(Profile profile) throws FileNotFoundException {
		return RepositoryAdaptor.getPortfolio(profile);
	}
	
	public static double getStockValue(Profile profile) throws FileNotFoundException {
		ArrayList<Stock> stocks = StockController.getAll(profile);
		double stockValue = 0;
		for (Stock stock : stocks) {
			stockValue += stock.getNumShares() * RealTimeStockQuote.price(stock.getCompany());
		}
		return stockValue;
	}
	
	public static String createForm(String menuOption, Profile, profile) {
		//View Portfolio
		//View Holdings
		//View Trade History
		//Buy
		//Sell
	}
}
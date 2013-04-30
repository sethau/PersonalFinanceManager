package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Portfolio;
import Domain.Profile;
import Domain.RepositoryAdaptor;
import Domain.Stock;
import Forms.PortfolioForm;
import Forms.TradeForm;

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
	
	public static String createForm(String menuOption, Profile profile) throws IOException {
		if (menuOption.equals("View Portfolio")) {
			return PortfolioForm.viewPortfolio(profile);
		}
		else if (menuOption.equals("View Holdings")) {
			PortfolioForm.viewHoldings(StockController.getAll(profile));
		}
		else if (menuOption.equals("View Trade History")) {
			TradeController.createForm(menuOption, profile);
			TradeForm.viewTradeHistory(TradeController.getAll(profile));
		}
		else if (menuOption.equals("Buy")) {
			TradeController.createForm(menuOption, profile);
		}
		else if (menuOption.equals("Sell")) {
			TradeController.createForm(menuOption, profile);
		}
		return "Back";
	}
}
package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Domain.Profile;
import Domain.RepositoryAdaptor;
import Domain.Trade;

public class TradeController {
	
	public TradeController() {}
	
	public static boolean save(Profile profile, Trade trade) throws IOException {
		return RepositoryAdaptor.saveTrade(profile, trade);
	}

	public static boolean remove(Profile profile, Trade trade) throws IOException {
		return RepositoryAdaptor.deleteTrade(profile, trade);
	}

	public static Trade get(Profile profile, long timestamp) throws FileNotFoundException {
		return RepositoryAdaptor.getTrade(profile, timestamp);
	}

	public static ArrayList<Trade> getAll(Profile profile) throws FileNotFoundException {
		return RepositoryAdaptor.getTrades(profile);
	}
}
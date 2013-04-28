package Controllers;

public class TradeController implements Controller {
	public boolean create(Object obj) {
		Trade trade = (Trade) obj;
		
		return true;
	}

	public boolean remove(String id) {
		return true;
	}

	public Object get(String id) {
		return null;
	}
}
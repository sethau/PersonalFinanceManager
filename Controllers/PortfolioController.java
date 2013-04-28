package Controllers;

public class PortfolioController implements Controller {
	public boolean create(Object obj) {
		Portfolio port = (Portfolio) obj;
		
		return true;
	}

	public boolean remove(String id) {
		return true;
	}

	public Object get(String id) {
		return null;
	}
}
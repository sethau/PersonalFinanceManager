package Controllers

public class TransactionController implements Controller {
	public boolean create(Object obj) {
		Transaction tran = (Transaction) obj;
		
		return true;
	}

	public boolean remove(String id) {
		return true;
	}

	public Object get(String id) {
		return null;
	}
}
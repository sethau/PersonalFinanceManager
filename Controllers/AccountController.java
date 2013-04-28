package Controllers;

public class AccountController implements Controller {
	public boolean create(Object obj) {
		Account acct = (Account) obj;
		
		return true;
	}

	public boolean remove(String id) {
		return true;
	}

	public Object get(String id) {
		return null;
	}
}

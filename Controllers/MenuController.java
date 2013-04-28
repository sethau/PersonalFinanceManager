package Controllers;

public class MenuController implements Controller {
	public boolean create(Object obj) {
		Menu menu = (Menu) obj;
		
		return true;
	}

	public boolean remove(String id) {
		return true;
	}

	public Object get(String id) {
		return null;
	}
}
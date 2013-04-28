package Controllers;

public class ProfileController implements Controller {
	public boolean create(Object obj) {
		Profile prof = (Profile) obj;
		
		return true;
	}

	public boolean remove(String id) {
		return true;
	}

	public Object get(String id) {
		return null;
	}
}
package Domain;
import java.io.FileNotFoundException;

public class Profile {
	
	String username, password;
	
	public Profile(String username, String password) throws FileNotFoundException {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
package businesslogic;

import model.User;

public abstract class Login extends User {

	
	public Login(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void newRegistration(String username, String password);
	public abstract boolean validatePass(String password);
	public abstract boolean validateUserName(String username);
	public abstract void verifyLogin();
	public abstract void verifyAdmin();
	
	
}

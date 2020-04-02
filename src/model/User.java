package model;

public class User {

	protected String username;
	protected String password;
	protected String gender;
	protected  int age;	   
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

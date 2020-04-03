package model;

public abstract class User {

	protected String email;
	protected String username;
	protected String password;
	protected String gender;
	protected  int age;	   
	protected String address;
	protected long fnumber;
	
	public User(String username, String password,String email ,String gender, int age,long fnumber, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.fnumber = fnumber;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setNumber(long fnumber) {
		this.fnumber = fnumber;
	}
	public long getNumber() {
		return fnumber;
	}
	
	public abstract void newRegistration(String username, String password,String email ,String gender, int age,long fnumber, String address);
	public abstract boolean validatePass(String password);
	public abstract boolean validateUserName(String username);
	public abstract void verifyLogin();
	public abstract void verifyAdmin();
	
}

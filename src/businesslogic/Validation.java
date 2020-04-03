package businesslogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.User;

public class Validation extends User {
	
//	private Pattern pattern;
//	private Matcher matcher;
//	private static final String passPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}";
//	private static final String namePattern = "^(.+)@(.+)$";
	
	public Validation(String username, String password,String email ,String gender, int age,long fnumber, String address) {
		super(username, password,email,gender,age,fnumber,address);
		
	}

	//// checking username and password for new registration
	public boolean checkUserDetails(String username, String password) {
		boolean name = false;
		boolean pass = false;
		if(validatePass(password)) {
			pass = true;
		}
		if(validateUserName(username)) {
			name = true;
		}
		if(name && pass) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/// validate required length of password
	public boolean validatePass(String password) {
		if(password.length() >6) {
			if(checkPass(password)) {
				return true;
			}
			else {
				System.out.println("Password must contain at least one Upper,Lower case and a Number.");
				return false;
			}
		}else {
			System.out.println("Password must have more than six charaters");
			return false;
		}
	}

	/// validate required length of username
	public boolean validateUserName(String username) {
		if(username.length() >5) {
			if(checkName(username)) {
				return true;
			}
			else {
				System.out.println("Username must contain at least one Uppercase and Lowercase character.");
				return false;
			}
		}else {
			System.out.println("Username must have more than five charaters");
			return false;
		}	
	}
	
	//// validate name 
	public boolean checkName(String  username) {
		boolean hasCap = false;
		boolean hasLow = false;
		char c;
		for(int i=0;i<username.length();i++) {
			c = username.charAt(i);
		if(Character.isUpperCase(c)) {
			hasCap = true;
		}
		else if(Character.isLowerCase(c)) {
			hasLow = true;
		}
		if(hasCap && hasLow) {
			return true;
		 	}
		}
		return false;
	}
	
	
	//// VALIDATE PASSWORD
	public boolean checkPass(String password) {
		
		boolean hasNum = false;
		boolean hasCap = false;
		boolean hasLow = false;
		char c;
		for(int i=0;i<password.length();i++) {
			c = password.charAt(i);
			if(Character.isDigit(c)) {
				hasNum = true;
			}
			else if(Character.isUpperCase(c)) {
				hasCap = true;
			}
			else if(Character.isLowerCase(c)) {
				hasLow = true;
			}
			if(hasNum && hasCap && hasLow) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void verifyLogin() {
	}

	/// NEW REGISTRATION 
	@Override
	public void newRegistration(String username, String password,String email ,String gender,int age,long fnumber, String address){		
		if(checkUserDetails(username,password)) {
			String str = ("\n"+username +","+ password+","+email+","+gender+","+age+","+fnumber+","+address);
			/// write user details in file 
			appendStrToFile(str);
			System.out.println("New user registration successful.");
			System.out.println("YOU HAVE TO SIGN IN NOW TO CONTINUE SHOPPING.");
		}
	}

	/// APPEND new registered details in file
	public  void appendStrToFile(String str) 
	{ 
		File file = new File("C:\\Users\\Prabhat/USER.csv");
			try { 
					// Open given file in append mode. 
					BufferedWriter out = new BufferedWriter( 
							new FileWriter(file, true)); 
							out.write(str); 
							out.close(); 
				} 
				catch (IOException e) { 
					System.out.println("INTERNAL ERROR  "); 
				}  
		}

	@Override
	public void verifyAdmin() {	
	} 	
}

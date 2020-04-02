package businesslogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Validation extends Login {
	
//	private Pattern pattern;
//	private Matcher matcher;
//	private static final String passPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}";
//	private static final String namePattern = "^(.+)@(.+)$";
	
	public Validation(String username, String password) {
		super(username, password);
		
	}

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newRegistration(String username, String password) {
		
		if(checkUserDetails(username,password)) {
			String str = ("\n"+username +","+ password);
			/// write user name and password in file 
			appendStrToFile(str);
			System.out.println("New user registration successful.");
			
		}
	}


	public  void appendStrToFile(String str) 
	{ 
		File file = new File("C:\\Users\\Prabhat/student.csv");
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
		// TODO Auto-generated method stub
		
	} 
	
	
	
}

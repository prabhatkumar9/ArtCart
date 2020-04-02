package businesslogic;

import java.io.File;
import java.util.Scanner;

public class VerifIcation extends Login {
	public VerifIcation(String username, String password) {
		super(username, password);
		
	}

	public void verifyLogin() {
		boolean found = false;
		String tempName = "";
		String tempPass = "";
		File file = new File("C:\\Users\\Prabhat/student.csv");
		try {
			 Scanner x = new Scanner(file);
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found){
				tempName = x.next();
				tempPass = x.next();
				if(tempName.trim().equals(username) && tempPass.trim().equals(password)) {
					found = true;
				}
			}
			x.close();
			if(found) {
				System.out.print("Successful Login: ");
			}
			if(!found) {
				System.out.println("Invalid username or password");
		}
		}
		catch( Exception e) {
			System.out.print(e.getMessage());
		}
		
	}

	@Override
	public boolean validatePass(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateUserName(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void newRegistration(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	
	public void verifyAdmin() {
		boolean found = false;
		String tempName = "";
		String tempPass = "";
		File file = new File("C:\\Users\\Prabhat/admin.csv");
		try {
			 Scanner x = new Scanner(file);
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found){
				tempName = x.next();
				tempPass = x.next();
				if(tempName.trim().equals(username) && tempPass.trim().equals(password)) {
					found = true;
				}
			}
			x.close();
			System.out.print("ADMIN PANEL LOGGED IN: ");
		}
		catch( Exception e) {
			System.out.print(e.getMessage());
		}
		finally {
			if(!found) {
					System.out.println("Invalid username or password");
			}
		}
		
	}
	
	
}

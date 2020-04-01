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
		File file = new File("‪C:\\Users\\Prabhat\\Desktop\\ProGrad.txt");
		try {
			 Scanner x = new Scanner(file);
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found) {
				tempName = x.next();
				tempPass = x.next();
				
				if(tempName.trim().equals(username) && tempPass.trim().equals(password)) {
					found = true;
				}else {
					System.out.print("Invalid username or password");
				}
			}
			x.close();
			System.out.print("Successful Login: ");
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
	
	
}

package businesslogic;

import java.io.File;
import java.util.Scanner;

import model.User;

public class VerifIcation extends User {
	public VerifIcation(String username, String password,String email ,String gender,int age,long fnumber, String address) {
		super(username, password,email,gender,age,fnumber,address);	
	}
	
	public VerifIcation(String username, String password) {
		super(username, password);
	}

	
	public VerifIcation() {
		
	}

	//// verify username and password for existing user.
	public void verifyLogin() {
		boolean found = false;
		String tempName = "";
		String tempPass = "";
		String mail = "";
		String gndr = "";
		int ag;
		String addLoc = "";
		long fnumber;
		File file = new File("C:\\Users\\Prabhat/USER.csv");
		try {
			 Scanner x = new Scanner(file);
			x.useDelimiter("[,\n]");
			while(x.hasNext()){
				tempName = x.next();
				tempPass = x.next();
				mail = x.next(); 
				gndr = x.next();
				ag = x.nextInt();
				fnumber = x.nextLong();
				addLoc = x.nextLine();
				
				if(tempName.trim().equals(username) && tempPass.trim().equals(password)) {
					found = true;	
					userDetails(tempName,tempPass,mail,gndr,ag,fnumber,addLoc);
				}
			}
			
			if(found) {
				System.out.print("Successful Login: ");
			}
			if(!found) {
				System.out.println("Invalid username or password");
		}
		x.close();
		}
		catch( Exception e) {
			System.out.print("Error hai "+e.getMessage());
		}
		
	}
	
	/// setting user's details to created object 
	public void userDetails(String tempName,String tempPass,String mail,String gndr,int ag,long fnumber,String addLoc) {
		super.setUsername(tempName);
		super.setPassword(tempPass);
		super.setEmail(mail);
		super.setGender(gndr);
		super.setAge(ag);
		super.setAddress(addLoc);
		super.setNumber(fnumber);
		
	}

	@Override
	public boolean validatePass(String password) {
		return false;
	}

	@Override
	public boolean validateUserName(String username) {
		return false;
	}

	@Override
	public void newRegistration(String username, String password,String email ,String gender,int age,long fnumber, String address) {
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

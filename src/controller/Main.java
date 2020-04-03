package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import businesslogic.Validation;
import businesslogic.VerifIcation;
import dao.Data;
import dao.Home;
import dao.Operations;
import model.User;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("********Welcome to ArtCart********");
		String password=null;
		String name = null;
		String email = null;
		String gender = null;
		int age = 0;
		String address = null;
		String pay;
		long number = 0;
		
		/// home page object
		Home home = new Home();
		
		
/////////////////////////////////////////////////////////////////////////////////////////////		
/// testing
/// painting names
String paint1 = "Mona Lisa";
String paint2 = "The Starry Night";
String paint3 = "The Liberty Leading The People";
String paint4 = "The Tower Of Babel";
String paint5 = "Pilgrimage To Cythera";
home.addName(paint1);
home.addName(paint2);
home.addName(paint3);
home.addName(paint4);
home.addName(paint5);

/// artist name 
String artist1 = "Leonardo Da Vinci";
String artist2 = "Vincent Van Gogh";
String artist3 = "Eugene Delacroix";
String artist4 = "Pieter Bruegel the Elder";
String artist5 = "Antoine Watteau";
home.addArtistName(artist1);
home.addArtistName(artist2);
home.addArtistName(artist3);
home.addArtistName(artist5);
home.addArtistName(artist4);


///// price
int price11 = 25000;
int price2 = 52500;
int price3 = 156000;
int price4 = 52000;
int price5 = 66000;
home.addPrice(price11);
home.addPrice(price2);
home.addPrice(price3);
home.addPrice(price4);
home.addPrice(price5);
//////////////////////////////////////////////////////////////////////////////////////
		
		/// item no
		int n = 0;

		/// user objectS
		User validate = new Validation(name, password,email,gender,age,number,address);
		User verifyAdmin = new VerifIcation(name, password);
		User verify = new VerifIcation(name, password);

		int conti = 0;
		
		/// initial list
		List<String> name1 = home.getName();
		List<String> artistName1 = home.getArtist();
		List<Integer> price1 = home.getPrice();
		
		/// added to cart/// CART
		ArrayList<Data> cartlist = new ArrayList<>();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//// options to select
		int choice = 0;

		/// loop for options
		String yes;
		do {
			System.out.println();
			System.out.println("******* MAIN MENU *******");
			System.out.println("1. ADMIN LOGIN");
			System.out.println("2. LOGIN IN");
			System.out.println("3. SIGN UP");
			System.out.println("4. DISPLAY USER DETAILS");
			System.out.println("5. HOME ");
			System.out.println("6. GO TO CART");
			System.out.println("*************************");
			System.out.println();
			System.out.print("ENTER YOUR CHOICE : ");
			choice =Integer.parseInt(br.readLine().trim());

		switch(choice) {
		
		case 1:
			//// admin section
			//// verify admin credentials
			System.out.println("ADMIN LOGIN");
			System.out.println("********************************************");
			System.out.println("Enter Username:");
			name = br.readLine().trim();
			System.out.println("Enter Password:");
			password = br.readLine().trim();
			System.out.println("********************************************");
			verifyAdmin.setUsername(name);
			verifyAdmin.setPassword(password);
			verifyAdmin.verifyAdmin();
			
			//// open admin panel in operation class
			Operations adm = new Operations();
			adm.admin();
			break;
		
		case 2:
			//// verify existing user 
			System.out.println("USER LOGIN");
			System.out.println("********************************************");
			System.out.println("Enter Username : ");
			name = br.readLine().trim();
			System.out.println("Enter Password : ");
			password = br.readLine().trim();
			System.out.println("********************************************");
			verify.setUsername(name);
			verify.setPassword(password);
			verify.verifyLogin();
			break;
			
		case 3:
			//// new sign up
			System.out.println("NEW SIGN UP");
			System.out.println("********************************************");
			System.out.println("Enter Username : ");
			name = br.readLine().trim();
			System.out.println("Enter Password : ");
			password = br.readLine().trim();
			System.out.println("Enter Email : ");
			email = br.readLine().trim();
			System.out.println("Enter Gender : ");
			gender = br.readLine().trim();
			System.out.println("Enter Age : ");
			age = Integer.parseInt(br.readLine().trim());
			System.out.println("Enter Mobile Number : ");
			number = Long.parseLong(br.readLine().trim());
			System.out.println("Enter Address : ");
			address = br.readLine().trim();
			System.out.println("********************************************");
			///  Registration
			validate.newRegistration(name ,password,email,gender,age,number,address);
			break;
			
		case 4:
			//// display user details
			System.out.println();
			System.out.println("USER DETAILS....");
			System.out.println("***********************************************************|");
			System.out.println("=> USER NAME     :  "+verify.getUsername());
			System.out.println("=> EMAIL ADDRESS :  "+verify.getEmail());
			System.out.println("=> MOBILE NUMBER :  "+verify.getNumber());
			System.out.println("=> PASSWORD      :  "+verify.getPassword());
			System.out.println("=> GENDER        :  "+verify.getGender());
			System.out.println("=> AGE           :  "+verify.getAge());
			System.out.println("=> ADDRESS       :  "+verify.getAddress());
			System.out.println("***********************************************************|");
			break;
			
		case 5:
			do {
				// display home page
				Home detail = new Home();
				detail.addValues(name1, artistName1, price1);
				
				try {
					/// calling add to cart method
					/// taking input as s.no.
					System.out.println();
					System.out.print("ADD TO CART : ");
					n = Integer.parseInt(br.readLine().trim());
					cartlist = home.addTocart(n,cartlist);
				}catch(Exception e) {
					System.out.println("NO ITEM SELECTED.");
				}
				System.out.println("PRESS 1 FOR CONTINUE SHOPPING.");
				System.out.println();
				System.out.println("PRESS ENTER TO GO MAIN MENU.");
				try {
					conti = Integer.parseInt(br.readLine().trim());
				}catch(Exception e) {
					
					break;
				}
			}while(conti == 1); 
			break;
			
		case 6:
			/// got to cart
			//// Display cart
					home.displayCart(cartlist);
					System.out.print("DO YOU WANT TO PLACE ORDER : YES/NO? : ");
					pay=br.readLine();
					System.out.println();
					if(pay.equals("yes")) {
						String bname = verify.getUsername();
						String badd = verify.getAddress();
						String ml = verify.getEmail();
						long fno = verify.getNumber();
						home.placeOrder(cartlist,bname,ml,badd,fno);
						System.out.println("******Order Placed Thankyou For Shopping.*****");
					}
					break;
		
		}
		System.out.println();
		System.out.print("DO YOU WANT TO CONTINUE : YES/NO? : ");
		yes=br.readLine();
		}while(yes.equals("yes"));
	
	}
}

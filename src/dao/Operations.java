package dao;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Operations {
	

///// main function
	public void admin() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;
		
		System.out.println("Welcome to ADMIN PAGE");
		System.out.println("******* Options *******");
		System.out.println("1. ADD NEW ITEMS");
		System.out.println("***********************");
		System.out.println();
		
		
		
		/// home page object
		Home home = new Home();
		
		

		
		String yes;
		do {
			try {
				System.out.println("ENTER OPTION : ");
				option = Integer.parseInt(br.readLine());
			}catch(Exception e) {
				System.out.println("Please enter a valid option.");
			}
			
			
			switch(option){
			case 1:
				try {
					//// taking number of items to add
					System.out.print("Enter Number of Items you want to add : ");
					int numberOfItemsAdd = Integer.parseInt(br.readLine().trim());
					
					/// adding item name and price with artist name in list 
					for(int i=0; i<numberOfItemsAdd;i++) {
						System.out.print("Enter Painting name : ");
						String painting = br.readLine().trim();
						home.addName(painting);
						System.out.println();
						
						System.out.print("Enter Artist name : ");
						String artist = br.readLine().trim();
						home.addArtistName(artist);
						System.out.println();
						
						System.out.print("Enter Price : ");
						int value = Integer.parseInt(br.readLine().trim());
						home.addPrice(value);
						System.out.println();
					}
					
				}catch(Exception e) {
					System.out.print("No item added.");
				}
				break;
			}
			
			System.out.println("DO YOU WANT TO CONTINUE AS ADMIN : YES/NO? : ");
			yes=br.readLine();
			}while(yes.equals("yes"));
		
		
		
		
//		/// printing each list 
//		System.out.println(getName());
//		System.out.println(getArtist());
//		System.out.println(getPrice());	
		

}
}

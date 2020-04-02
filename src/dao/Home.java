package dao;


import java.util.ArrayList;
import java.util.List;

public class Home {
	
	/// items list
	static List<String> name = new ArrayList<String>();
	static List<String> artistName = new ArrayList<String>();
	static List<Integer> price = new ArrayList<Integer>();
	
	
	/// adding items and details
	public void addName(String paintingname) {
		name.add(paintingname);	
	}
	public void addArtistName(String artist) {
		artistName.add(artist);	
	}
	public void addPrice(int value) {
		price.add(value);	
	}
	
	
	// getting each list
	public List<String> getName() {
		return name;
	}
	public List<String> getArtist() {
		return artistName;
	}
	public List<Integer> getPrice() {
		return price;
	}
	
	
	public void addValues(List<String> name,List<String> artistName, List<Integer> price) {
		
		//// length of ArrayList
		int lenOfList = name.size();
		
		//// local custom arraylist of data type 
	    //// Data having (int, String, int, long) type from the class 
		//// new arraylist for combine name, artitsname and price
		ArrayList<Data> list = new ArrayList<>();
		
		for(int i=0;i<lenOfList;i++) {
			// create an object and send values to the 
            // constructor to be saved in the Data class 
            list.add(new Data(name.get(i),artistName.get(i),price.get(i))); 
		}
		printValues(list);
	}
	
	
	public  void printValues(ArrayList<Data> list) {
		
		//// length of ArrayList
		int lenOfList = list.size();
				
		// list- the custom arraylist is sent from - previous function
		System.out.println("******************************************************************************************************************|");
		System.out.println("Add Item to Cart by selecting - S.NO.");
		System.out.println("*-----------------------------------------------------------------------------------------------------------------|");
		System.out.println("******************************************************************************************************************|");
		System.out.println();
		for (int i = 0; i < lenOfList; i++) 
        { 
            // the data received from arraylist is of Data type 
            // which is custom (String,String, int) 
            // based on class Data 
			int number = i+1;
            System.out.println("S.NO. - "+number);
            
            Data data = list.get(i); 
            // data variable of type Data has three primitive datatypes 
            // name - String 
            // artistname - String 
            // price - int 
            System.out.println("Painting Name : "+data.name+"  ||  "+"Artist Name : "+data.artname+"  ||  "+"Item Price : " +data.value+"\n");
            System.out.println("******************************************************************************************************************|");
        } 
	}
	
	
	public ArrayList<Data> addTocart(int n,ArrayList<Data> cartlist) {
		int itemNo = n-1;
		try{
			// getting item ,add to cart
			cartlist.add(new Data(name.get(itemNo),artistName.get(itemNo),price.get(itemNo)));
			//// message 
			System.out.println("ITEM No."+n+" Added in your CART.");
			System.out.println();
			return cartlist;
		}catch(Exception e) {
			System.out.println("NO ITEM SELECTED.");
			System.out.println();
			return null;
		}
	}
	
	////display cart items
	public void displayCart(ArrayList<Data> cartlist) {
		try {
			int lenOfList = cartlist.size();
			int cartTotal = 0; 
			System.out.println("ITEMS IN CART : ");
			System.out.println();
			for (int i = 0; i < lenOfList; i++) {
				Data data = cartlist.get(i);
				cartTotal = cartTotal+data.value;
				System.out.println("Painting Name : "+data.name+"\n"+"Artist Name : "+data.artname+"\n"+"Item Price : " +data.value+"\n");
			}
			System.out.println("TOTAL CART VALUE : "+cartTotal);
			System.out.println();
		}catch(Exception e) {
			System.out.println("CART IS EMPTY.");
			System.out.println();
		}
		
	}

}
	

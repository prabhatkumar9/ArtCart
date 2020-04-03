package dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
	
	
	///  itterate over data list 
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
	
	/// making new list with data object
	public  void printValues(ArrayList<Data> list) {
		//// length of ArrayList
		int lenOfList = list.size();
				
		// list- the custom arraylist is sent from - previous function
		System.out.println("******************************************************************************************************************|");
		System.out.println("**Add Item to Cart by selecting - S.NO.");
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
	
	
	//// add item to cart and display serial no of item.
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
			int n = 1;
			System.out.println();
			System.out.println("ITEMS IN CART : ");
			System.out.println();
			for (int i = 0; i < lenOfList; i++) {
				Data data = cartlist.get(i);
				cartTotal = cartTotal+data.value;
				System.out.println("**********************************************************");
				System.out.println("itemNo. : "+(i+n));
				System.out.println("ArtName     : "+data.name);
				System.out.println("ArtistName  : "+data.artname);
				System.out.println("Price       : "+data.value);
				System.out.println("**********************************************************");
			}
			/// total amount to pay
			System.out.println("TOTAL CART VALUE : "+cartTotal);
			System.out.println();
		}catch(Exception e) {
			System.out.println("CART IS EMPTY.");
			System.out.println();
		}
	}
	
	//// generate bill pdf
	public void placeOrder(ArrayList<Data> cartlist,String name, String mail, String add, long fno ) throws FileNotFoundException, DocumentException {
		////////////date for priting on bill
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();  
		String bdate = formatter.format(date);  
		Document document = new Document();
		int billno = 1;
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Prabhat\\Bill"+name+billno+".pdf"));
		document.open();
		/// attributes
				document.addAuthor("CustomerBILL");
				document.addCreationDate();
				document.addCreator("ArtCart.com");
				document.addTitle("SHOPPING BILL");
			try {
				int lenOfList = cartlist.size();
				int cartTotal = 0; 
				int n = 1;
				document.add(new Paragraph("Customer's bill copy"));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("**********************************************************"));
				document.add(new Paragraph("ITEMS : "));
				document.add(new Paragraph(" "));
				for (int i = 0; i < lenOfList; i++) {
					Data data = cartlist.get(i);
					cartTotal = cartTotal+data.value;
					document.add(new Paragraph("itemNo.  "+(i+n)));
					document.add(new Paragraph("ArtName       : "+data.name));
					document.add(new Paragraph("ArtistName   : "+data.artname));
					document.add(new Paragraph("Price           : "+data.value));
					document.add(new Paragraph(" "));
				}
				document.add(new Paragraph("**********************************************************"));
				/// total amount to pay
				document.add(new Paragraph(" "));
				document.add(new Paragraph("PAID AMOUNT          :       "+cartTotal));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("CUSTOMER NAME     : "+name));
				document.add(new Paragraph("EMAIL Address           : "+mail));
				document.add(new Paragraph("Mobile Number           : "+fno));
				document.add(new Paragraph("SHIPPING ADDRESS : "+add));
				document.add(new Paragraph("***********************************************************"));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("DATE               : "+bdate));
			}catch(Exception e) {
				System.out.println(e);
			}finally{
				billno++;
				document.close();
				writer.close();
			}
			
	}
		
}
	

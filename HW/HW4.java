import java.util.Scanner;
import java.text.DecimalFormat;

public class HW4 {
	public static void main(String args[]) {
		//Create booklist
		BookList booklist=new BookList();
		//Get user input using scanner
		Scanner sc=new Scanner(System.in);

		System.out.println("Welcome to the book program!");
		String choice="";
		boolean errorFlag=false;
		//Loop until user quits
		while(true) {
			if(!errorFlag) {
				System.out.print("Would you like to create a book object? (yes/no): ");
				choice=sc.nextLine();
			}
			//If choice is yes
			if(choice.equalsIgnoreCase("yes")) {
				errorFlag=false;
				System.out.print("Please enter the author, title and the isbn of the book separated by /:");
				String input=sc.nextLine();
				String inputArr[]=input.split("/");
				String author=inputArr[0].toUpperCase();
				String title=inputArr[1].toUpperCase();
				String isbn=inputArr[2];
				System.out.println("Got it!");
				System.out.print("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book or LB for library book):");
				String bookStorreOrLibrary=sc.nextLine();
				while(!(bookStorreOrLibrary.equalsIgnoreCase("lb") || bookStorreOrLibrary.equalsIgnoreCase("bb"))) {
					System.out.print("Oops! That’s not a valid entry. Please try again:");
					bookStorreOrLibrary=sc.nextLine();
				}
				System.out.println("Got it!");
				if(bookStorreOrLibrary.equalsIgnoreCase("bb"))
				{
					System.out.print("Please enter the list price of "+title+" by "+author+": ");
					double price=sc.nextDouble();
					sc.nextLine();
					System.out.print("Is it on sale? (y/n):");
					String onSale=sc.nextLine();
					boolean onSaleFlag=false;
					if(onSale.equalsIgnoreCase("y")) {
						System.out.println("Deduction percentage: 15%");
						System.out.println("Got it!");
						onSaleFlag=true;
					}
					System.out.println("\nHere is your bookstore book information");
					BookstoreBook book=new BookstoreBook(author, title, isbn, price, onSaleFlag);
					System.out.println(book);
					booklist.addBook(book);
				}
				else
				{
					LibraryBook book=new LibraryBook(author, title, isbn);
					System.out.println("\nHere is your library book information");
					System.out.println(book);
					booklist.addBook(book);
				}


			}
			else if(choice.equalsIgnoreCase("no"))
			{
				errorFlag=false;
				System.out.println("Sure!");
				System.out.println("Here are all your books...");
				booklist.printBooks();
				System.out.println("Take care now!");
				break;
			}
			else
			{
				errorFlag=true;
				System.out.print("I’m sorry but "+choice+" isn’t a valid answer. Please enter either yes or no:");
				choice=sc.nextLine();
			}
		}
		sc.close();

	}
}

class BookList {
	private Book[] list;
	private int INDEX=0;
	
	public BookList() {
		list = new Book[100];
		
	}
	
	public void addBook(Book b) {
		if (INDEX<list.length)
		{
			list[INDEX]=b;
			INDEX++;
		}
	}
	
	public void printBooks() {
		int libCount=0,bbCount=0;
		for(int i=0;i<INDEX;i++)
		{
			Book b=list[i];
			if(b instanceof LibraryBook)
				libCount++;
			else
				bbCount++;
		}
		System.out.println("Library Books ("+libCount+")");
		for(Book b: list)
		{
			if(b instanceof LibraryBook) {
				LibraryBook book=(LibraryBook) b;
				System.out.println(book);
			}
		}
		System.out.println("------");
		System.out.println("Bookstore Books ("+bbCount+")");
		for(Book b: list)
		{
			if(b instanceof BookstoreBook) {
				BookstoreBook book=(BookstoreBook) b;
				System.out.println(book);
			}
		}
		System.out.println("------");
	}
	
	
}

public class LibraryBook extends Book {

	private String callNumber;

	public LibraryBook() {
		this.callNumber="";
	}
	
	/**
	 * @param title
	 */
	public LibraryBook(String title) {
		super("", title, "");
		this.callNumber="";
	}
	
	/**
	 * @param author
	 * @param title
	 * @param isbn
	 */
	public LibraryBook(String author, String title, String isbn) {
		super(author, title, isbn);
		// xx.yyy.c
		int floor=(int) ((Math.random() * (99)) + 1);
		this.callNumber=floor+"."+getAuthor().substring(0,3)+"."+isbn.substring(isbn.length()-1);
	}

	/**
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * @param callNumber the callNumber to set
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	@Override
	public String toString() {
		return super.toString()+"-"+callNumber+"]";
	}

	
	
	
}

public class BookstoreBook extends Book {

	private double price;
	private boolean onSale;
	
	public BookstoreBook() {
		this.price=0;
		this.onSale=false;
	}
	public BookstoreBook(String title) {
		super("", title, "");
		this.price = 0;
		this.onSale = false;
	}
	/**
	 * @param author
	 * @param title
	 * @param isbn
	 * @param price
	 * @param onSale
	 */
	public BookstoreBook(String author, String title, String isbn, double price, boolean onSale) {
		super(author, title, isbn);
		this.price = price;
		this.onSale = onSale;

	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the onSale
	 */
	public boolean isOnSale() {
		return onSale;
	}
	/**
	 * @param onSale the onSale to set
	 */
	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}
	
	@Override
	public String toString() {
		//[458792132-JAVA MADE EASY by ERICKA JONES, $14.99 listed for $12.74]
		DecimalFormat df=new DecimalFormat("00.00");
		return super.toString()+", $"+df.format(price)+" listed for $"+df.format((price-(0.15*price)))+"]";
	}
	
}


public abstract class Book {

	private String author;
	private String title;
	private String isbn;
	
	public Book() {
		this.author="";
		this.title="";
		this.isbn="";
	}
	
	/**
	 * @param title
	 */
	public Book(String title) {
		this.author="";
		this.title=title;
		this.isbn="";
	}
	
	/**
	 * @param author
	 * @param title
	 * @param isbn
	 */
	public Book(String author, String title, String isbn) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		//[458792132-JAVA MADE EASY by ERICKA JONES, $14.99 listed for $12.74]

		return "["+ isbn+"-"+title+" by "+author;
	}
	
	
	
}
import java.util.Scanner;
import java.text.DecimalFormat;

public class HW5 {
	public static void main(String args[]) {
        //booklist
		BookList booklist=new BookList();
		Scanner sc=new Scanner(System.in);

        //at bookstore we welcome our customers not greet
		System.out.println("Welcome to the book program!");

        //vars
		String YorN="";
		boolean errorChk=false;

		//gameloop
		while(true) {
			if(!errorChk) {
				System.out.print("Would you like to create a book object? (yes/no): ");
				YorN=sc.nextLine();

			}
			//If yes
			if(YorN.equalsIgnoreCase("yes")) {
				errorChk=false;
                //enter things
				System.out.print("Please enter the author, title and the isbn of the book separated by /:");

                //inputs
				String input=sc.nextLine();
				String inputArr[]=input.split("/");
				String author=inputArr[0].toUpperCase();
				String title=inputArr[1].toUpperCase();
				String isbn=inputArr[2];

                //BB or LB
				System.out.println("Got it!");
				System.out.print("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book or LB for library book):");

				String BorL=sc.nextLine();

                //are you dumb try again
				while(!(BorL.equalsIgnoreCase("lb") || BorL.equalsIgnoreCase("bb"))) 
                {
					System.out.print("Oops! That’s not a valid entry. Please try again:");
					BorL=sc.nextLine();
				}

                //Finally
				System.out.println("Got it!");

                //enter info
				if(BorL.equalsIgnoreCase("bb"))
				{
					System.out.print("Please enter the list price of "+title+" by "+author+": ");
					double price=sc.nextDouble();
					sc.nextLine();
					System.out.print("Is it on sale? (y/n):");
					String sale=sc.nextLine();
					boolean saleChk=false;
					if(sale.equalsIgnoreCase("y")) 
                    {
						System.out.println("Deduction percentage: 15%");
						System.out.println("Got it!");
						saleChk=true;
					}
					System.out.println("\nHere is your bookstore book information");
					BookstoreBook book=new BookstoreBook(author, title, isbn, price, saleChk);
					System.out.println(book);
					booklist.addBook(book);
				}
                //output info
				else
				{
					LibraryBook book=new LibraryBook(author, title, isbn);
					System.out.println("\nHere is your library book information");
					System.out.println(book);
					booklist.addBook(book);
				}


			}
            //output all info
			else if(YorN.equalsIgnoreCase("no"))
			{
				errorChk=false;
				System.out.println("Sure!");
				System.out.println("Here are all your books...");
				booklist.printBooks();
				System.out.println("Take care now!");
				break;
			}
            //no valid YorN dummy
			else
			{
				errorChk=true;
				System.out.print("I’m sorry but "+YorN+" isn’t a valid answer. Please enter either yes or no:");
				YorN=sc.nextLine();
			}
		}
		sc.close();

	}
}

//Do BookList=============================================================================================================================================================================
class BookList {
	private Book[] list;
	private int INDEX=0;
	
    //new list
	public BookList() {
		list = new Book[100];
	}
	
    //add book
	public void addBook(Book b) {
		if (INDEX<list.length)
		{
			list[INDEX]=b;
			INDEX++;
		}
	}
	
    // print books
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

//Lb========================================================================================================================================================================
class LibraryBook extends Book {

	private String callNum;

    //set callNum (Cool)
	public LibraryBook() {
		this.callNum="";
	}
    //set callNum and more (Cooler)
	public LibraryBook(String title) {
		super("", title, "");
		this.callNum="";
	}
    //set callNum with more info (Coolest)
	public LibraryBook(String author, String title, String isbn) {
		super(author, title, isbn);
		int floor=(int ) ((Math.random() * (99)) + 1);
		this.callNum=floor+"."+getAuthor().substring(0,3)+"."+ isbn.substring(isbn.length()-1);
	}
    //GET CALLNUM
	public String getCallNumber() {
		return callNum;
	}
    //SET CALLNUM
	public void setCallNumber(String callNum) {
		this.callNum = callNum;
	}

	@Override
    //return Call Num
	public String toString() {
		return super.toString()+"-"+callNum+"]";
	}

}

//BB===========================================================================================================================================================================================================
public class BookstoreBook extends Book {
    //Init Vars
	private double price;
	private boolean sale;
	
    //set price
	public BookstoreBook() {
		this.price=0;
		this.sale=false;
	}
    //set price and title (fancy)
	public BookstoreBook(String title) {
		super("", title, "");
		this.price = 0;
		this.sale = false;
	}
    //set price and has everything (fancier)
	public BookstoreBook(String author, String title, String isbn, double price, boolean sale) {
		super(author, title, isbn);
		this.price = price;
		this.sale = sale;

	}
    //return price
	public double getPrice() {
		return price;
	}
    //set price
	public void setPrice(double price) {
		this.price = price;
	}
    //return sale
	public boolean isOnSale() {
		return sale;
	}
    //set sale
	public void setOnSale(boolean sale) {
		this.sale = sale;
	}
	
	@Override
    //Return Price
	public String toString() {
		DecimalFormat df=new DecimalFormat("00.00");
		return super.toString()+", $"+df.format(price)+" listed for $"+df.format((price-(0.15*price)))+"]";
	}
	
}

//Book===================================================================================================================================================================================================
public abstract class Book {

	private String author;
	private String title;
	private String isbn;
	
    //set info
	public Book() {
		this.author="";
		this.title="";
		this.isbn="";
	}
	//set info
	public Book(String title) {
		this.author="";
		this.title=title;
		this.isbn="";
	}
	//set info
	public Book(String author, String title, String isbn) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}

    //return author
	public String getAuthor() {
		return author;
	}
    //set Author
	public void setAuthor(String author) {
		this.author = author;
	}
    //return title
	public String getTitle() {
		return title;
	}
    //set Title
	public void setTitle(String title) {
		this.title = title;
	}
    //return isbn
	public String getIsbn() {
		return isbn;
	}
    //set isbn
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
    //Return All things
	public String toString() {
		return "["+ isbn+"-"+title+" by "+author;
	}
}
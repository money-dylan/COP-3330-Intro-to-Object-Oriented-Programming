import java.util.Scanner;

public class HW2{
	public static void main(String[] args) {
        //declare things
	    Scanner myObj = new Scanner(System.in);
	    double money;
	    int hundreds = 0;
        int fif = 0;
        int twen = 0;
	    int tens = 0; 
        int fives = 0;
        int ones = 0;
	    int quar = 0; 
        int dimes = 0; 
        int nick = 0; 
        int cents = 0;
	    
        //take user input
		System.out.print("Enter your dollar amount: ");
		money = myObj.nextDouble();
		
        //calculate things
		hundreds = (int)money / 100;
		money -= hundreds * 100;
		fif = (int)money / 50;
		money -= fif * 50;
		twen = (int)money / 20;
		money -= twen * 20;
		tens = (int)money / 10; 
		money -= tens * 10;
		fives = (int)money / 5; 
		money -= fives * 5;
		ones = (int)money / 1; 
		money -= ones * 1;
		cents = (int)(money * 100);
		quar = cents / 25; 
		cents = cents % 25;
		dimes = cents / 10; 
		cents = cents % 10;
		nick = cents / 5; 
		cents = cents % 5;

        //output stuff
		System.out.println("You have:");
        System.out.println("- "+hundreds+" hundred(s)");
        System.out.println("- "+fif+" fifty(s)");
        System.out.println("- "+twen+" twenty(s)");
        System.out.println("- "+tens+" ten(s)");
        System.out.println("- "+fives+" five(s)");
        System.out.println("- "+ones+" one(s)");
        System.out.println("- "+quar+" quarter(s)");
        System.out.println("- "+dimes+" dime(s)");
        System.out.println("- "+nick+" nickel(s)");
        System.out.println("- "+cents+" cent(s)");
	}
}
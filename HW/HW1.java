import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) throws Exception {

        //declare new Scanner
        Scanner myObj = new Scanner(System.in);

        //take inputs
        System.out.println("Enter the Employee's full name: ");
        String name = myObj.nextLine();

        System.out.println("Enter the Employee's number: ");
        String num = myObj.nextLine();

        System.out.println("Enter the pay rate per hour: ");
        double rate = myObj.nextDouble();

        System.out.println("Enter the regular hours worked: ");
        double hours = myObj.nextDouble();

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("----------------------------------------\n");

        System.out.println("\n");
        
        //output stuff
        System.out.println("Employee's name: "+ name + "\n");
        System.out.println("Employee's number: "+ num + "\n");
        System.out.println("Hourly rate of pay: "+ rate + "\n");
        System.out.println("Hours worked: "+ hours + "\n");

        System.out.println("\n");
        
        //math
        double gTotal = hours * rate;

        //output stuff
        System.out.println("Total Gross Pay: " + gTotal + "\n");

        System.out.println("\n");
        
        //math
        double tax = gTotal * 0.06;

        //output stuff
        System.out.println("Deductions\n");
        System.out.println("Tax(6%): " + tax + "\n");

        System.out.println("\n");
        
        //math
        gTotal -= tax;

        //output stuff
        System.out.println("Net Pay: " + gTotal + "Dollars\n");
        System.out.println("----------------------------------------\n");
    }
}

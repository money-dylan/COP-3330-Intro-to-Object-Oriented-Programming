import java.util.Scanner;  

public class HW4 {
	//HW4
	//Dylan Money
    public static void main(String[] args) {
		//given
        String fullName="Erika T. Jones";
        String employeeNumber="ej789";
        double payRate=100.0,hoursWorked=1.0;
        
    	//TA will change the payrate and the hours worked to test your code 
   
        Employee e;  
 		e = new Employee (fullName,employeeNumber,payRate,hoursWorked); 
   
   		System.out.println(e); //To Test your toString method 
   
   		e.printCheck(); //This prints the check of Erika T. Jones 
   
   		System.out.println("Bye!"); 
    }
}
    class Employee
    {
        //declare vars
        private String fullName;
        private String employeeNumber;
        private double payRate;
        private double hoursWorked;
        final double TAX=0.06;
        
        public Employee(String fullName, String employeeNumber, double payRate, double hoursWorked) 
		{
			//Employee info
            this.fullName = fullName;
            this.employeeNumber = employeeNumber;
            this.payRate = payRate;
            this.hoursWorked = hoursWorked;
        }

        //getter
        public String getFullName() 
		{
            return fullName;
        }
		//setter
        public void setFullName(String fullName) 
		{
            this.fullName = fullName;
        }
		//getter
        public String getEmployeeNumber() 
		{
            return employeeNumber;
        }
		//setter
        public void setEmployeeNumber(String employeeNumber) 
		{
            this.employeeNumber = employeeNumber;
        }
		//getter
        public double getPayRate() 
		{
            return payRate;
        }
		//setter
        public void setPayRate(double payRate) 
		{
            this.payRate = payRate;
        }
		//getter
        public double getHoursWorked() 
		{
            return hoursWorked;
        }
		//setter
        public void setHoursWorked(double hoursWorked) 
		{
            this.hoursWorked = hoursWorked;
        }
		//calc pay
        public double netPay()
        {
            double totalPay=hoursWorked*payRate;
            
            double netPay=totalPay-(totalPay*TAX);
            return netPay;
        }
        //print function
        public void printCheck()
        {
             //output the stuff
            System.out.println("Employee's Name:"+fullName);
            System.out.println("Employee's Number:"+employeeNumber);
            System.out.println( "Hourly Rate Of pay:"+payRate);
            System.out.println("Hours worked:"+hoursWorked);
            System.out.println("");
            System.out.println( "Total Gross Pay:"+(payRate*hoursWorked));
            System.out.println("Deduciton");
            System.out.println( "Tax(6%):"+(payRate*hoursWorked)*TAX);
            System.out.println("Net Pay:"+netPay());
        }
        
    }
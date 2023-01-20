/* 
- Project 1 
- Dylan Money
*/ 

import java.util.ArrayList;
import java.util.Scanner;
 
public class Project1 
{ 
	public static void main(String[] args)
	{  
		System.out.println("\t\t\t\t\t\t\tWelcome to my Personal Management Program");
        Scanner sc = new Scanner(System.in);
        Personnel personList = new Personnel();

        boolean game = true;
        int ch;
        //game loop
        do
        {
            System.out.println("Choose one of the options:");
            System.out.println("1- Enter the information a faculty");
            System.out.println("2-  Enter the information of a student");
            System.out.println("3- Print tuition invoice for a student");
            System.out.println("4- Print faculty information");
            System.out.println("5- Enter the information of a staff member");
            System.out.println("6-  Print the information of a staff member ");
            System.out.println("7- Exit Program");

            System.out.println("\tEnter your selection: ");
            ch = sc.nextInt();
            //choices matter
            switch(ch)
            {
                default:
                    System.out.println("\n");
                    System.out.println("Invalid entry- please try again ");
                    System.out.println("\n");
                    break;
                //faculty in
                case 1:
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("Enter faculty info:\n");
                    String fullname=sc.nextLine();
                    System.out.print("\t\tName of faculty:");
                    fullname=sc.nextLine();
                    System.out.print("\t\tID:");
                    String ID=sc.nextLine();
                    String rank;
                    do{
                        System.out.print("\t\tRank:");
                        rank = sc.nextLine();
                        if(rank.equalsIgnoreCase("professor") || rank.equalsIgnoreCase("adjunct"))
                        {
                            break;
                        }
                        else{
                            System.out.println("\"" + rank + "\"" + "is invaild");
                        }
                    }while(true);
                    String department;
                    do{
                        System.out.print("\t\tDepartment:");
                        department = sc.nextLine();
                        if(department.equalsIgnoreCase("mathematics") || department.equalsIgnoreCase("engineering") || department.equalsIgnoreCase("sciences"))
                        {
                            break;
                        }
                        else{
                            System.out.println("\"" + department + "\"" + "is invaild");
                        }
                    }while(true);
                    personList.addFaculty(fullname, ID, rank, department);
                    System.out.print("Faculty added!\n");
                    break;
                //student in
                case 2:
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("Enter student info:\n");
                    fullname=sc.nextLine();
                    System.out.print("\t\tName of Student:");
                    fullname=sc.nextLine();
                    System.out.print("\t\tID:");
                    ID=sc.nextLine();
                    System.out.print("\t\tGPA:");
                    double GPA = sc.nextDouble();
                    System.out.print("\t\tCredit hours:");
                    double creditHours = sc.nextDouble();
                    personList.addStudent(fullname, ID, GPA, creditHours);
                    System.out.print("Student added!\n");
                    break;
                //student out
                case 3:
                    System.out.print("Enter the student's ID:");
                    ID=sc.nextLine();
                    ID=sc.nextLine();

                    personList.sendInvoice(ID);

                    break;
                //faculty out
                case 4:
                    System.out.print("Enter the faculty ID:");
                    ID=sc.nextLine();
                    ID=sc.nextLine();

                    personList.printInfo(ID);
                    break;
                //staff in
                case 5:
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("Enter staff info:\n");
                    fullname=sc.nextLine();
                    System.out.print("\t\tName of staff:");
                    fullname=sc.nextLine();
                    System.out.print("\t\tID:");
                    ID=sc.nextLine();
                    String status;
                    do{
                        System.out.print("\t\tRank:");
                        status = sc.nextLine();
                        if(status.equalsIgnoreCase("p") )
                        {
                            status = "Part Time";
                            break;
                        }
                        else if(status.equalsIgnoreCase("f"))
                        {
                            status = "Full Time";
                            break;
                        }
                        else{
                            System.out.println("\"" + status + "\"" + "is invaild");
                        }
                    }while(true);

                    do{
                        System.out.print("\t\tDepartment:");
                        department = sc.nextLine();
                        if(department.equalsIgnoreCase("mathematics") || department.equalsIgnoreCase("engineering") || department.equalsIgnoreCase("sciences"))
                        {
                            break;
                        }
                        else{
                            System.out.println("\"" + department + "\"" + "is invaild");
                        }
                    }while(true);
                    personList.addStaff(fullname, ID, status, department);
                    System.out.print("Staff added!\n");
                    break;
                //staff out
                case 6:
                System.out.print("Enter the staff ID:");
                ID=sc.nextLine();
                ID=sc.nextLine();

                personList.printInfo(ID);
                    break;

                //kill
                case 7:
                    System.out.println("\n");
                    System.out.println("\n");
                    System.out.println("Goodbye!");

                    return;
                    

            }
        }while(game == true);

	} 
} 
    //----------------------------------------------------------------------------------------------- 


    //----------------------------------------------------------------------------------------------- 
	   	class Faculty extends Person
	   	{
            private String department;
            private String rank;
            
            public Faculty(){
            }
            //
            public Faculty(String fullname, String ID, String rank, String department){
                super(fullname, ID);
                this.department = department;
                this.rank = rank;
            }
            //get
            public double getDepartment() {
                return department;
            }
            //set
            public void setDepartment(String department) {
                this.department = department;
            }
            //get
            public double getRank() {
                return rank;
            }
            //set
            public void setRank(String rank) {
                this.rank = rank;
            }
            //print stuff
            @Override
            public void printInfo()
            {
                System.out.println("----------------------------------------------------------------------");
                System.out.println(super.toString.getFullname());
                System.out.println(department + " Department, " + rank);
                System.out.println("----------------------------------------------------------------------");
            }
           
	   	} 
	
    //----------------------------------------------------------------------------------------------- 
    class Student extends Person
	   	{
            private double GPA;
            private double creditHours;

            public Student() {
            }

            public Student(String fullname, String ID, double GPA, double creditHours) {
                super(fullname, ID);
                this.GPA = GPA;
                this.creditHours = creditHours;
            }
            //get
            public double getGPA() {
                return GPA;
            }
            //set
            public void setGPA(double GPA) {
                this.GPA = GPA;
            }
            //get
            public double getCreditHours() {
                return creditHours;
            }
            //set
            public void setCreditHours(double creditHours) {
                this.creditHours = creditHours;
            }
            //print more stuff
            @Override
            public void sendInvoice(){
                double total = 0.0;
                double discount = 0;
                if(GPA >= 3.85)
                {
                    discount = (((creditHours * 236.45) + 52) * 0.25);
                    total = ((creditHours * 236.45) + 52) - (((creditHours * 236.45) + 52) * 0.25);
                }
                else
                {
                    total = ((creditHours * 236.45) + 52);
                }
                System.out.println("---------------------------------------------------------------------------");
                System.out.println(super.print());
                System.out.println("Credit Hours: " + creditHours + "($236.45/credit hour)");
                System.out.println("Fees: $52\n\n");
                System.out.println("Total Payment: $" + total + "\t\t\t\t\t\t($" + discount + " discount applied)");
                System.out.println("---------------------------------------------------------------------------");
            }

	   	} 
    //-----------------------------------------------------------------------------------------------
   	   	class Staff extends Person
   		{ 
            private String department;
            private String status;
            
            public Staff(){
            }

            public Staff(String fullname, String ID, String status, String department){
                super(fullname, ID);
                this.department = department;
                this.status = status;
            }
            //get
            public double getDepartment() {
                return departmentq;
            }
            //set
            public void setDepartment(String department) {
                this.department = department;
            }
            //get
            public double getStatus() {
                return rank;
            }
            //set
            public void setStatus(String status) {
                this.status = status;
            }

            @Override
            public void printInfo()
            {
                System.out.println("----------------------------------------------------------------------");
                System.out.println(super.toString.getFullname());
                System.out.println(department + " Department, " + status);
                System.out.println("----------------------------------------------------------------------");
            }
   		} 
    //-----------------------------------------------------------------------------------------------
    abstract class Person {

        private String fullname;
        private String ID;
        
 
        public Person() {
        }

        public Person(String fullname, String ID) {
            super();
            this.fullname = fullname;
            this.ID= ID;
        }
        //get
        public String getFullname() 
        {
            return fullname;
        }
        //set
        public void setFullname(String fullname) 
        {
            this.fullname = fullname;
        }
        //get
        public String getID() 
        {
            return ID;
        }
        //set
        public void setID(String ID) {
            this.ID = ID;
        }
        //print even more stuff
        public int print() {
            System.out.println(fullname + "\t\t" + ID);
            return 0;
        }
    }
    //-----------------------------------------------------------------------------------------------
    class Personnel {
        private Person[] list;
        private int INDEX=0;
        final int SIZE = 100;
        
        //new list
        public Personnel() {
            list = new Person[SIZE];
            for ( int i = 0; i<SIZE; i++) {
                list[i] = null;
            }
        }
        
        //add person
        public void addPerson(Person b) {
            if (INDEX<list.length)
            {
                list[INDEX]=b;
                INDEX++;
            }
        }
        //add student
        public boolean addStudent(String fullname, String ID, double GPA, double creditHours)
        {
            int index = search ( ID );
		    if ( index != -1 ) return false;
		
		    for ( index = 0; index < SIZE; index ++)
			    if ( list[index]  == null ) {
				    list[index] = new Student (fullname , ID, GPA, creditHours);
				    return true;
			    }
		
		
		    return false;
        }
        //faculty
        public boolean addFaculty(String fullname, String ID, String rank, String department)
        {
            int index = search ( ID );
		    if ( index != -1 ) return false;
		
		    for ( index = 0; index < SIZE; index ++)
			    if ( list[index]  == null ) {
				    list[index] = new Faculty (fullname , ID, rank, department);
				    return true;
			    }
		
		
		    return false;
        }
        //staff
        public boolean addStaff(String fullname, String ID, String status, String department)
        {
            int index = search ( ID );
		    if ( index != -1 ) return false;
		
		    for ( index = 0; index < SIZE; index ++)
			    if ( list[index]  == null ) {
				    list[index] = new Staff (fullname , ID, status, department);
				    return true;
			    }
		
		
		    return false;
        }

        //you may find
        public int search(String ID)
        {
            for ( int i = 0; i<SIZE; i++) {
                if ( list[i]!=null && ID.equalsIgnoreCase(list[i].getID()))
                    return i;
            }
            return -1; 
            
        }
        //give me money
        public void sendInvoice(String ID)
        {
            int index = search ( ID );
            if ( index == -1 ) {
                System.out.println("Sorry " +  ID +" isn't found as id");
                return;
            }
                
            list[index].sendInvoice();
        }
        //print way more stuff
        public void printInfo(String ID)
        {
            int index = search ( ID );
            if ( index == -1 ) {
                System.out.println("Sorry " +  ID +" isn't found as id");
                return;
            }
                
            list[index].printInfo();
        }
        
    }
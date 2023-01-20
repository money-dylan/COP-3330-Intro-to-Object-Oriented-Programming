/* 
- Project 1 
- Dylan Money
*/ 

//import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;  
import java.io.IOException; 
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.*;
import java.text.DecimalFormat;
 
public class Project2
{ 
	 public static void main(String[] args)
	{  
		System.out.println("\t\t\t\t\t\t\tWelcome to my Personal Management Program");
        Scanner sc = new Scanner(System.in);
        Personnel personList = new Personnel();

        boolean game = true;
        int ch;
        int facNum = 1;
        double staffNum = 1;
        boolean studAdded = false;
        //game loop
        while(game == true)
        {
            try
            {
                System.out.println("Choose one of the options:");
                System.out.println("1- Enter the information a faculty");
                System.out.println("2- Enter the information of a student");
                System.out.println("3- Print tuition invoice for a student");
                System.out.println("4- Print faculty information");
                System.out.println("5- Enter the information of a staff member");
                System.out.println("6- Print the information of a staff member ");
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
                        String ID = "";
                        Boolean IdChecker = true;
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("Enter faculty info:\n");
                        String fullname=sc.nextLine();
                        System.out.print("\t\tName of faculty:");
                        while((fullname = sc.nextLine()).isEmpty()) {
                            System.out.println("\t\tPlease Enter Name");
                            System.out.print("\t\tName of faculty:");
                        }
                        while (IdChecker == true)
                        {
                            try
                            {
                                System.out.print("\t\tID:");
                                while((ID = sc.nextLine()).isEmpty()) 
                                {
                                    throw new IdException("\t\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
                                }
                                ID = sc.nextLine();
                                personList.checkID(ID);
                                break;
                            }
                            catch (IdException e) {
                                System.out.println(e.getMessage());
                                System.out.print("\t\tID:");
                                sc.next();
                            }
                        }
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
                        personList.addFaculty(fullname, ID, rank, department,facNum);
                        System.out.print("Faculty added!\n");
                        facNum++;
                        break;
                    //student in
                    case 2:
                        ID = "";
                        IdChecker = true;
                        double creditHours = 0;
                        double GPA = 0;
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("Enter student info:\n");
                        fullname=sc.nextLine();
                        System.out.print("\t\tName of Student:");
                        while((fullname = sc.nextLine()).isEmpty()) {
                            System.out.println("\t\tPlease Enter Name");
                            System.out.print("\t\tName of Student:");
                        }
                        while (IdChecker == true)
                        {
                            System.out.print("\t\tID:");
                            try
                            {
                                while((ID = sc.nextLine()).isEmpty()) 
                                {
                                    throw new IdException("\t\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
                                }
                                personList.checkID(ID);
                                break;
                            }
                            catch (IdException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        boolean dumb = true;
                        while(dumb == true)
                        {
                            try{
                                System.out.print("\t\tGPA:");
                                GPA = sc.nextDouble();
                                dumb = false;
                            }catch(Exception e)
                            {
                                System.out.println("WARNING: GPA should be a number");
                                sc.next();
                            }
                        }
                        dumb = true;
                        while(dumb == true)
                        {
                            try{
                                System.out.print("\t\tCredit hours:");
                                creditHours = sc.nextDouble();
                                dumb = false;
                            }catch(Exception e)
                            {
                                System.out.println("WARNING: Credit hours should be a number");
                                sc.next();
                            }
                        }
                        personList.addStudent(fullname, ID, GPA, creditHours);
                        System.out.print("Student added!\n");
                        studAdded = true;
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
                        ID = "";
                        IdChecker = true;
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("Enter staff info:\n");
                        fullname=sc.nextLine();
                        System.out.print("\t\tName of staff:");
                        while((fullname = sc.nextLine()).isEmpty()) {
                            System.out.println("\t\tPlease Enter Name");
                            System.out.print("\t\tID:");
                        }
                        while (IdChecker == true)
                        {
                            System.out.print("\t\tID:");
                            try
                            {
                                while((ID = sc.nextLine()).isEmpty()) 
                                {
                                    throw new IdException("\t\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
                                }
                                personList.checkID(ID);
                                break;
                            }
                            catch (IdException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        String status;
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

                        do{
                            System.out.print("\t\tStatus, Enter P for Part Time, or Enter F for Full Time:");
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

                        personList.addStaff(fullname, ID, status, department, staffNum);
                        staffNum++;
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
                        Boolean report = true;
                        boolean sort = true;
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("Would you like to create the report? (Y/N):");
                        String reportYN = sc.nextLine();
                        while(report == true)
                        {
                            reportYN = sc.nextLine();
                            if(reportYN.equalsIgnoreCase("y") )
                            {
                                break;
                            }
                            else if(reportYN.equalsIgnoreCase("n"))
                            {
                                System.out.println("Have a Wonderful Day");
                                report = false;
                            }
                            else
                            {
                                System.out.println("\"" + reportYN + "\"" + "is invaild");
                            }
                        }
                        while(sort == true && report == true)
                        {
                            System.out.println("Would you like to sort your students by (1) gpa or (2) credit hours: ");
                            String sortGorC = sc.nextLine();
                            if(sortGorC.equalsIgnoreCase("1"))
                            {
                                sort = false;
                            }
                            else if(sortGorC.equalsIgnoreCase("2"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("\"" + sortGorC + "\"" + "is invaild");
                            }
                        }
                        if(report == true)
                        {
                            try {
                                FileWriter myWriter = new FileWriter("report.txt");
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                                Date date = new Date();   
                                myWriter.write("\t\tReport created on " +formatter.format(date) + " \n\t\t*********************** ");
                                myWriter.write("\n");
                                myWriter.write("\n");
                                myWriter.write("Faculty Members \n-------------------------\n");
                                myWriter.close();
                                for(int u = 1; u < facNum; u++)
                                {
                                    myWriter = new FileWriter("report.txt", true);
                                    myWriter.append("\t" + u + ".");
                                    myWriter.close();
                                    personList.writeInfo(u);
                                }
                                myWriter = new FileWriter("report.txt", true);
                                myWriter.append("\n");
                                myWriter.append("\n");
                                myWriter.append("Staff Members \n-------------------------\n");
                                myWriter.close();
                                for(double u = 1; u < staffNum; u++)
                                {
                                    myWriter = new FileWriter("report.txt", true);
                                    int uI = (int)u;
                                    myWriter.append("\t" + uI + ".");
                                    myWriter.close();
                                    personList.writeInfo(u);
                                }
                                myWriter = new FileWriter("report.txt", true);
                                myWriter.append("\n");
                                myWriter.append("\n");
                                if(sort == true)
                                {
                                    myWriter.append("Students Members(sorted by Credit hours) \n-------------------------\n");
                                    myWriter.close();
                                    if(studAdded == true)
                                    {
                                        personList.doSortCH();
                                        personList.writeInfo(studAdded);
                                    }
                                }
                                else
                                {
                                    myWriter.append("Students Members(sorted by GPA) \n-------------------------\n");
                                    myWriter.close();
                                    if(studAdded == true)
                                    {
                                        personList.doSortGPA();
                                        personList.writeInfo(studAdded);
                                    }
                                }
                                myWriter.close();
                                System.out.println("Report created and saved on your hard drive! ");
                            } 
                            catch (IOException e) 
                            {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        }
                            System.out.println("\n");
                            System.out.println("\n");
                            System.out.println("Goodbye!");
                            game = false;

                            return;
                            
                    }
            }catch(Exception e)
            {
                System.out.println("Warning: Invalid Command");
                sc.next();
            }
            
        }
        sc.close();
                       
    }
} 

    //----------------------------------------------------------------------------------------------- 
	   	class Faculty extends Employee
	   	{
            private String department;
            private String rank;
            
            
            public Faculty(){
            }
            //
            public Faculty(String fullname, String ID, String rank, String department, int facNum){
                super(fullname, ID, facNum);
                department = department.substring(0,1).toUpperCase() + department.substring(1).toLowerCase();
                this.department = department;
                rank = rank.substring(0,1).toUpperCase() + rank.substring(1).toLowerCase();
                this.rank = rank;
            }
            //get
            public String getDepartment() {
                return department;
            }
            //set
            public void setDepartment(String department) {
                this.department = department;
            }
            //get
            public String getRank() {
                return rank;
            }
            //set
            public void setRank(String rank) {
                this.rank = rank;
            }

            //print stuff
            public void printInfo()
            {
                System.out.println("----------------------------------------------------------------------");
                System.out.println(super.getFullname());
                System.out.println(department + " Department, " + rank);
                System.out.println("----------------------------------------------------------------------");
            }

            @Override
            public void writeInfo()
            {
                try {
                    FileWriter myWriter = new FileWriter("report.txt", true);
                    myWriter.append(super.getFullname());
                    myWriter.append("\n\tID: " + super.getID());
                    myWriter.append("\n\t" + rank + "," + department + "\n\n");
                    myWriter.close();
                  } 
                  catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }

            }
           
	   	} 
	
    //----------------------------------------------------------------------------------------------- 
    class Student extends Person
	   	{
            public double GPA;
            public double creditHours;
            private static final DecimalFormat df = new DecimalFormat("0.00");

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
                System.out.println("Total Payment: $" + df.format(total) + "\t\t\t\t\t\t($" + discount + " discount applied)");
                System.out.println("---------------------------------------------------------------------------");
            }
            @Override
            public void writeInfo()
            {
                try {
                    FileWriter myWriter = new FileWriter("report.txt", true);
                    myWriter.append(super.getFullname());
                    myWriter.append("\n\tID: " + super.getID());
                    myWriter.append("\n\tGpa: " + GPA);
                    myWriter.append("\n\tCredit Hours: " + creditHours);
                    myWriter.append("\n");
                    myWriter.close();
                  } 
                  catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }

            }

	   	} 
    //-----------------------------------------------------------------------------------------------
   	   	class Staff extends Employee
   		{ 
            private String department;
            private String status;
            
            public Staff(){
            }

            public Staff(String fullname, String ID, String status, String department, double staffNum){
                super(fullname, ID, staffNum);
                department = department.substring(0,1).toUpperCase() + department.substring(1).toLowerCase();
                this.department = department;
                status = status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase();
                this.status = status;
            }
            //get
            public String getDepartment() {
                return department;
            }
            //set
            public void setDepartment(String department) {
                this.department = department;
            }
            //get
            public String getStatus() {
                return status;
            }
            //set
            public void setStatus(String status) {
                this.status = status;
            }

            public void printInfo()
            {
                System.out.println("----------------------------------------------------------------------");
                System.out.println(super.getFullname());
                System.out.println(department + " Department, " + status);
                System.out.println("----------------------------------------------------------------------");
            }

            @Override
            public void writeInfo()
            {
                try {
                    FileWriter myWriter = new FileWriter("report.txt", true);
                    myWriter.append(super.getFullname());
                    myWriter.append("\n\tID: " + super.getID());
                    myWriter.append("\n\t" + department + "," + status + "\n\n");
                    myWriter.close();
                  } 
                  catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }

            }
   		} 
    //-----------------------------------------------------------------------------------------------
    abstract class Person {

        private String fullname;
        private String ID;
        private int facNum;
        private double staffNum;
        
 
        public Person() {
        }
        
        public Person(String fullname, String ID) {
            super();
            this.fullname = fullname;
            this.ID= ID;
        }
        public Person(String fullname, String ID, int facNum) {
            super();
            this.fullname = fullname;
            this.ID= ID;
            this.facNum = facNum;
        }
        public Person(String fullname, String ID, double staffNum) {
            super();
            this.fullname = fullname;
            this.ID= ID;
            this.staffNum= staffNum;
        }
        //get
        public String getFullname() 
        {
            String words[]= fullname.split("\\s");  
            String capitalizeWord="";  
            for(String w:words){  
                String first=w.substring(0,1);  
                String afterfirst=w.substring(1);  
                capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
            }  
            return capitalizeWord.trim();
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
        public int getFacNum() 
        {
            return facNum;
        }  
        public void setFacNum(int facNum) 
        {
            this.facNum = facNum;
        }  
        public double getStaffNum() 
        {
            return staffNum;
        }  
        public void setFtaffNum(double staffNum) 
        {
            this.staffNum = staffNum;
        }  
        //print even more stuff
        public int print() {
            System.out.println(fullname + "\t\t" + ID);
            return 0;
        }

        public void sendInvoice() {
        }

        public void printInfo() {
        }

        public void writeInfo() {
        }

    }
    //-----------------------------------------------------------------------------------------------
    class Personnel {
        private Person[] list;
        private Student[] studList;
        private int INDEX=0;
        final int SIZE = 100;
        List<Student> stud = new ArrayList<>();
        
        //new list
        public Personnel() {
            list = new Person[SIZE];
            for ( int i = 0; i<SIZE; i++) {
                list[i] = null;
            }
            studList = new Student[SIZE];
            for ( int i = 0; i<SIZE; i++) {
                studList[i] = null;
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
                    studList[index] =new Student (fullname , ID, GPA, creditHours);
                    stud.add(studList[index]);
                    return true;
			    }
		
		    return false;
        }
        //faculty
        public boolean addFaculty(String fullname, String ID, String rank, String department, int facNum)
        {
            int index = search ( ID );
		    if ( index != -1 ) return false;
		
		    for ( index = 0; index < SIZE; index ++)
			    if ( list[index]  == null ) {
				    list[index] = new Faculty (fullname , ID, rank, department, facNum);
				    return true;
			    }
		
		
		    return false;
        }
        //staff
        public boolean addStaff(String fullname, String ID, String status, String department, double staffNum)
        {
            int index = search ( ID );
		    if ( index != -1 ) return false;
		
		    for ( index = 0; index < SIZE; index ++)
			    if ( list[index]  == null ) {
				    list[index] = new Staff (fullname , ID, status, department, staffNum);
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

        public int search(int facNum)
        {
            for ( int i = 0; i<SIZE; i++) {
                if ( list[i]!=null && facNum == (list[i].getFacNum()))
                    return i;
            }
            return -1; 
            
        }
        
        public void writeInfo(int facNum)
        {
            int index = search ( facNum );
            if ( index == -1 ) {
                System.out.println("Error could not find Employee");
                return;
            }
                
            list[index].writeInfo();
        }
        public void writeInfo(double staffNum)
        {
            int index = search ( staffNum );
            if ( index == -1 ) {
                System.out.println("Error could not find Employee");
                return;
            }
                
            list[index].writeInfo();
        }
        public int search(double staffNum)
        {
            for ( int i = 0; i<SIZE; i++) {
                if ( list[i]!=null && staffNum == (list[i].getStaffNum()))
                    return i;
            }
            return -1; 
            
        }

        public void checkID(String ID) throws IdException
        {
            int len = ID.length();
            for (int i = 0; i < len; i++)
            {
                if(i <= 1 && !Character.isLetter(ID.charAt(i)) || i > 1 && !Character.isDigit(ID.charAt(i))|| len > 6 || len <= 5)
                {
                    throw new IdException("\t\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
                }
                else if(search(ID) != -1)
                {
                    throw new IdException("\t\tInvalid ID. This ID already exists");
                }
            }
        }
        public void doSortCH()
            {
                Collections.sort(stud, new SortbyCH());
            }

        public void writeInfo(boolean studAdded)
            {
                for(int i = 0; i < studList.length; i++)
                {
                    if(studList[i] != null)
                    {
                        try
                        {
                            FileWriter myWriter = new FileWriter("report.txt", true);
                            myWriter.append("\t" + (i+1) + ".");
                            myWriter.close();
                            stud.get(i).writeInfo();
                        }
                        catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                          
                    }
                    else
                    {
                        break;
                    }
                }
  
            }
            public void doSortGPA()
            {
                Collections.sort(stud, new SortbyGPA());
            }
    }

  //-----------------------------------------------------------------------------------------------

    class Employee extends Person
    {
        public Employee() {
        }

        public Employee(String fullname, String ID) {
            super(fullname, ID);
        }
        public Employee(String fullname, String ID, int facNum) {
            super(fullname, ID, facNum);
        }
        public Employee(String fullname, String ID, double staffNum) {
            super(fullname, ID, staffNum);
        }
        //print even more stuff

        public void sendInvoice() {
        }

        public void printInfo() {
        }
    }
  //-----------------------------------------------------------------------------------------------
    class IdException extends Exception
    {
        public IdException(String s)
        {
            super(s);
        }
    }
    //-----------------------------------------------------------------------------------------------
    class SortbyCH implements Comparator<Student> {
 
        // Method
        
        public int compare(Student a, Student b)
        {
            return (int)b.creditHours - (int)a.creditHours;
        }
    }
    //-----------------------------------------------------------------------------------------------
    class SortbyGPA implements Comparator<Student> {
 
        // Method
        
        public int compare(Student a, Student b)
        {
            return (int)b.GPA - (int)a.GPA;
        }
    }
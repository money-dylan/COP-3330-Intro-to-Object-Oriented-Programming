import java.util.Scanner;  

public class HW3{
	public static void main(String[] args) {
	    //declare stuff;
	    Scanner myObj = new Scanner(System.in);
	    show_report();
	    String ch = "Y";
		//exit conditon/repeat game loop
	    while(true) 
		{
	        System.out.println("\nWould you like to process another class? (Y or N):n (Here assume that the user enters either y,Y,n or N)");
	        ch = myObj.nextLine();

	        if(ch == "Y" || ch == "y") 
			{
	            show_report();
	        } 
			else 
			{
	            break;
	        }
	    }
	}

    public static void show_report() {
		//declare stuff
        int Score = 0;
		int num = 0; 
		float total = 0;
        int S_70 = 0;
        int grade_A = 0;
		int grade_B = 0;
		int grade_C = 0; 
		int grade_D = 0;
		int grade_F = 0;
        Scanner myObj = new Scanner(System.in);

        //game loop
        while(true) 
		{
			//exit condition
            System.out.print("Enter Score (Enter -1 to Stop): ");
            Score = myObj.nextInt();
            if(Score == -1) 
			{
                break;
            }
			//calc scores
            if(Score > 100) 
			{
                System.out.println("Score " + Score + " Rejected");
            } 
			else 
			{
                // make updations
                if(Score >= 70) 
				{
                    S_70++;
                }
                if(Score >= 90) {
                    grade_A++;
                } 
				else if(Score >= 80) 
				{
                    grade_B++;
                } 
				else if(Score >= 70) 
				{
                    grade_C++;
                } 
				else if(Score >= 60) 
				{
                    grade_D++;
                } 
				else 
				{
                    grade_F++;
                }
				//math
                total += Score; 
                num++;
            }
        }
		//output stuff
        System.out.println("\n\n\nHere is your report:");
        System.out.println("- A total of "+ num + " scores entered. " + S_70 + " of them are 70 or higher.\n");
        
        System.out.println("- Letter Grade distribution of the scores:");
        System.out.println("- " +  grade_A + " Students earned the grade of A (90-100)");
        System.out.println("- " +  grade_B + " Students earned the grade of B (80-89)");
        System.out.println("- " +  grade_C + " Students earned the grade of C (70-79)");
        System.out.println("- " +  grade_D + " Students earned the grade of D (60-69)");
        System.out.println("- " +  grade_F + " Students earned the grade of 7 (59 or below)\n");
        
        System.out.println("- " + "The average score is: " +  (1.0 * total)/num);

    }
}
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HW7 {
//========================================================================================================================================================================
    public static void main(String[] args) {
        //input user stuff
        Scanner in = new Scanner(System.in);

            ArrayList<Lecture> lectures = readLectures("lec.txt");
       
        int online = 0;
        for (Lecture lec : lectures) 
        {
            if (lec.isOnline()) 
            {
                online++;
            }
        }


        System.out.printf("There are %d online lectures offered.\n", online);

        System.out.print("Enter Room Number: ");
        String room = in.nextLine();

        //check for lec and lab
        for (Lecture lec : lectures) 
        {
            if (!lec.isOnline()) 
            {
                if (lec.getRoomNumber().equalsIgnoreCase(room)) 
                {
                    System.out.println(lec.getCRN());
                }

                if (lec.hasLabs()) 
                {
                    ArrayList<Lab> lab = lec.getLabs();
                    for (Lab labs : lab) 
                    {
                        if (labs.getRoomNumber().equalsIgnoreCase(room)) 
                        {
                            System.out.println(labs.getCRN());
                        }
                    }
                }
            }
        }
        in.close();

        //this is the output file
        String outputName = "lecturesOnly.txt";
        try 
        {
            PrintWriter writer = new PrintWriter(outputName);

            writer.write("Online Lectures\n");
            for (Lecture lec : lectures) 
            {
                if (lec.isOnline()) 
                {
                    writer.write(lec.toString() + "\n");
                }
            }

            writer.write("\n\nLectures With No Labs\n");
            for (Lecture lec : lectures) 
            {
                if (!lec.isOnline() && !lec.hasLabs()) 
                {
                    writer.write(lec.toString() + "\n");
                }
            }
            writer.close();
            System.out.printf("%s is created.\n", outputName);
        } 
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        }
    }
//========================================================================================================================================================================
    public static ArrayList<Lecture> readLectures(String fileName) {
        ArrayList<Lecture> lectures = new ArrayList<Lecture>();

        File inputFile = new File(fileName);
        boolean readLabs = false;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] fields = line.trim().split(",");

                if (readLabs) 
                {
                    if (fields.length != 2) 
                    {
                        readLabs = false;
                    } 
                    else 
                    {
                        int crn = Integer.parseInt(fields[0].trim());
                        String room = fields[1].trim();
                        lectures.get(lectures.size() - 1).addLab(crn, room);
                        continue;
                    }
                }

                int crn = Integer.parseInt(fields[0].trim());
                String prefix = fields[1].trim();
                String title = fields[2].trim();
                String type = fields[3].trim();

                if (fields[4].trim().equalsIgnoreCase("ONLINE")) 
                {
                    // Create A New Online Lecture
                    lectures.add(new Lecture(crn, prefix, title, type));
                } 
                else 
                {
                    String code = fields[4].trim();
                    String room = fields[5].trim();
                    boolean hasLabs = false;

                    // check if labs
                    if (fields[6].trim().equalsIgnoreCase("YES")) 
                    {
                        hasLabs = true;
                        readLabs = true;
                    }
                    lectures.add(new Lecture(crn, prefix, title, type, code, room, hasLabs));
                }
            }
        } 
        catch (IOException | IndexOutOfBoundsException ex) 
        {
            ex.printStackTrace();
        }

        return lectures;
    }

}
//========================================================================================================================================================================
class Lab {
    private int crn;
    private String room;

    // Constructor
    public Lab(int crn, String room) {
        this.crn = crn;
        this.room = room;
    }

    // get crn 
    public int getCRN() {
        return crn;
    }
    //get room
    public String getRoomNumber() {
        return room;
    }
}
//========================================================================================================================================================================

class Lecture {
    //stuff
    private int crn;
    private String prefix;
    private String title;
    private String type;
    private String code;
    private String room;
    private boolean isOnline;
    private boolean hasLabs;
    private ArrayList<Lab> lab;

    // constructor
    public Lecture(int crn, String prefix, String title, String type) {
        this(crn, prefix, title, type, null, null, false);
        this.isOnline = true;
    }

    public Lecture(int crn, String prefix, String title, String type, String code, String room,
            boolean hasLabs) {
        this.crn = crn;
        this.prefix = prefix;
        this.title = title;
        this.type = type;
        this.code = code;
        this.room = room;
        this.hasLabs = hasLabs;
        // If Lecture Has Labs
        if (this.hasLabs) 
        {
            lab = new ArrayList<Lab>();
        }
    }

    // Add A Lab
    public void addLab(int crn, String room) {
        lab.add(new Lab(crn, room));
    }

    //get online
    public boolean isOnline() {
        return isOnline;
    }

    //get lab
    public boolean hasLabs() {
        return hasLabs;
    }
    //get room
    public String getRoomNumber() {
        return room;
    }
    //get lab
    public ArrayList<Lab> getLabs() {
        return lab;
    }
    //get crn
    public int getCRN() {
        return crn;
    }

    // To String
    @Override
    public String toString() {
        if (isOnline()) 
        {
            return String.format("%d, %s, %s, %s, Online",
                    crn, prefix, title, type);
        } 
        else 
        {
            return String.format("%d, %s, %s, %s, %s, %s, %s",
                    crn, prefix, title, type, code, room, hasLabs() ? "Yes" : "No");
        }
    }
}

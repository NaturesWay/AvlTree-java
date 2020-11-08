package TobyMyers_FSU;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordUtils {

    public static AVLTree tree = new AVLTree();
    public static Record record = new Record();
    public static List<String> test = new ArrayList();


    public static void readRecords() throws FileNotFoundException {

        int idNumber = 0;
        String fName = "";
        String lName = "";
        String age = "";
        String line = "";

        Scanner inFile = new Scanner(new FileReader("test.txt"));

        inFile.nextLine();
        inFile.nextLine();
        inFile.nextLine();
        inFile.nextLine();
        inFile.nextLine();


        while (inFile.hasNext()) {

            idNumber = inFile.nextInt();
            record.setIdNumber(idNumber);

            fName = inFile.next();
            record.setfName(fName);

            lName = inFile.next();
            record.setlName(lName);

            if (inFile.hasNext())
            age = inFile.next();
            else
                age = "";
            record.setAge(age);

            tree.insert(record);
            System.out.println(record);
        }

        inFile.close();
    }



    public static void go() throws FileNotFoundException {
        readRecords();

        Commands.commands();


    }

}

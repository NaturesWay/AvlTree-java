package TobyMyers_FSU;

import java.util.Scanner;

public class Commands{


    public static String findLName = "";
    public static String findFName = "";

    public static void commandList() {
        System.out.println("\nThe Amazo Name Storage Program Shadow Magic" +
                " 2000 Command Operations\n");
        System.out.println("Enter 1 to search by last name\n.");
        System.out.println("Enter 2 to search by first and last name.\n");
        System.out.println("Enter 3 to add a record to The Amazo Name" +
                "Name Storage Program Shadow Magic 2000.\n");
        System.out.println("Enter 4 to total count of all records in the system.\n");
        System.out.println("Enter 5 for a list of available commands.\n");
        System.out.println("Enter 6 to see who created this code.\n");
        System.out.println("Enter 7 to exit the records system.\n");
    }


    public static void commands() {

//        commandList();

        Scanner console = new Scanner(System.in);
        Record record = new Record();
        int choice = console.nextInt();
        int idNumber;
        String age;
        int count = 0;
        String lName = "";
        String fName = "";


        switch (choice) {
            case 1: //Allows user to search for record by last name.
                System.out.println("Enter the last name to search for.\n");
                findLName = console.next();
//                AVLTree.findLastName(record);
                commands();
                break;

            case 2: //Allows user to search for record by first and last name.
                System.out.println("Enter the first and last name to search for.\n");
                findFName = console.next();
                findLName = console.next();

                commands();
                break;

            case 3: //Allows user to add a new record.
                System.out.println("Enter the id number, first name, last name, and age" +
                        "of the record to be added.\n");
                idNumber = console.nextInt();
                record.setIdNumber(idNumber);

                fName = console.next();
                record.setfName(fName);

                lName = console.next();
                record.setlName(lName);

                age = console.next();
                record.setAge(age);

                RecordUtils.tree.insert(record);
                System.out.println("Record #" + idNumber + " has been added.\n\n\n");
                RecordUtils.tree.printTree(AVLTree.root);

                commands();
                break;

            case 4: //Prints out the total number of records in the AVL tree.
                System.out.println("There are " + RecordUtils.tree.countNodes() + " records in The Amazo Name " +
                        "Storage Program Shadow Magic 2000 System\n\n\n");

                commands();
                break;

            case 5: //Prints out the user command list.
                commandList();
                commands();
                break;

            case 6: //Prints out the author of the code.
                System.out.println("This code was created by Toby Myers.\n\n\n");
                commands();
                break;

            case 7: //Allows the user to exit the program.
                System.out.println("Exiting The Amazo Name Storage Program " +
                        "Shadow Magic 2000 System.");
                System.exit(0);
                break;
            default: //Notifies user if invalid input is entered.
                System.out.println("Invalid Input");
                commands();
        }


    }

}
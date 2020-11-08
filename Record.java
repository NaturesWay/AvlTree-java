package TobyMyers_FSU;

import java.util.Scanner;

public class Record {


    int idNumber;
    String fName;
    String lName;
    String age;

    //Record constructor
    public Record() {
        this.idNumber = idNumber;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "ID Number = " + idNumber +
                ", First Name = " + fName +
                ", Last Name = " + lName +
                ", Age = " + age;
    }

//    public int getIdNumber() {
//        return idNumber;
//    }
//
//    public String getfName() {
//        return fName;
//    }
//
//    public String getlName() {
//        return lName;
//    }
//
//    public String getAge() {
//        return age;
//    }


    //Sets record fields.
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAge(String age) {
        this.age = age;
    }


}

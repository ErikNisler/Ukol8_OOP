package com.company;

import com.company.interfaces.IFormat1;
import com.company.interfaces.IMyFormat;

/**Dědičnost*/
public class Student extends Teacher implements IFormat1, IMyFormat {
    private static int id = 0;
    private int sequence;

    private int year;
    private String studentId;

    public Student(String firstName, String lastName, int year, String studentId) {
        super(firstName, lastName);
        this.sequence = ++id;
        this.year = year;
        this.studentId = studentId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String format1(){
        return "# "+sequence+" # "+getStudentId()+" - "+getFirstName()+" "+getLastName() + " ("+getYear()+")";
    }

    public String format2(){
        return getStudentId()+", "+getFirstName()+" "+getLastName();
    }

    @Override
    public String myFormat(){
        return getStudentId()+" - "+getLastName()+", "+getFirstName();
    }

}

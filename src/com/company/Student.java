package com.company;

import com.company.interfaces.IPrintOut;

/**Dědičnost*/
public class Student extends Teacher implements IPrintOut {
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
    public void printOut1(){
        System.out.println("# "+sequence+" # "+getStudentId()+" "+getFirstName()+" "+getLastName()+" ("+getYear()+")");
    }

    @Override
    public void printOut2(){
        System.out.println(getStudentId()+", "+getFirstName()+" "+getLastName());
    }

    @Override
    public void myPrintOut(){
        System.out.println(sequence +" - "+getFirstName()+" "+getLastName());
    }

}

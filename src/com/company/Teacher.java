package com.company;

import com.company.interfaces.IPrintOut;

public class Teacher implements IPrintOut {
    private String firstName;
    private String lastName;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void printOut1(){
        System.out.println("Třídní učitel: "+getLastName()+", "+getFirstName());
    }

    @Override
    public void printOut2(){
        System.out.println(getFirstName()+" "+getLastName());
    }

    @Override
    public String myPrintOut(){
        return "Třídní učitel "+getLastName();
    }
}

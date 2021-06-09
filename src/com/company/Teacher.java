package com.company;

import com.company.interfaces.IFormat1;

public class Teacher implements IFormat1 {
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
    public String format1(){
        return "Třídní učitel: "+getLastName()+", "+getFirstName();
    }

}

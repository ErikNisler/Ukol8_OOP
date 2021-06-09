package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Classroom implements IFormat1, IFormat2, IGetAll, IMyFormat {

    private String name;
    private int yOfStudy;
    private Teacher teacher;
    private ArrayList<Student> listOfStudents = new ArrayList<>();

    public Classroom(String name, int yOfStudy, Teacher teacher) {
        this.name = name;
        this.yOfStudy = yOfStudy;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getyOfStudy() {
        return yOfStudy;
    }

    public void setyOfStudy(int yOfStudy) {
        this.yOfStudy = yOfStudy;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void addStudent(Student student){
        listOfStudents.add(student);
    }

    @Override
    public void getAll1(){
        for (int i = 0; i < listOfStudents.size(); i++) {
            Student s = listOfStudents.get(i);
            System.out.println(s.format1());
        }
    }

    @Override
    public void getAll2(){
        for (int i = 0; i < listOfStudents.size(); i++) {
            Student s = listOfStudents.get(i);
            System.out.println(s.format2());
        }
    }

    @Override
    public void getAll_myFormat(){
        for (int i = 0; i < listOfStudents.size(); i++) {
            Student s = listOfStudents.get(i);
            System.out.println(s.myFormat());
        }
    }

    public void getAll_myFormat(String file){
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("file")))) {
            writer.println(myFormat());
            for (int i = 0; i < listOfStudents.size(); i++) {
                Student s = listOfStudents.get(i);
            writer.println(s.myFormat());
        }
        } catch (IOException e) {
            System.err.println("Chyba při zápisu souboru");
        }
    }


    public String sizeOfList(){
        return "Počet studentů: "+listOfStudents.size();
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    @Override
    public String format1(){
        return "Třída: "+getName()+" (ročník: "+getyOfStudy()+")";
    }

    @Override
    public String format2(){
        return getName()+", "+getTeacher().getFirstName()+" "+getTeacher().getLastName();
    }

    @Override
    public String myFormat(){
        return "Počet studentů ve třídě "+getName()+": "+sizeOfList()+", třídní učitel: "+getTeacher().getFirstName()+" "+getTeacher().getLastName();

    }

}

package com.company;

import com.company.interfaces.IPrintOut;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Classroom implements IPrintOut {


    private static String SEPARATOR = "#################################";
    private static String FILE = "my_format.txt";

    private String name;
    private int yOfStudy;
    private Teacher teacher;
    private ArrayList<Student> listOfStudents = new ArrayList<>();
    private ArrayList<String> studenti = new ArrayList<>();

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


    public int sizeOfList(){
        return listOfStudents.size();
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    @Override
    public void printOut1(){
        System.out.println(SEPARATOR);
        System.out.println("Třída: "+getName()+" (ročník: "+getyOfStudy()+")");
        getTeacher().printOut1();
        System.out.println("Počet studentů: "+listOfStudents.size());
        System.out.println(SEPARATOR);
        for (int i = 0; i < listOfStudents.size(); i++) {
            Student s = listOfStudents.get(i);
            s.printOut1();
        }
    }

    @Override
    public void printOut2(){

        System.out.print(getName()+" ");
        getTeacher().printOut2();
        for (int i = 0; i < listOfStudents.size(); i++) {
            Student s = listOfStudents.get(i);
            s.printOut2();
        }
    }

    @Override
    public String myPrintOut(){
        for (int i = 0; i < listOfStudents.size(); i++) {
            Student s = listOfStudents.get(i);
            studenti.add(s.myPrintOut());
        }
        return getTeacher().myPrintOut()+"\n"+
                "Třída: "+getName()+"\n"+
                studenti;
    }

    public void write(){
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("file")))) {
                writer.println(myPrintOut());
        } catch (
                IOException e) {
            System.err.println("Chyba při zápisu souboru");
        }
    }

    public static void main(String[] args){
        Teacher teacher1 = new Teacher("Jan","Novák");
        Classroom class1 = new Classroom("4.C",4,teacher1);

        class1.addStudent(new Student("Aleš","Zahálka",2001,"S01"));
        class1.addStudent(new Student("Milan","Petrklíč",2000,"S02"));
        class1.addStudent(new Student("Petr","Pavel",2000,"S03"));

        class1.printOut1();
        System.out.println();
        class1.printOut2();
        System.out.println();
        System.out.println(class1.myPrintOut());
        class1.write();

    }
}

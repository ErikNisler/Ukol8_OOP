package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ClientInfoStatus;

public class Main {

    private static String SEPARATOR = "#################################";

    public static void main(String[] args) {

        Teacher teacher1 = new Teacher("Jan","Novák");
        Classroom class1 = new Classroom("4.C",4,teacher1);

        /**studentList.addStudent(new Student("Aleš","Zahálka",2001,"S01"));
        studentList.addStudent(new Student("Milan","Petrklíč",2000,"S02"));
        studentList.addStudent(new Student("Petr","Pavel",2000,"S03"));*/

        class1.addStudent(new Student("Aleš","Zahálka",2001,"S01"));
        class1.addStudent(new Student("Milan","Petrklíč",2000,"S02"));
        class1.addStudent(new Student("Petr","Pavel",2000,"S03"));


        /**První formát:*/
        System.out.println(SEPARATOR);
        System.out.println("První formát:");
        System.out.println(class1.format1());
        System.out.println(teacher1.format1());
        System.out.println(class1.sizeOfList());

        System.out.println();

        System.out.println(SEPARATOR);
        class1.getAll1();

        System.out.println(SEPARATOR);
        /**Druhý formát:*/
        System.out.println("Druhý formát:");
        System.out.println(class1.format2());
        class1.getAll2();
        System.out.println(SEPARATOR);

        /**Navhněte vlastní formát a zapište data do souboru*
        Počet studentů ve třídě 4.C: 3, třídní učitel: Jan Novák
         S01 - Zahálka, Aleš*/
        System.out.println("Vlastní formát:");

        System.out.println(class1.myFormat());
        class1.getAll_myFormat();

        class1.getAll_myFormat("file");

    }

}

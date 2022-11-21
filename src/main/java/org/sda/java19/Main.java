package org.sda.java19;

import org.sda.java19.model.JavaDeveloper;
import org.sda.java19.model.Person;

public class Main {
    public static void main(String[] args) {

        // EXERCISE 1

        JavaDeveloper javaDeveloper = new JavaDeveloper("Kristel", 26, false, "kristeltalimaa@gmail.com", "Postimees", 3);
        System.out.println("Person name is " + javaDeveloper.getName() + " and she works in " + javaDeveloper.getCompany());

        // Using an object of type JavaDeveloper call a method that is defined in Developer.
        System.out.println(javaDeveloper.getEmail());



    }
}
package org.sda.java19;

import org.sda.java19.model.JavaDeveloper;
import org.sda.java19.model.Person;

public class Main {
    public static void main(String[] args) {

        // EXERCISE 1

        JavaDeveloper javaDeveloper = new JavaDeveloper("Kristel", 26, false, "kristeltalimaa@gmail.com", "Postimees", 3);
        System.out.println("Person name is " + javaDeveloper.getName() + " and she works in " + javaDeveloper.getCompany());

        // solution 2
        javaDeveloper.setName("Kristel");
        javaDeveloper.setAge(26);
        javaDeveloper.setMale(false);
        javaDeveloper.setEmail("kristeltalimaa@gmail.com");
        javaDeveloper.setCompany("Postimees");
        javaDeveloper.setWorkExperience(3);

        // c.
        System.out.println(javaDeveloper);

        // Using an object of type JavaDeveloper call a method that is defined in Developer.
        // Access modifier can be public or protected
        // d.
        System.out.println(javaDeveloper.getEmail());

        // e.
        javaDeveloper.setName("Martin ", "Põlluste");
        System.out.println(javaDeveloper.getName());
    }
}
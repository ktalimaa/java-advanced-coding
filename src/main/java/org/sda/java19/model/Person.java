package org.sda.java19.model;

/**
 * Exercise 1:
 *
 * Create 3 classes: Person, Developer, JavaDeveloper.
 * a. Person is a parent class, Developer inherits from Person, JavaDeveloper inherits from
 * Developer
 * b. Create constructor for every class that will call constructor of the super class. Each
 * constructor should display an information, that it has been called.
 * c. Create an object of type JavaDeveloper. What information will be displayed and in
 * what order?
 * d. Using an object of type JavaDeveloper call a method that is defined in Developer
 * class. What access modifier should it have?
 * e. *Overload method from the Person class in JavaDeveloper class to accept additional
 * parameters.
 *
 * @author Kristel Talimaa
 */


// better use lombok: allargsconstructor, getter, setter, tostring, noargsconstructor
public class Person {

    private String name;

    private int age;


    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
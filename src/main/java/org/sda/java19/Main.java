package org.sda.java19;

import org.sda.java19.exceptions.MaximumNumberOfStudentsReached;
import org.sda.java19.models.Group;
import org.sda.java19.models.Student;
import org.sda.java19.models.Trainer;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * SDA Scheduler
 * <p>
 * Create a class hierarchy:
 * Person.java - firstname  (inheritance)
 * - lastname
 * - dateOfBirth
 * Trainer.java (extends Person) - isAuthorized (boolean)
 * Student.java (extends Person) - hasPreviousJavaKnowledge (boolean)
 * <p>
 * <p>
 * Create a Group class which has
 * <p>
 * name (Java19Remote, Java20Remote, etc)
 * one trainer
 * a list of students
 * <p>
 * <p>
 * Manually initialize 15 students; 4 groups and 3 trainers;
 * Store all students in a list; all groups in a list; all trainers in a list;
 * Assign a trainer to each group
 * Assign 2-3 students to each group
 * <p>
 * Ensure the fact that a group will only have distinct students (How would you do that?) (each group has only unique students)
 * Ensure the fact that a group will only have a maximum of 5 students; When you try to add a 6th one throw an MaximumNumberOfStudentsReached exception
 * Display all students in a group sorted alphabetically by lastName // for all display ex use streams
 * Display the group with the maximum number of students
 * Display all students younger than 25, from all groups
 * Display all students grouped by trainer that teaches to them (eg. Trainer1 - stud1, stud3, stud4; Trainer2 - stud2, stud 10) - regardless of the group they're part of (If you were to store this information in a data structure what would you use?)
 * Display all students with previous java knowledge
 * Display the group with the highest number of students with no previous java knowledge
 * Remove all the students younger than 20 from all groups and then display the groups before and after
 *
 * @author Kristel Talimaa
 */

/*

sort, filter, map, peek if using streams

 */
public class Main {
    public static void main(String[] args) {

        List<Student> studentList = getInitialStudents();
        List<Trainer> trainerList = getInitialTrainers();
        List<Group> groupList = getInitialGroups();

        assignStudentsToGroup(groupList);

        List<Student> studentsInGroup = getInitialStudents();
        Collections.shuffle(studentList);
        studentsInGroup.stream()
                .collect(Collectors.groupingBy(Student:: toString))
                .values()
                .stream()
                .map(x -> x.stream().map(Objects::toString)).collect(Collectors.toList())
                .forEach(System.out::println);

        if(studentsInGroup.size() <= 5) {
            assignStudentsToGroup(groupList);
        }
        System.out.println(groupList);


        /*

        } catch (MaximumNumberOfStudentsReached maximumNumberOfStudentsReached) {
        System.out.println(maximumNumberOfStudentsReached.getLocalizedMessage());
    }

    _________


          groupList.add(new Group(Arrays.asList(assignStudentsToGroup(1)));

         --------------

        Collections.shuffle(studentList);
        Map<String, List<Student>> grouping = (Map<String, List<Student>>) IntStream.range(0, studentList.size())
                .boxed()
                .collect(Collectors.groupingBy(i -> i % numberOfGroups))
                .values()
                .stream()
                .map(x -> x.studentList::get).collect(Collectors.toList()));

        System.out.println(grouping);


           Map<String, List<Student>> grouping = studentList.stream()
                .collect(Collectors.groupingBy(w -> w.getFirstName()));

        System.out.println(grouping);

        ----------

        final int numberOfGroups = 4;

        Collections.shuffle(studentList);
        List<List<String>> groups = IntStream.range(0, studentList.size())
                .boxed()
                .collect(Collectors.groupingBy(i -> i % numberOfGroups))
                .values()
                .stream()
                .map(x -> x.stream().map(studentList::get)).collect(Collectors.toList()))
                .collect(Collectors.toList());

        groups.forEach(System.out::println);

         */

    }

    public static List<Student> getInitialStudents() {

        Student student = new Student();
        student.setFirstName("Kristel");
        student.setLastName("Talimaa");
        student.setDateOfBirth(LocalDate.of(1996, 3, 29));
        student.setHasPreviousJavaKnowledge(true);

        Student student1 = new Student();
        student1.setFirstName("Martin");
        student1.setLastName("Põlluste");
        student1.setDateOfBirth(LocalDate.of(1995, 3, 8));
        student1.setHasPreviousJavaKnowledge(true);

        Student student2 = new Student();
        student2.setFirstName("Jüri");
        student2.setLastName("Ratas");
        student2.setDateOfBirth(LocalDate.of(1965, 5, 12));
        student2.setHasPreviousJavaKnowledge(true);

        Student student3 = new Student();
        student3.setFirstName("Mihkel");
        student3.setLastName("Pähkel");
        student3.setDateOfBirth(LocalDate.of(1970, 4, 20));
        student3.setHasPreviousJavaKnowledge(false);

        Student student4 = new Student();
        student4.setFirstName("Laura");
        student4.setLastName("Kaasik");
        student4.setDateOfBirth(LocalDate.of(1995, 11, 4));
        student4.setHasPreviousJavaKnowledge(true);

        Student student5 = new Student();
        student5.setFirstName("Aleks");
        student5.setLastName("Siht");
        student5.setDateOfBirth(LocalDate.of(1995, 5, 26));
        student5.setHasPreviousJavaKnowledge(false);

        Student student6 = new Student();
        student6.setFirstName("Tony");
        student6.setLastName("Stark");
        student6.setDateOfBirth(LocalDate.of(1988, 7, 26));
        student6.setHasPreviousJavaKnowledge(true);

        Student student7 = new Student();
        student7.setFirstName("Super");
        student7.setLastName("Man");
        student7.setDateOfBirth(LocalDate.of(1996, 2, 13));
        student7.setHasPreviousJavaKnowledge(true);

        Student student8 = new Student();
        student8.setFirstName("Santa");
        student8.setLastName("Claus");
        student8.setDateOfBirth(LocalDate.of(1980, 12, 24));
        student8.setHasPreviousJavaKnowledge(true);

        Student student9 = new Student();
        student9.setFirstName("Captain");
        student9.setLastName("America");
        student9.setDateOfBirth(LocalDate.of(2006, 10, 8));
        student9.setHasPreviousJavaKnowledge(true);

        Student student10 = new Student();
        student10.setFirstName("Malle");
        student10.setLastName("Maasikas");
        student10.setDateOfBirth(LocalDate.of(1990, 8, 20));
        student10.setHasPreviousJavaKnowledge(true);

        Student student11 = new Student();
        student11.setFirstName("Kalle");
        student11.setLastName("Kaalikas");
        student11.setDateOfBirth(LocalDate.of(1991, 9, 11));
        student11.setHasPreviousJavaKnowledge(true);

        Student student12 = new Student();
        student12.setFirstName("Jüri");
        student12.setLastName("Juurikas");
        student12.setDateOfBirth(LocalDate.of(2002, 1, 25));
        student12.setHasPreviousJavaKnowledge(true);

        Student student13 = new Student();
        student13.setFirstName("Reet");
        student13.setLastName("Redis");
        student13.setDateOfBirth(LocalDate.of(1999, 4, 12));
        student13.setHasPreviousJavaKnowledge(false);

        Student student14 = new Student();
        student14.setFirstName("Peeter");
        student14.setLastName("Termomeeter");
        student14.setDateOfBirth(LocalDate.of(1997, 3, 9));
        student14.setHasPreviousJavaKnowledge(true);

        Student student15 = new Student();
        student15.setFirstName("Kala");
        student15.setLastName("Mees");
        student15.setDateOfBirth(LocalDate.of(1996, 4, 16));
        student15.setHasPreviousJavaKnowledge(true);

        return List.of(student, student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11, student12, student13, student14, student15);
    }

    public static List<Trainer> getInitialTrainers() {

        Trainer trainer = new Trainer();
        trainer.setFirstName("Vinod");
        trainer.setLastName("John");
        trainer.setDateOfBirth(LocalDate.of(1990, 12, 22));
        trainer.setAuthorized(true);

        Trainer trainer1 = new Trainer();
        trainer1.setFirstName("Õpetaja");
        trainer1.setLastName("Ülo");
        trainer1.setDateOfBirth(LocalDate.of(1978, 6, 12));
        trainer1.setAuthorized(true);

        Trainer trainer2 = new Trainer();
        trainer2.setFirstName("Õpetaja");
        trainer2.setLastName("Madis");
        trainer2.setDateOfBirth(LocalDate.of(1997, 4, 15));
        trainer2.setAuthorized(false);

        return List.of(trainer, trainer1, trainer2);
    }

    public static List<Group> getInitialGroups() {

        Group group1 = new Group();
        group1.setGroupName("Java19Remote");
        group1.setTrainer(getInitialTrainers().get(0));

        Group group2 = new Group();
        group2.setGroupName("Java20Remote");
        group2.setTrainer(getInitialTrainers().get(1));

        Group group3 = new Group();
        group3.setGroupName("Java21Remote");
        group3.setTrainer(getInitialTrainers().get(2));

        Group group4 = new Group();
        group4.setGroupName("Java22Remote");
        group4.setTrainer(getInitialTrainers().get(1));

        return List.of(group1, group2, group3, group4);
    }

    private static void assignStudentsToGroup(List<Group> groupList) {



    }
}
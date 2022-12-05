package org.sda.java19;

import org.sda.java19.models.Group;
import org.sda.java19.models.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tasks {

    // Display all students in a group sorted alphabetically by lastName
    public void sortByLastName(List<Group> groupList) {
        for (Group group : groupList) {          // similar solution like advanced project branch 4
            group.setStudentsList(group.getStudentsList().stream()
                    .sorted(Comparator.comparing(Person::getLastName))                // or .sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
                    .collect(Collectors.toList()));
        }
    }


    // Display the group with the maximum number of students

   /*

    public void displayGroupWithMaxStudents(List<Group> groupList) {
        groupList.stream().max(Comparator.comparingInt(List::size))
                .ifPresent(System.out::println);
    }

    */

    // Display all students younger than 25, from all groups
    public void displayUnder25Students(List<Group> groupList) {
        groupList.forEach(group -> {        // groupList -> prints students from all the groups
            group.getStudentsList().forEach(student -> {
                if (getAge(student.getDateOfBirth().getYear()) < 25) {
                    System.out.println(student);
                }
            });
        });
    }

    // Short method to get the age
    private int getAge(int yearOfBirth) {
        return LocalDate.now().getYear() - yearOfBirth;
    }

}

package org.sda.java19.exceptions;

/**
 * Exception to handle threshold of the students in the group.
 *
 * @author Kristel Talimaa
 */

public class MaximumNumberOfStudentsReached extends Exception {
    public MaximumNumberOfStudentsReached(String groupName) {
        super(String.format("Group(name=%s) has reached maximum number of students", groupName));
    }
}

package org.sda.java19.models;

import lombok.Data;

/**
 * Student model extends the base class.
 *
 * @author Kristel Talimaa
 */
@Data
public class Student extends Person {
    private boolean hasPreviousJavaKnowledge;
}

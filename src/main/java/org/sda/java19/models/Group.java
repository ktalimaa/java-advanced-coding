package org.sda.java19.models;

import lombok.Data;

import java.util.List;

/**
 * Group model.
 *
 * @author Kristel Talimaa
 */

@Data
public class Group {
    private String groupName;
    private Trainer trainer;
    private List<Student> studentsList;
}

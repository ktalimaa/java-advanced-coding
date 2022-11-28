package org.sda.java19.models;

import lombok.Data;

/**
 * Trainer model extends from base class.
 *
 * @author Kristel Talimaa
 */

@Data
public class Trainer extends Person {
    private boolean isAuthorized;
}

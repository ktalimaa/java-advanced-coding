package org.sda.java19.models;

import lombok.Data;

/**
 * Tractor model that derives from Vehicle
 *
 * @author Kristel Talimaa
 */

@Data
public class Tractor extends Vehicle {
    private float maxPulledWeight;
}

package org.sda.java19.models;

import lombok.Data;

/**
 * Motorcycle model that derives from Vehicle
 *
 * @author Kristel Talimaa
 */

@Data
public class Motorcycle extends Vehicle {
    private float topSpeed;
    private VehicleShape vehicleShape;
}

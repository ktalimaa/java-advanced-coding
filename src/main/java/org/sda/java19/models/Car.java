package org.sda.java19.models;

import lombok.Data;
import lombok.ToString;

/**
 * Car model that derives from Vehicle
 *
 * @author Kristel Talimaa
 */
@Data
@ToString(callSuper = true)     // it will take to string also from the superclass
public class Car extends Motorcycle {
    private VehicleTransmission vehicleTransmission;
}



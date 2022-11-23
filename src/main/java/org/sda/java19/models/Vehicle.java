package org.sda.java19.models;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Vehicle base class
 *
 * @author Kristel Talimaa
 */

@Data
public class Vehicle {
    private String brand;
    private String model;
    private BigDecimal price;
}

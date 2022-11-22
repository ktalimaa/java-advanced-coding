package org.sda.java19.models;

import lombok.Data;

import java.util.List;

@Data
public class Warehouse {

    private String warehouseName;
    private String address;
    private List<Product> products;
    private boolean isActive;

}

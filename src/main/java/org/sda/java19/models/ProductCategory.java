package org.sda.java19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public enum ProductCategory {

    FOOD("Food"),
    DRINKS("Drinks"),
    CLOTHES("Clothes"),
    SHOES("Shoes"),
    ELECTRONICS("Electronics");

    private String nameOfCategory;

}

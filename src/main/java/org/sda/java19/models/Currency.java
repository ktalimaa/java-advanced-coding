package org.sda.java19.models;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
public enum Currency {

    EURO('€', "EUR"),
    US_DOLLAR('$', "USD");

    private char symbol;
    private String currency;

}

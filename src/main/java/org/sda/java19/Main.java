package org.sda.java19;

/**
 * Warehouse
 * a. User should be able to: add, display all the details, update, delete an item
 * b. Use composition and collections (The warehouse has products/items)
 * c. Add possibility to display summaries, like sum of all the products, their prices.
 * d. *Add possibility to update number of items in a specific way, e.g.:
 * “pliers:30”
 * “scissors:+4”
 *
 * @author Kristel Talimaa
 */

/*
        1. Create classes: Warehouse (classes), Product (classes), ProductCategory (enum), Currency (add as enum) - models package
        Composition -> class inside the class
        2. Warehouse should have fields like: name, List of Product, address, isActive (office)
        3. Product should have fields like: name, price per item, quantity, product category, currency, isAvailable
        4. Product Category: (main categories like food, clothes, shoes, electronics etc (for currency also, enums like EUR, USD etc)
        5. Next step -> WarehouseService
        6. Create warehouse object, it should have prefilled data, before create list of product (create product first) and then
        assign this to warehouse object, address etc
        7. In Main method you have switch case (based on options given above, choose option and do the operations).
        8. For each operation, call service method and do the operation

         */


public class Main {
    public static void main(String[] args) {






    }
}
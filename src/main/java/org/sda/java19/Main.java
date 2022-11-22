package org.sda.java19;

import org.sda.java19.models.Product;
import org.sda.java19.models.ProductCategory;
import org.sda.java19.models.Warehouse;
import org.sda.java19.services.ProductService;
import org.sda.java19.services.WarehouseService;
import org.sda.java19.services.implementation.ProductServiceImpl;
import org.sda.java19.services.implementation.WarehouseServiceImpl;
import org.sda.java19.util.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

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

// list for products, 10 pc min
// scanner
// menu, add, display


public class Main {

    public static void main(String[] args) {

        WarehouseService warehouseService = new WarehouseServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Initializing the warehouse
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseName("ABC E-POOD");
        warehouse.setAddress("Tallinn");
        warehouse.setActive(true);
        warehouse.setProducts(Data.getInitialProducts());

        warehouseService.addWarehouse(warehouse); // Adds new warehouse

        productOperations();

    }


    private static void productOperations() {
        ProductService productService = new ProductServiceImpl();
        Scanner scanner = new Scanner(System.in);

        int option = getOption();

        // here come switch case

        switch (option) {
            case 0: // add a product
                productService.addProduct(addProduct());
                break;
            case 1: // update a product


        }

    }


    private static int getOption() {

        Scanner scanner = new Scanner(System.in);
        //      scanner what displays all: add, update, delete etc
        return 0;

    }

    private static Product addProduct() {

        // add all values
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the details of the product:");
        System.out.println("Product name:");
        String productName = scanner.next();
        System.out.println("Product price:");
        float price = scanner.nextFloat();
        System.out.println("Choose a product category: " + Arrays.toString(ProductCategory.values()));
        ProductCategory productCategory = ProductCategory.valueOf(scanner.next()); // currency same way


        Product product = new Product();
        product.setName(productName);
        product.setPrice(BigDecimal.valueOf(price));
        product.setProductCategory(productCategory);

        return product;


    }

    /*

    private static Product updateProduct() {
        //Need to display all the products and then ask user to which product to update.


    }


     */

}
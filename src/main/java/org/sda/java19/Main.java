package org.sda.java19;

import org.sda.java19.exceptions.WarehouseNotFoundException;
import org.sda.java19.models.Product;
import org.sda.java19.models.ProductCategory;
import org.sda.java19.models.Warehouse;
import org.sda.java19.services.ProductService;
import org.sda.java19.services.WarehouseService;
import org.sda.java19.services.implementation.ProductServiceImpl;
import org.sda.java19.services.implementation.WarehouseServiceImpl;
import org.sda.java19.util.Data;

import java.math.BigDecimal;
import java.util.*;

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

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws WarehouseNotFoundException {

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


    private static void productOperations() throws WarehouseNotFoundException {

        ProductService productService = new ProductServiceImpl();

        int displayMenu = warehouseMenu();


        /*

        take shopping cart exercise
         diplaycartmenu
         getmenuoption, display like adding prod, II update prod, III display prod - use same getmenuoption in warehouse too

         based on this, do the operations
        getproducttocart


         */


        switch (displayMenu) {
            case 0: // add a product
                productService.addProduct(addProduct());
                break;
            case 1: // update a product
                productService.updateProduct(updateProduct());
                break;      // does it need break here?
            case 2: // delete products
                productService.deleteProductByName(deleteProduct());
                break;
            case 3:
                displayAllProducts(productService.getAllProducts());
                break;
            case 4: // display summary (like inventory)
                break;
            case 5: // sum of products and prices
                break;
            default:
                System.out.println("Incorrect option, use the correct one!");
        }
    }

    private static void displayAllProducts(List<Product> products) {
        products.forEach(System.out::println);
    }

    private static String deleteProduct() {
        // Display all the products and then ask user which product he wants to delte.
        return null;
    }

    private static String getAllProducts() throws WarehouseNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Products in the warehouse:");
        ProductServiceImpl productService = new ProductServiceImpl();

        return productService.getAllProducts().toString();
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

    private static Product updateProduct() throws WarehouseNotFoundException {       // Display all -> update
        Scanner scanner = new Scanner(System.in);
        System.out.println("Products in the warehouse:");
        ProductServiceImpl productService = new ProductServiceImpl();
        System.out.println("Choose a product to update or add another one: ");
        System.out.println(productService.getAllProducts());
        Product product = new Product();
        if (product.getName().equals(scanner.next())) {
            product.setName(scanner.next());
            product.setQuantity(scanner.nextFloat());
            product.setPrice(BigDecimal.valueOf(scanner.nextLong()));
            product.setProductCategory(ProductCategory.valueOf(scanner.next()));
        }
        return (Product) List.of(product);
    }

    private static String deleteProductByName() throws WarehouseNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product to delete:");
        String productName = scanner.next();

        return productName;
    }

    private static int warehouseMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------");
        System.out.println("WAREHOUSE MENU:");
        System.out.println("---------------");

        List<String> warehouseMenu = List.of("Add a product", "Update product list", "Display all products", "Delete a product", "Exit");

        for (int i = 0; i < warehouseMenu.size(); i++) {
            System.out.println(i + 1 + ". " + warehouseMenu.get(i));
        }
        System.out.println("Choose an option from above: ");
        return SCANNER.nextInt();

    }


    private static int getOption(int limit) {

        Scanner scanner = new Scanner(System.in);
        String errorMessage = "Incorrect option! Please enter again:";
        int option = limit + 1;

        do {
            if (!scanner.hasNextInt()) {
                System.out.println(errorMessage);
                scanner.next();
            } else {
                option = scanner.nextInt();     // correct input

                if (option > limit) {
                    System.out.println(errorMessage);
                }
            }
        } while (option > limit);

        return option;
    }
}

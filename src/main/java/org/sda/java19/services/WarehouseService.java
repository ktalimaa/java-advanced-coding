package org.sda.java19.services;

import org.sda.java19.models.Warehouse;

/**
 * Warehouse service will handle all warehouse operations.
 *
 * @author Kristel Talimaa
 */

// add, display, update and delete methods?
// summary method needed?

public interface WarehouseService {

    /**
     * To add a new warehouse
     *
     * @param warehouse Warehouse
     */
    void addWarehouse(Warehouse warehouse);

    /**
     * To update an existing warehouse
     *
     * @param warehouse Warehouse
     */

    void updateWarehouse(Warehouse warehouse);

    /**
     * To delete a warehouse
     *
     * @param warehouse Warehouse
     */
    void deleteWarehouse(Warehouse warehouse);


    /**
     * To get a warehouse
     *
     * @return Warehouse
     */
    Warehouse getWarehouse();

}

/*
 public class Main {
        private static final Scanner SCANNER = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.println("Add your products!");

            List<String> productList = new ArrayList<>();
            menuOperation(productList);
        }

        private static void menuOperation(List<String> productList) {

            int menuOption = getMenu();

            switch (menuOption) {
                case 1:
                    addProduct(productList);
                    menuOperation(productList);
                    break;
                case 2:
                    displayProduct(productList);
                    menuOperation(productList);
                    break;
                case 3:
                    deleteProduct(productList);
                    menuOperation(productList);
                    break;
                case 4:
                    //  updatedProducts(productList);
                    menuOperation(productList);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Incorrect option, choose the correct one!");
                    menuOperation(productList);
            }
        }


        private static int getMenu() {
            System.out.println("--------------");
            System.out.println("     MENU    ");
            System.out.println("--------------");

            List<String> menu = List.of("Add product", "Display products", "Delete products", "Display updated list of products", "Exit");

            for (int i = 0; i < menu.size(); i++) {
                System.out.println(i + 1 + ". " + menu.get(i));
            }
            System.out.println("Choose an option from above.");

            return SCANNER.nextInt();
        }


        // displays for each menu
        private static void addProduct(List<String> productList) {
            boolean isAdd = true;
            int addList = 1;

            while (isAdd) {
                System.out.println("Enter a product to add to the list: ");
                String addProduct = SCANNER.next();

                if (!productList.contains(addProduct)) {
                    productList.add(addProduct);
                    System.out.println("'" + addProduct + "' added to the list. Do you want to add more products? (true/false)");

                    System.out.println("PRODUCT LIST:");

                    for (String updated : productList) {
                        System.out.println(addList + ". " + updated);
                        addList++;
                    }
                } else {
                    System.out.println("The product already exists! Do you want to add another product? (true/false)");
                }
                isAdd = SCANNER.nextBoolean();
            }
        }

        // delete products
        private static void deleteProduct(List<String> productList) {
            boolean isDelete = true;
            int list = 1;

            while (isDelete) {
                System.out.println("Enter a color to be deleted from the list: ");
                String deleteProduct = SCANNER.next();

                if (productList.contains(deleteProduct)) {
                    productList.remove(deleteProduct);
                    System.out.println("'" + deleteProduct + "' deleted from the list. Do you want to delete more products? (true/false)");

                    System.out.println("PRODUCT LIST:");

                    for (String updated : productList) {
                        System.out.println(list + ". " + updated);
                        list++;
                    }
                } else {
                    System.out.println("The product does not exists! Do you want to delete another product? (true/false)");
                }
                isDelete = SCANNER.nextBoolean();
            }
        }

        // displaying the products
        private static void displayProduct(List<String> productList) {
            int counter = 1;

            System.out.println("PRODUCT LIST: ");

            for (int i = 0; i < productList.size(); i++) {
                String thisProduct = productList.get(i);

                System.out.println(counter + ". " + thisProduct);
                counter++;
            }
        }


    }


 */

//
//  /**
// * Adding product to the list
//   * @param product as Product
//  * @return List with products
//    */
//  void addProduct (Product product);
// String getProductsToList (String productName);

// /**
//   * Displaying products in the list
//   * @param listOfProducts as list
//   * @return List with products
//   */
//  Product displayProducts (String listOfProducts);

//   /**
//   * Displaying updated list of products
//   * @param updatedList as list
//   * @return List with products
//   */
//  Product updatedList (String updatedList);




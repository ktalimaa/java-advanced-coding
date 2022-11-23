package org.sda.java19.services;

import org.sda.java19.exceptions.WarehouseNotFoundException;
import org.sda.java19.models.Product;
import org.sda.java19.models.ProductCategory;

import java.time.Period;
import java.util.List;

/**
 * Product service will handle all product operations.
 *
 * @author Kristel Talimaa
 */
public interface ProductService {

    /**
     * To add a new product in a warehouse
     *
     * @param product Product
     */
    void addProduct(Product product);

    /**
     * To update an existing product in a warehouse
     *
     * @param product Product
     */

    void updateProduct(Product product);

    /**
     * To delete a product in a warehouse
     *
     * @param name name of the product
     */

    void deleteProductByName(String name);

    /**
     * To get a product by its name from a warehouse
     *
     * @param name name of the product
     * @return Product
     */

    Product getProductByName(String name) throws WarehouseNotFoundException;

    /**
     * To get a list of all products from the warehouse by a given category
     *
     * @param productCategory product category
     * @return list of products
     */

    List<Product> getAllProductsByProductCategory(ProductCategory productCategory) throws WarehouseNotFoundException;

    /**
     * To get all products from the warehouse
     *
     * @return list of products
     */

    List<Product> getAllProducts() throws WarehouseNotFoundException; // All products


}

// static use - static use, assign some data, but we cannot use to return the values
// void - does the operations, but doesn't return any value

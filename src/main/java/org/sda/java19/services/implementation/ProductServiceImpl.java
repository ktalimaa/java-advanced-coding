package org.sda.java19.services.implementation;

import org.sda.java19.models.Product;
import org.sda.java19.models.ProductCategory;
import org.sda.java19.services.ProductService;

import java.util.List;

/**
 * Implementation of ProductService
 *
 * @author Kristel Talimaa
 */

public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductByName(String name) {

    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProductsByProductCategory(ProductCategory productCategory) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}

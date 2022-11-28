package org.sda.java19.services.implementation;

import org.sda.java19.exceptions.WarehouseNotFoundException;
import org.sda.java19.models.Currency;
import org.sda.java19.models.Product;
import org.sda.java19.models.ProductCategory;
import org.sda.java19.models.Warehouse;
import org.sda.java19.services.ProductService;
import org.sda.java19.services.WarehouseService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Implementation of ProductService
 *
 * @author Kristel Talimaa
 */

public class ProductServiceImpl implements ProductService {

    // If you want to add product, first you get to warehouse
    private final WarehouseService warehouseService = new WarehouseServiceImpl();

    @Override
    public void addProduct(Product product) {
        try {
            Warehouse warehouse = warehouseService.getWarehouse();
            List<Product> products = warehouse.getProducts();
            products.add(product);
            warehouse.setProducts(products);
            warehouseService.updateWarehouse(warehouse);
        } catch (WarehouseNotFoundException warehouseNotFoundException) {
            System.out.println(warehouseNotFoundException.getLocalizedMessage());
        }
    }

    // get the warehouse, add product, get the list of product, update the list?
    @Override
    public void updateProduct(Product product) {
        try {
            Warehouse warehouse = warehouseService.getWarehouse();
            Optional<Product> productOptional = getProductByName(product.getName());

            if (productOptional.isEmpty()) {
                System.out.printf("The product(name=%s) is not found!%n", product.getName());
            } else {
                deleteProductByName((product.getName()));
                addProduct(product);
            }
        } catch (WarehouseNotFoundException warehouseNotFoundException) {
            System.out.println(warehouseNotFoundException.getLocalizedMessage());
        }
    }

    @Override
    public void deleteProductByName(String name) throws WarehouseNotFoundException {

        for (Product product : getAllProducts()) {

        }
       List<Product> productList = getAllProducts().stream()
               .peek(product -> {
                   if (product.getName().equals(name)) {
                       product.setAvailable(false);
                   }
               }).toList();
        Warehouse warehouse = warehouseService.getWarehouse();
        warehouse.setProducts(productList);
        warehouseService.updateWarehouse(warehouse);
    }

    @Override
    public Optional<Product> getProductByName(String name) throws WarehouseNotFoundException { // hw, same as list product
        return getAllProducts().stream()
                .filter(product -> product.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Product> getAllProductsByProductCategory(ProductCategory productCategory) throws WarehouseNotFoundException {
        return getAllProducts().stream()
                .filter(product -> product.getProductCategory().name().equals(productCategory.name()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllProducts() throws WarehouseNotFoundException {
        return warehouseService.getWarehouse().getProducts().stream()
                .filter(Product::isAvailable)
                .collect(Collectors.toList());
    }
}

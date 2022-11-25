package org.sda.java19.services.implementation;

import org.sda.java19.exceptions.WarehouseNotFoundException;
import org.sda.java19.models.Product;
import org.sda.java19.models.ProductCategory;
import org.sda.java19.models.Warehouse;
import org.sda.java19.services.ProductService;
import org.sda.java19.services.WarehouseService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of ProductService
 *
 * @author Kristel Talimaa
 */

public class ProductServiceImpl implements ProductService {

    // If you need to want to add product, first you get to warehouse
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

    }

    /*

    public void updateWarehouse(Warehouse warehouse) {
        try {
            Warehouse warehouseExisting = getWarehouse();

            if (warehouseExisting.getWarehouseName().equals(warehouse.getWarehouseName())) {
                Data.WAREHOUSE = warehouse;
            } else {
                throw new RuntimeException("Warehouse not matching!");
            }
        } catch (WarehouseNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

     */
    @Override
    public void deleteProductByName(String name) {
    }

    @Override
    public Product getProductByName(String name) throws WarehouseNotFoundException { // hw, same as list product
        return null;

    }

    @Override
    public List<Product> getAllProductsByProductCategory(ProductCategory productCategory) throws WarehouseNotFoundException {
        return getAllProducts().stream()
                .filter(product -> product.getProductCategory().name().equals(productCategory.name()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllProducts() throws WarehouseNotFoundException {
        return warehouseService.getWarehouse().getProducts();
    }
}

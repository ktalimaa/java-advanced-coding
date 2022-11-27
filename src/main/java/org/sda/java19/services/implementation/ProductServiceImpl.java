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
            Scanner scanner = new Scanner(System.in);
            Warehouse warehouse = warehouseService.getWarehouse();
            List<Product> products = warehouse.getProducts();
            products.add(product);
            warehouse.setProducts(products);
            product.setName(scanner.next());
            product.setPrice(BigDecimal.valueOf(scanner.nextLong()));
            product.setQuantity(scanner.nextFloat());
            product.setProductCategory(ProductCategory.valueOf(scanner.next()));
            product.setCurrency(Currency.valueOf(scanner.next()));
            product.setAvailable(scanner.nextBoolean());
            warehouseService.updateWarehouse(warehouse);
        } catch (WarehouseNotFoundException warehouseNotFoundException) {
            System.out.println(warehouseNotFoundException.getLocalizedMessage());
        }
    }

    @Override
    public void deleteProductByName(String name) {
        try {
            Warehouse warehouse = warehouseService.getWarehouse();
            List<Product> products = warehouse.getProducts();
            products.remove(name);
            warehouse.setProducts(products);
            warehouseService.updateWarehouse(warehouse);
        } catch (WarehouseNotFoundException warehouseNotFoundException) {
            System.out.println(warehouseNotFoundException.getLocalizedMessage());
        }
    }

    @Override
    public Product getProductByName(String name) throws WarehouseNotFoundException { // hw, same as list product
        Scanner scanner = new Scanner(System.in);
        return (Product) getAllProducts().stream()
                .filter(product -> product.getName().equals(scanner.nextLine()))
                .collect(Collectors.toList());
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

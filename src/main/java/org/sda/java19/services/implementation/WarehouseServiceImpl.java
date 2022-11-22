package org.sda.java19.services.implementation;

import org.sda.java19.exceptions.WarehouseNotFoundException;
import org.sda.java19.models.Warehouse;
import org.sda.java19.services.WarehouseService;
import org.sda.java19.util.Data;

/**
 * Implementation of WarehouseService
 *
 * @author Kristel Talimaa
 */

public class WarehouseServiceImpl implements WarehouseService {
    @Override
    public void addWarehouse(Warehouse warehouse) {
        try {
            getWarehouse();
            throw new RuntimeException("Warehouse already exsists! Cannot add a new one.");
        } catch (WarehouseNotFoundException e) {
            Data.WAREHOUSE = warehouse;
        }
    }

    @Override
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

    @Override
    public void deleteWarehouse(Warehouse warehouse) {
        try {
            Warehouse warehouseExisting = getWarehouse();
            warehouseExisting.setActive(false);
            Data.WAREHOUSE = warehouseExisting;
        } catch (WarehouseNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public Warehouse getWarehouse() throws WarehouseNotFoundException {
        Warehouse warehouse = Data.WAREHOUSE;

        if (warehouse == null) {
            throw new WarehouseNotFoundException("");
        }
        return warehouse;
    }
}

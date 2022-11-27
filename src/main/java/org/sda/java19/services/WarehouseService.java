package org.sda.java19.services;

import org.sda.java19.exceptions.WarehouseNotFoundException;
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
    Warehouse getWarehouse() throws WarehouseNotFoundException;

}




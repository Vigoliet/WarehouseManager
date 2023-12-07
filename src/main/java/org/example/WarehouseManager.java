package org.example;

import org.example.data_objects.Product;
import org.example.data_objects.Warehouse;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Optional;

public class WarehouseManager extends DataObjectManager<Warehouse>{


    /**
     * Adds a product to the warehouse with the specified ID
     *
     * @param warehouseId The id of the warehouse to add a product to
     * @param product The product to add to the warehouse
     */

    public void addProductToWarehouse(int warehouseId, Product product){
        Warehouse warehouse = getObjectById(warehouseId);

        warehouse.addProduct(product);
    }


    public void removeProductFromWarehouse(int productId, int warehouseId) {
        Warehouse warehouse = getObjectById(warehouseId);

        warehouse.removeProductById(productId);
    }
}

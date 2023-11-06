package org.example;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Optional;

public class WarehouseManager {

    private ArrayList<Warehouse> warehouses = new ArrayList<>();
    private int warehouseIdCounter = 0;


    /**
     * Adds a new warehouse to the list of all warehouses
     * @param warehouse The warehouse to add
     * @throws  IllegalArgumentException If a warehouse with the same ID exists already
     */
    public void addNewWarehouse(Warehouse warehouse) throws IllegalArgumentException{
        boolean idExists = warehouses.stream()
                .anyMatch(w -> w.getWarehouseId() == warehouse.getWarehouseId());

        if (idExists){
            throw new IllegalArgumentException("A warehouse with that ID already exists");
        }

        if(warehouse.getWarehouseId() == 0){
            int newWarehouseId = generateNewId();
            warehouse.setWarehouseId(newWarehouseId);
        } else if(warehouse.getWarehouseId() > warehouseIdCounter){
            warehouseIdCounter = warehouse.getWarehouseId();
        }

        warehouses.add(warehouse);
    }

    private int generateNewId() {
        warehouseIdCounter ++;
        return warehouseIdCounter;
    }

    /**
     * Gets all warehouses currently available
     * @return All warehouses
     */
    public ArrayList<Warehouse> getAllWarehouses(){
        return warehouses;
    }

    /**
     * Adds a product to the warehouse with the specified ID
     *
     * @param warehouseId The id of the warehouse to add a product to
     * @param product The product to add to the warehouse
     * @throws FindException If no warehouse exists with the ID
     */

    public void addProductToWarehouse(int warehouseId, Product product) throws FindException{
        Warehouse warehouse = getWarehouseById(warehouseId);

        warehouse.addProduct(product);
    }

    /**
     * Gets the warehouse with the specified ID
     * @param id The ID of the warehouse
     * @return The Warehouse
     * @throws FindException if no warehouse exists with the ID
     */
    public Warehouse getWarehouseById(int id) throws FindException{
        Optional<Warehouse> optionalWarehouse = Optional.of(warehouses.stream()
                .filter(w -> w.getWarehouseId() == id)
                .findFirst().get());

        // If there is a warehouse with the ID
        if (optionalWarehouse.isPresent()){

            // ...return it
            return optionalWarehouse.get();
        }

        // Otherwise throw and error
        throw new FindException("Warehouse with ID not found");

    }

}

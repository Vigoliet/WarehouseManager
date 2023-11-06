package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        WarehouseManager warehouseManager = new WarehouseManager();

        addInitialWarehouses(warehouseManager);

        while (true) {
            int selection = getMainMenuSelection();

            handleMenuSelection(selection, warehouseManager);
        }
    }


    /**
     * Shows the main menu to the user and returns the selection
     *
     * @return The users input selection
     */

    private static int getMainMenuSelection(){
        while (true) {
            try {
                System.out.print("\n\n---- MENU ----\n" +
                        "(1) Show warehouses\n" +
                        "(2) Add warehouses\n" +
                        "(3) Add product\n" +
                        "(4) Add product to warehouse\n" +
                        "Select: ");

                String input = scanner.nextLine();

                return Integer.parseInt(input);
            } catch (NumberFormatException exception){
                System.out.println("Invalid input! Please enter a number" + exception);
            }
        }

    }

    public static void handleMenuSelection(int selection, WarehouseManager warehouseManager){
        switch (selection){
            case 1:
                printAllWarehouses(warehouseManager);
                break;
            case 2:
                addWarehouseToManager(warehouseManager);
                break;
            default:
                System.out.println("Invalid menu selection");
                break;
        }
    }

    private static void addWarehouseToManager(WarehouseManager warehouseManager) {
        Warehouse newWarehouse = new Warehouse("sergels torg");
        warehouseManager.addNewWarehouse(newWarehouse);
        System.out.println(newWarehouse);

    }

    /**
     * Prints all warehouses of the warehouse manager
     *
     * @param warehouseManager The warehouse manager to print warehouses of
     */
    private static void printAllWarehouses(WarehouseManager warehouseManager) {
        var warehouses = warehouseManager.getAllWarehouses();

        printWarehouses(warehouses);
    }

    /**
     * Prints all warehouses in the list
     *
     * @param warehouses A list of warehouses to print
     */
    private static void printWarehouses(ArrayList<Warehouse> warehouses) {
        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse);
        }
    }

    /**
     * Adds a few warehouses to the warehouse manager
     *
     * @param warehouseManager The warehouse manager to add warehouses to
     */
    private static void addInitialWarehouses(WarehouseManager warehouseManager) {
        // Add initial warehouses and products
        Warehouse kista = new Warehouse(1, "Kista");
        Warehouse gothenburg = new Warehouse(2, "Göteborg");
        Warehouse stockholm = new Warehouse(3, "Stockholm");

        warehouseManager.addNewWarehouse(kista);
        warehouseManager.addNewWarehouse(gothenburg);
        warehouseManager.addNewWarehouse(stockholm);
    }
}
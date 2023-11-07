package org.example;

import org.example.data_objects.Warehouse;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    public static void main(String[] args) {

        WarehouseManager warehouseManager = new WarehouseManager();

        addInitialWarehouses(warehouseManager);

        while (running) {
            int selection = getMainMenuSelection();

            handleMenuSelection(selection, warehouseManager);
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

        warehouseManager.addNewObject(kista);
        warehouseManager.addNewObject(gothenburg);
        warehouseManager.addNewObject(stockholm);
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
                        "(0) Exit\n" +
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
            case 0:
                stopRunning(); // This is better than System.exit(0)
                break;
            default:
                System.out.println("Invalid menu selection");
                break;
        }
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
     * Prints all warehouses of the warehouse manager
     *
     * @param warehouseManager The warehouse manager to print warehouses of
     */
    private static void printAllWarehouses(WarehouseManager warehouseManager) {
        var warehouses = warehouseManager.getAllObjects();

        printWarehouses(warehouses);
    }

    private static void addWarehouseToManager(WarehouseManager warehouseManager) {
        Warehouse newWarehouse = getWarehouseFromUserInput();

        warehouseManager.addNewObject(newWarehouse);

        System.out.println("Warehouse added successfully!" + newWarehouse);

    }

    private static Warehouse getWarehouseFromUserInput() {
        System.out.print("\nInput location: ");
        String location = scanner.nextLine();


        return new Warehouse(location);
    }

    private static void stopRunning() {
        running = false;
        System.out.println("Program will stop now. \n" +
                "Have a great day!");
    }

}
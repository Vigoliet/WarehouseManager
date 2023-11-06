package org.example;

import java.util.ArrayList;

public class Warehouse {

    private int id;
    private String location;
    private final ArrayList <Product> products;

    public Warehouse(int id, String location) {
        this.id = id;
        setLocation(location); // calls for method that fixes location structure

        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        // kista / KISTA / kIsTa --> Kista

        String firstLetter = location.substring(0, 1).toUpperCase();
        String rest = location.substring(1).toLowerCase();


        return firstLetter + rest;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Product> getAllProducts(){
        return products;
    }

    /**
     * Adds a product to the warehouse stock
     *
     * @param product The product to add to the warehouse stock
     */
    public void addProduct(Product product){
        products.add(product);
    }

    /**
     * Removes one product with the specified id
     * @param id The product id to remove
     */
    public void removeProductById(int id){
        // remove => id:1

        // id:1, name:iphone <--
        // id:2, name:juice
        // id:1, name:iphone

        // Loop over every product
        int index = getIndexOfProductById(id);

    }

    private int getIndexOfProductById(int productId) {
        for (int i = 0; i < products.size(); i++) {

            // Save the product to local variable
            Product product = products.get(i);

            // If current product id == id to remove
            if (product.getId() == productId) {



                // Exit loop and method
                return i;
            }
        }
        return -1; // If not found return -1
    }


}

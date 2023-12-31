package org.example.data_objects;

import java.util.ArrayList;

public class Warehouse extends BaseDataObject{

    private String location;
    private ArrayList <Product> products = new ArrayList<>();

    public Warehouse(String location){
        setLocation(location);
    }

    public Warehouse(int id, String location) {
        setId(id);
        setLocation(location); // calls for method that fixes location structure

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
        products.remove(index);

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

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", product count=" + products.size() +
                '}';
    }
}

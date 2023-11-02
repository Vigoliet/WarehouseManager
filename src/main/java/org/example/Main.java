package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var wh = new Warehouse(1,"kista");
        //wh.addProduct();


        var p1 = new Product(1, "Samsung", 200, "An exclusive phone");
        var p2 = new Product(2, "Iphone", 200, "An exclusive phone");
        var p3 = new Product(1, "Samsung", 200, "An exclusive phone");
        wh.addProduct(p1);
        wh.addProduct(p2);
        wh.addProduct(p3);

        wh.listAllProducts();
        System.out.println("---");
        wh.removeProductById(1);
        wh.listAllProducts();


    }
}
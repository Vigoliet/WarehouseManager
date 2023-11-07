package org.example.data_objects;

public class Product extends BaseDataObject{


    private String productName;
    private int price; // Todo: Change to Currency
    private String description;

    public Product(String productName, int price, String description) {
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public Product(int id, String productName, int price, String description) {
        this(productName, price, description);
        setId(id);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

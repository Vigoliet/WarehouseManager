import org.example.DataObjectManager;
import org.example.data_objects.Product;
import org.example.data_objects.Warehouse;
import org.junit.Test;
import org.junit.Assert;

public class DataObjectManagerTests {

    @Test
    public void testAddNewObject(){
        Warehouse warehouse = new Warehouse("Kista");
        DataObjectManager<Warehouse> warehouseDataObjectManager = new DataObjectManager<Warehouse>();

        warehouseDataObjectManager.addNewObject(warehouse);

        Assert.assertEquals(1, warehouseDataObjectManager.getAllObjects().size());

    }

    @Test
    public void testAddObjectsWithIdNoId(){
        DataObjectManager<Product> productDataObjectManager = new DataObjectManager<>();
        Product product1 = new Product(200, "Iphone", 200, "An exclusive phone");
        Product product2 = new Product("usb-c charger", 1000, "Charger for your phone");

        productDataObjectManager.addNewObject(product1);
        productDataObjectManager.addNewObject(product2);

        Assert.assertEquals(201, product2.getId());
    }


    @Test
    public void testGetObjectById(){
        DataObjectManager<Product> productDataObjectManager = new DataObjectManager<>();
        Product product1 = new Product(200, "Iphone", 200, "An exclusive phone");
        Product product2 = new Product("usb-c charger", 1000, "Charger for your phone");

        productDataObjectManager.addNewObject(product1);
        productDataObjectManager.addNewObject(product2);

        Assert.assertEquals("Iphone", productDataObjectManager.getObjectById(200).getProductName());
        Assert.assertEquals("usb-c charger", productDataObjectManager.getObjectById(201).getProductName());

    }
}

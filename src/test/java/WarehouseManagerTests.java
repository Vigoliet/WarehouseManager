import org.example.data_objects.Product;
import org.example.data_objects.Warehouse;
import org.example.WarehouseManager;
import org.junit.Test;
import org.junit.Assert;

public class WarehouseManagerTests {
    @Test
    public void testAddNewWarehouses(){
        var warehouseManager = new WarehouseManager();
        var warehouse = new Warehouse(1, "Kista");

        warehouseManager.addNewObject(warehouse);

        Assert.assertEquals(1, warehouseManager.getAllObjects().size());

    }

    @Test
    public void testAddProductToWarehouse(){
        var warehouseManager = new WarehouseManager();
        var warehouse = new Warehouse(1, "Kista");
        var product = new Product(1, "Samsung", 200, "An exclusive phone");

        warehouseManager.addNewObject(warehouse);
        warehouseManager.addProductToWarehouse(1, product);

        warehouse = warehouseManager.getObjectById(1);

        Assert.assertEquals(1, warehouse.getAllProducts().size());

    }

    @Test
    public void testAddWarehouseNoId(){
        var warehouseManager = new WarehouseManager();
        var warehouse1 = new Warehouse("Sergels torg");
        var warehouse2 = new Warehouse("Falun");



        warehouseManager.addNewObject(warehouse1);
        warehouseManager.addNewObject(warehouse2);

        Assert.assertEquals(1, warehouse1.getId());
        Assert.assertEquals(2, warehouse2.getId());

    }

    @Test
    public void testAddWarehousesIdAndNoId(){
        var warehouseManager = new WarehouseManager();
        var warehouse1 = new Warehouse(1, "Sergels torg");
        var warehouse2 = new Warehouse("Falun");

        warehouseManager.addNewObject(warehouse1);
        warehouseManager.addNewObject(warehouse2);

        Assert.assertEquals(1, warehouse1.getId());
        Assert.assertEquals(2, warehouse2.getId());
    }
}

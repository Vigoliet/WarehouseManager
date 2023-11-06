import org.example.Product;
import org.example.Warehouse;
import org.example.WarehouseManager;
import org.junit.Test;
import org.junit.Assert;

public class WarehouseManagerTests {
    @Test
    public void testAddNewWarehouses(){
        var warehouseManager = new WarehouseManager();
        var warehouse = new Warehouse(1, "Kista");

        warehouseManager.addNewWarehouse(warehouse);

        assert warehouseManager.getAllWarehouses().size() == 1;

    }

    @Test
    public void testAddProductToWarehouse(){
        var warehouseManager = new WarehouseManager();
        var warehouse = new Warehouse(1, "Kista");
        var product = new Product(1, "Samsung", 200, "An exclusive phone");

        warehouseManager.addNewWarehouse(warehouse);
        warehouseManager.addProductToWarehouse(1, product);

        warehouse = warehouseManager.getWarehouseById(1);

        assert warehouse.getAllProducts().size() == 1;

    }

    @Test
    public void testAddWarehouseNoId(){
        var warehouseManager = new WarehouseManager();
        var warehouse1 = new Warehouse("Sergels torg");
        var warehouse2 = new Warehouse("Falun");



        warehouseManager.addNewWarehouse(warehouse1);
        warehouseManager.addNewWarehouse(warehouse2);

        Assert.assertEquals(1, warehouse1.getWarehouseId());
        Assert.assertEquals(2, warehouse2.getWarehouseId());

    }

    @Test
    public void testAddWarehousesIdAndNoId(){
        var warehouseManager = new WarehouseManager();
        var warehouse1 = new Warehouse(1, "Sergels torg");
        var warehouse2 = new Warehouse("Falun");

        warehouseManager.addNewWarehouse(warehouse1);
        warehouseManager.addNewWarehouse(warehouse2);

        Assert.assertEquals(1, warehouse1.getWarehouseId());
        Assert.assertEquals(2, warehouse2.getWarehouseId());
    }
}

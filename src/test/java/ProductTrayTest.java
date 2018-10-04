import org.junit.Before;
import org.junit.Test;
import products.Cola;
import products.VendingProduct;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductTrayTest {
    ProductTray productTray;
    VendingProduct product;


    @Before
    public void setUp() throws Exception {
        productTray = new ProductTray("A1", 2);
        product = new Cola("Coke", 1.00);
    }

    @Test
    public void canAddProduct() {
        productTray.addProduct(product);
        assertEquals(1, productTray.countStock());
    }

    @Test
    public void cantStockOverCapacity() {
        productTray.addProduct(product);
        productTray.addProduct(product);
        productTray.addProduct(product);
        assertEquals(2, productTray.countStock());
    }

    @Test
    public void canDispenseProduct() {
        productTray.addProduct(product);
        product = productTray.dispenseProduct();
        assertNotNull(product);
    }

    @Test
    public void canDispenseOnlyIfStocked() {
        product = productTray.dispenseProduct();
        assertNull(product);
    }

    @Test
    public void canReturnCode() {
        assertEquals("A1", productTray.getTrayCode());
    }
}

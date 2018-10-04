package products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColaTest {
    Cola cola;

    @Before
    public void setUp() throws Exception {
        cola = new Cola("Coke", 1.00);
    }

    @Test
    public void getName() {
        assertEquals("Coke", cola.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(1.00, cola.getPrice(), 0.01);
    }
}
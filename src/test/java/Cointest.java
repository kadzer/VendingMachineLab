import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cointest {
    Coin coin;

    @Before
    public void setUp() throws Exception {
        coin = new Coin(Currency.POUND);
    }

    @Test
    public void hasValue() {
        assertEquals(1.00, coin.getValue(), 0.01);
    }
}

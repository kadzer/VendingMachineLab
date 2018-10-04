import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReturnTrayTest {
    ReturnTray returnTray;
    ArrayList<Currency> validCoins;
    Coin coin;


    @Before
    public void setUp() throws Exception {
        validCoins = new ArrayList<Currency>();
        validCoins.add(Currency.POUND);
        returnTray = new ReturnTray(validCoins);
    }

    @Test
    public void canAddCoins() {
        coin = new Coin(Currency.POUND);
        returnTray.addCoin(coin);
        assertEquals(1, returnTray.countCoins());
    }
    @Test
    public void canAddOnlyValidCoins() {
        coin = new Coin(Currency.FIFTY);
        returnTray.addCoin(coin);
        assertEquals(0, returnTray.countCoins());
    }

    @Test
    public void canReturnTotal() {
        coin = new Coin(Currency.POUND);
        returnTray.addCoin(coin);
        returnTray.addCoin(coin);
        assertEquals(2.00, returnTray.getTotal(), 0.01);
    }
    @Test
    public void canRemoveCoins() {
        coin = new Coin(Currency.POUND);
        returnTray.addCoin(coin);
        assertNotNull(returnTray.removeCoin());
    }
}

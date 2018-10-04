import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MoneyBoxTest {
    ReturnTray returnTray;
    CoinSlot coinSlot;
    CoinStore coinStore;
    MoneyBox moneyBox;
    Coin coin1;
    Coin coin2;

    @Before
    public void setUp() throws Exception {
        ArrayList<Currency> validReturns = new ArrayList<>();
        validReturns.add(Currency.ONE);
        validReturns.add(Currency.TWO);
        validReturns.add(Currency.FIVE);
        validReturns.add(Currency.POUND);
        validReturns.add(Currency.TEN);
        validReturns.add(Currency.TWENTY);
        validReturns.add(Currency.FIFTY);
        validReturns.add(Currency.TWOPOUND);
        returnTray = new ReturnTray(validReturns);
        ArrayList<Currency> validCoinSlot = new ArrayList<>();
        validCoinSlot.add(Currency.FIVE);
        validCoinSlot.add(Currency.POUND);
        validCoinSlot.add(Currency.TEN);
        validCoinSlot.add(Currency.TWENTY);
        validCoinSlot.add(Currency.FIFTY);
        validCoinSlot.add(Currency.TWOPOUND);
        coinSlot = new CoinSlot(validCoinSlot);
        coinStore = new CoinStore(validCoinSlot);
        moneyBox = new MoneyBox(returnTray, coinSlot, coinStore);
    }

    @Test
    public void canSetAmountDue() {
        moneyBox.setDueAmount(0.60);
        assertEquals(0.60, moneyBox.getDueAmount(), 0.01);
    }

    @Test
    public void canReceiveValidCoin() {
        coin1 = new Coin(Currency.TWENTY);
        moneyBox.receiveCoin(coin1);
        assertEquals(1, this.coinSlot.countCoins());
    }

    @Test
    public void canReturnInvalidCoin() {
        coin1 = new Coin(Currency.ONE);
        moneyBox.receiveCoin(coin1);
        assertEquals(1, this.returnTray.countCoins());
    }

    @Test
    public void canDecreaseAmountDue() {
        moneyBox.setDueAmount(0.60);
        coin1 = new Coin(Currency.TWENTY);
        moneyBox.receiveCoin(coin1);
        assertEquals(0.40, moneyBox.getOutstandingAmount(), 0.01);
    }
}

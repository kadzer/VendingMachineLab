public class MoneyBox {
    private ReturnTray returnTray;
    private CoinSlot coinSlot;
    private CoinStore coinStore;
    private double dueAmount;

    public MoneyBox(ReturnTray returnTray, CoinSlot coinSlot, CoinStore coinStore) {
        this.returnTray = returnTray;
        this.coinSlot = coinSlot;
        this.coinStore = coinStore;
        this.dueAmount = 0;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void receiveCoin(Coin coin) {
        if(this.coinSlot.isValid(coin.getCurrencyType())){
        this.coinSlot.addCoin(coin);} else {
            this.returnTray.addCoin(coin);
        }
    }

    public double getOutstandingAmount() {
        return this.dueAmount - this.coinSlot.getTotal();
    }
}

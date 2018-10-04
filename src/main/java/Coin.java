public class Coin{
    private Currency currency;

    public Coin(Currency currency) {
        this.currency = currency;
    }

    public double getValue() {
        return this.currency.getValue();
    }
    public Currency getCurrencyType() {
        return this.currency;
    }
}


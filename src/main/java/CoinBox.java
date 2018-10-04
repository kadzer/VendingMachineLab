import java.util.ArrayList;

public abstract class CoinBox {
    private ArrayList<Currency> validCoins;
    private ArrayList<Coin> coins;
    private double total;

    public CoinBox(ArrayList<Currency> validCoins) {
        this.validCoins = validCoins;
        this.total = 0;
        this.coins = new ArrayList<>();
    }

    public int countCoins() {
        return this.coins.size();
    }

    public double getTotal() {
        return total;
    }

    public boolean isValid(Currency currency){
        return this.validCoins.contains(currency);
    }

    public void addCoin(Coin coin){
        if(isValid(coin.getCurrencyType())){
        this.total += coin.getValue();
        this.coins.add(coin);
        }
    }
    public Coin removeCoin(){
        Coin coin = this.coins.remove(0);
        this.total -= coin.getValue();
        return coin;
    }
}

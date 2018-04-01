package gestordemoedas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Wallet {
    
    private List<Coin> coins;
    private double credits;
    
    public Wallet(List<Coin> coins) {
        this.coins = coins;
    }

    public Wallet(List<Coin> coins, double credits) {
        this.coins = coins;
        this.credits = credits;
    }
    
    public Wallet() {
        this.coins = new ArrayList<>();
        coins.add(new Coin("Dolar", 10, 3.50));
        coins.add(new Coin("BitCoin", 0.0040, 20000));
        coins.add(new Coin("DogeCoin", 5, 10000));
        coins.add(new Coin("Gil", 19789, 5.60));
        coins.add(new Coin("Euro", 420, 4.50));
    }

    public List<Coin> getCoins() {
        return this.coins;
    }
    
    public Wallet setCoins(List<Coin> coins) {
        this.coins = coins;
        return this;
    }

    public double getCredits() {
        return credits;
    }

    public Wallet setCredits(double credit) {
        this.credits = credit;
        return this;
    }

    public double getTotalValue() {
       return coins.stream().mapToDouble(coin -> coin.getQuantity() * coin.getStockValue()).sum();
    }
}

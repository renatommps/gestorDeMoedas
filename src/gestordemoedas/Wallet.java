package gestordemoedas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Wallet implements Serializable {
    
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
        coins.add(new Coin("Dolar", 10, 3.50, false));
        coins.add(new Coin("BitCoin", 0.0040, 20000, true));
        coins.add(new Coin("DogeCoin", 5, 10000, true));
        coins.add(new Coin("Gil", 19789, 5.60, false));
        coins.add(new Coin("Euro", 420, 4.50, false));
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
    
    public void updateCoinStockValues(List<Coin> stockCoins) {
        for (Coin sc : stockCoins) {
            for (Coin c : coins) {
                if (c.getName().equals(sc.getName())) {
                    c.setStockValue(sc.getStockValue());
                }
            }
        }
    } 
}

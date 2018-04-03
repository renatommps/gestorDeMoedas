package gestordemoedas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Market implements Serializable {
    
    private List<Coin> coins;
    private final MrCotator stockValueRandomizer;
    
    public Market(List<Coin> coins) {
        this.coins = coins;
        stockValueRandomizer = new MrCotator(coins);
    }

    public Market() {
        this.coins = new ArrayList<>();
        coins.add(new Coin("Dolar", 10, 3.50, false));
        coins.add(new Coin("BitCoin", 0.0040, 20000, true));
        coins.add(new Coin("DogeCoin", 0, 10000, true));
        coins.add(new Coin("Gil", 0, 5.60, false));
        coins.add(new Coin("Euro", 0, 4.50, false));
        stockValueRandomizer = new MrCotator(coins);
    }

    public List<Coin> getCoins() {
        return this.coins;
    }
    
    public Market setCoins(List<Coin> coins) {
        this.coins = coins;
        return this;
    }
    
    public void updateValues() {
        stockValueRandomizer.updateValues();
        FileManager.getInstance().writeAllObjects(coins, "mercado");
    }

}

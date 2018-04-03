package gestordemoedas;

import java.util.List;


public class MrCotator {
    
    private final List<Coin> coins;
    
    public MrCotator(List<Coin> _coins) {
        coins = _coins;
    }
    
    public void updateValues() {
        coins.forEach((c) -> {
            double newValue = Math.floor(100 * (c.getStockValue()*(0.9+0.2*Math.random()))) / 100;
            c.setStockValue(newValue);
        });
    }
    
}

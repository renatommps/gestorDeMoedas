package cotador;

import java.util.ArrayList;
import java.util.List;


public class MrCotator {
    
    private final List<Coinable> coins;
    
    public <T extends Coinable> MrCotator(List<T> _coins) {
        coins = new ArrayList<Coinable>();
        coins.addAll(_coins);
    }
    
    public void updateValues() {
        coins.forEach((c) -> {
            double newValue = Math.floor(100 * (c.getStockValue()*(0.9+0.2*Math.random()))) / 100;
            c.defineStockValue(newValue);
        });
    }
    
}

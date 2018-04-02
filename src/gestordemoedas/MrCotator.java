/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordemoedas;

import java.util.List;

/**
 *
 * @author r.barbaresco
 */
public class MrCotator {
    
    private List<Coin> coins;
    
    
    public MrCotator(List<Coin> _coins) {
        coins = _coins;
    }
    
    public void updateValues() {
        for (Coin c : coins) {
            c.setStockValue(c.getStockValue()*(0.9+0.2*Math.random()));
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordemoedas;

/**
 *
 * @author r.barbaresco
 */
public class TaxCalculator {
    
    
    
    
    public double tax(Coin c) {
        double corretagem = 0.0025;
        double iof = 0;
        if (!c.isCrypto()) {
            iof = 0.011;
        }
        return c.getStockValue()*corretagem + c.getStockValue()*iof;
    }
    
}

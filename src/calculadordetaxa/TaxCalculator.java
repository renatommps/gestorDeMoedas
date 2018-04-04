package calculadordetaxa;


public class TaxCalculator {
     
    public <T extends Taxable> double tax(T c) {
        double corretagem = 0.0025;
        double iof = 0;
        if (!c.isCrypto()) {
            iof = 0.011;
        }
        return c.getStockValue()*corretagem + c.getStockValue()*iof;
    }
    
}

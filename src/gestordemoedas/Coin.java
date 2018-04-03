package gestordemoedas;

import java.io.Serializable;


public class Coin implements Serializable {

    private String name;
    private double quantity;
    private double stockValue;
    private boolean crypto;

    public Coin(String name, double quantity, double stockValue, boolean crypto) {
        this.name = name;
        this.quantity = quantity;
        this.stockValue = stockValue;
        this.crypto = crypto;
    }
    
    public String getName() {
        return name;
    }

    public Coin setName(String name) {
        this.name = name;
        return this;
    }

    public double getQuantity() {
        return quantity;
    }

    public Coin setQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getStockValue() {
        return stockValue;
    }

    public Coin setStockValue(double stockValue) {
        this.stockValue = stockValue;
        return this;
    }
    
    public boolean isCrypto() {
        return crypto;
    }
    public Coin setCrypto(boolean crypto) {
        this.crypto = crypto;
        return this;
    }
    
}

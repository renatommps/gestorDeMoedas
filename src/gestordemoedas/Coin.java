package gestordemoedas;

import java.io.Serializable;


public class Coin implements Serializable, Identificable {

    private String name;
    private double quantity;
    private double stockValue;
    private boolean crypto;

    public Coin(Coin another) { // copy constructor
        this.name = another.name;
        this.quantity = another.quantity;
        this.stockValue = another.stockValue;
        this.crypto = another.crypto;
  }
    
    public Coin(String name, double quantity, double stockValue, boolean crypto) {
        this.name = name;
        this.quantity = quantity;
        this.stockValue = stockValue;
        this.crypto = crypto;
    }
    
    public String getID() {
        return getName();
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Coin.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Coin other = (Coin) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
}

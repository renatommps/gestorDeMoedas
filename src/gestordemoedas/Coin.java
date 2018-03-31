package gestordemoedas;


public class Coin {

    private String name;
    private double quantity;
    private double stockValue;

    public Coin(String name, double quantity, double stockValue) {
        this.name = name;
        this.quantity = quantity;
        this.stockValue = stockValue;
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
    
}

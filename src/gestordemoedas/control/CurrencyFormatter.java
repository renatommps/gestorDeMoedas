package gestordemoedas.control;

import java.text.NumberFormat;
import java.util.Locale;


public class CurrencyFormatter {

    private final Locale locale;
    private final NumberFormat currencyFormatter;
    
    public CurrencyFormatter(String language, String country) {
        this.locale = new Locale(language, country);
        currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
    }
    
    public String format(Double value) {
        return currencyFormatter.format(value);
    }
}

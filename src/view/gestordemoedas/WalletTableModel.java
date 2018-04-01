package view.gestordemoedas;

import gestordemoedas.Coin;
import gestordemoedas.CurrencyFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class WalletTableModel extends AbstractTableModel {

    private final CurrencyFormatter currencyFormatter;
    private final String[] tableHeaders = {"Moeda", "Quantidade", "Cotação", "Valor total em R$"};
    private List<Coin> coins;

    WalletTableModel(List<Coin> coins) {
        this.currencyFormatter = new CurrencyFormatter("pt", "br");
        this.coins = coins;
        super.fireTableDataChanged();
    }

    private Object getTotalRealValue(Coin coin) {
        return currencyFormatter.format(coin.getQuantity() * coin.getStockValue());
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return tableHeaders[columnIndex];
    }
 
    @Override
    public int getRowCount() {
        return coins.size();
    }

    @Override
    public int getColumnCount() {
        return tableHeaders.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Coin coin = coins.get( rowIndex );
         
         switch( columnIndex ) {
             case 0: return coin.getName();
             case 1: return coin.getQuantity();
             case 2: return coin.getStockValue();
             case 3: return getTotalRealValue(coin);
         }
         return null;
    }
    
}

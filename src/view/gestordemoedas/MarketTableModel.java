package view.gestordemoedas;

import gestordemoedas.Coin;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class MarketTableModel extends AbstractTableModel {

    private final String[] tableHeaders = {"Moeda", "Cotação"};
    private List<Coin> coins;

    MarketTableModel(List<Coin> coins) {
        this.coins = coins;
        super.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.tableHeaders[columnIndex];
    }
 
    @Override
    public int getRowCount() {
        return this.coins.size();
    }

    @Override
    public int getColumnCount() {
        return tableHeaders.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Coin coin = this.coins.get( rowIndex );
         
        switch( columnIndex ) {
            case 0: return coin.getName();
            case 1: return coin.getStockValue();
            default: return null;
        }
    }
    
}

package view.gestordemoedas;

import gestordemoedas.Wallet;
import gestordemoedas.Coin;
import gestordemoedas.CurrencyFormatter;
import gestordemoedas.GerenciadorDeUsuarios;
import gestordemoedas.Market;
import java.util.List;
import javax.swing.JOptionPane;


public class MainScreen extends javax.swing.JFrame {

    private static MainScreen instance;
    private final CurrencyFormatter currencyFormatter;
    private Wallet wallet;
    private Market market;
    private WalletTableModel walletTableModel;
    private MarketTableModel marketTableModel;
    
    public static MainScreen getInstance() {
        if (instance == null)
            instance = new MainScreen();
        return instance;
    }
    
    private MainScreen() {
        this.currencyFormatter = new CurrencyFormatter("pt", "br");
        //this.wallet = new Wallet();
        this.market = new Market();
        this.wallet = GerenciadorDeUsuarios.getInstance().getUsuarioAtual().getCarteira();
        this.walletTableModel = new WalletTableModel(this.wallet.getCoins());
        this.marketTableModel = new MarketTableModel(this.market.getCoins());
        
        initComponents();
        this.setVisible(true);  
    }

    private void updateSaleRealQuantity() {
        if ((jComboBoxSaleCurrency.getSelectedIndex() > -1) && 
                (jFormattedTextFieldSaleQuantity.getText() != null && !jFormattedTextFieldSaleQuantity.getText().trim().isEmpty()) ){
            
            Coin selectedCoin = wallet.getCoins().get(jComboBoxSaleCurrency.getSelectedIndex());
            double value = Double.parseDouble(jFormattedTextFieldSaleQuantity.getText()) * selectedCoin.getStockValue();
            jTextFieldSaleRealValue.setText(currencyFormatter.format(value));
            jTextFieldSaleRealValue.repaint();
        } else {
            jTextFieldSaleRealValue.setText("");
            jTextFieldSaleRealValue.repaint();
        }
    }
    
    public void updateBuyingRealQuantity(){
        if ((jComboBoxBuyingCoin.getSelectedIndex() > -1) && 
                (jFormattedTextFieldBuyingQuantity.getText() != null && !jFormattedTextFieldBuyingQuantity.getText().trim().isEmpty()) ){
            
            Coin selectedCoin = market.getCoins().get(jComboBoxBuyingCoin.getSelectedIndex());
            double value = Double.parseDouble(jFormattedTextFieldBuyingQuantity.getText()) * selectedCoin.getStockValue();
            jTextFieldBuyingRealValue.setText(currencyFormatter.format(value));
            jTextFieldBuyingRealValue.repaint();
        } else {
            jTextFieldBuyingRealValue.setText("");
            jTextFieldBuyingRealValue.repaint();
        }
    }
    
    public void consumeLetter(java.awt.event.KeyEvent evt) {
        char c  = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelWallet = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTotalValue = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxSaleCurrency = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldSaleRealValue = new javax.swing.JTextField();
        jButtonSell = new javax.swing.JButton();
        jFormattedTextFieldSaleQuantity = new javax.swing.JFormattedTextField();
        jLabelTotal1 = new javax.swing.JLabel();
        jLabelTotalCredits = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableWalletCoins = new javax.swing.JTable();
        jPanelMarket = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxBuyingCoin = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldBuyingRealValue = new javax.swing.JTextField();
        jButtonBuy = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabelTotalCreditsMarket = new javax.swing.JLabel();
        jFormattedTextFieldBuyingQuantity = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMarketCoins = new javax.swing.JTable();
        jPanelTransfer = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
        });
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanelWallet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTotal.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText("Valor Total de moedas(R$)");

        jLabelTotalValue.setText(currencyFormatter.format(wallet.getTotalValue()));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));

        jLabel6.setText("Moeda:");

        jLabel8.setText("Quantidade:");

        jComboBoxSaleCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(wallet.getCoins()
            .stream()
            .map(Coin::getName)
            .toArray(String[]::new))
    );
    jComboBoxSaleCurrency.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jComboBoxSaleCurrencyItemStateChanged(evt);
        }
    });
    jComboBoxSaleCurrency.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxSaleCurrencyActionPerformed(evt);
        }
    });
    jComboBoxSaleCurrency.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            jComboBoxSaleCurrencyPropertyChange(evt);
        }
    });

    jLabel9.setText("Equivalente em R$:");

    jTextFieldSaleRealValue.setEditable(false);

    jButtonSell.setText("Vender");
    jButtonSell.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonSellActionPerformed(evt);
        }
    });

    jFormattedTextFieldSaleQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jFormattedTextFieldSaleQuantityKeyTyped(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jFormattedTextFieldSaleQuantityKeyReleased(evt);
        }
    });

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel6))
                    .addGap(45, 45, 45)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxSaleCurrency, 0, 140, Short.MAX_VALUE)
                        .addComponent(jFormattedTextFieldSaleQuantity))
                    .addGap(45, 45, 45)
                    .addComponent(jLabel9)
                    .addGap(35, 35, 35)
                    .addComponent(jTextFieldSaleRealValue, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(397, 397, 397)
                    .addComponent(jButtonSell, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(100, Short.MAX_VALUE))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBoxSaleCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6))
            .addGap(18, 18, 18)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(jLabel9)
                .addComponent(jTextFieldSaleRealValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jFormattedTextFieldSaleQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
            .addComponent(jButtonSell)
            .addContainerGap())
    );

    jLabelTotal1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    jLabelTotal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabelTotal1.setText("Valor Total de creditos(R$)");

    jLabelTotalCredits.setText(currencyFormatter.format(wallet.getCredits()));

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Moedas"));

    jTableWalletCoins.setModel(walletTableModel);
    jScrollPane1.setViewportView(jTableWalletCoins);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1)
            .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanelWalletLayout = new javax.swing.GroupLayout(jPanelWallet);
    jPanelWallet.setLayout(jPanelWalletLayout);
    jPanelWalletLayout.setHorizontalGroup(
        jPanelWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelWalletLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelWalletLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanelWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelWalletLayout.createSequentialGroup()
                            .addComponent(jLabelTotal)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelWalletLayout.createSequentialGroup()
                            .addComponent(jLabelTotal1)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelTotalCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanelWalletLayout.setVerticalGroup(
        jPanelWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelWalletLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanelWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTotalValue)
                .addComponent(jLabelTotal))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTotalCredits)
                .addComponent(jLabelTotal1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    jTabbedPane1.addTab("Carteira", jPanelWallet);

    jPanelMarket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Compra"));

    jLabel4.setText("Moeda:");

    jLabel5.setText("Quantidade:");

    jComboBoxBuyingCoin.setModel(new javax.swing.DefaultComboBoxModel<>(market.getCoins()
        .stream()
        .map(Coin::getName)
        .toArray(String[]::new)));
jComboBoxBuyingCoin.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBoxBuyingCoinActionPerformed(evt);
    }
    });

    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel7.setText("Equivalente da compra m R$:");

    jTextFieldBuyingRealValue.setEditable(false);

    jButtonBuy.setText("Comprar");

    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel10.setText("Valor disponível na carteira em R$:");

    jLabelTotalCreditsMarket.setText(currencyFormatter.format(wallet.getCredits()));

    jFormattedTextFieldBuyingQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jFormattedTextFieldBuyingQuantityKeyTyped(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jFormattedTextFieldBuyingQuantityKeyReleased(evt);
        }
    });

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addGap(40, 40, 40)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxBuyingCoin, 0, 140, Short.MAX_VALUE)
                        .addComponent(jFormattedTextFieldBuyingQuantity))
                    .addGap(45, 45, 45)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldBuyingRealValue, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(jLabelTotalCreditsMarket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(281, 281, 281)
                    .addComponent(jButtonBuy)))
            .addContainerGap(72, Short.MAX_VALUE))
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBoxBuyingCoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4)
                .addComponent(jLabel10)
                .addComponent(jLabelTotalCreditsMarket))
            .addGap(18, 18, 18)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jLabel7)
                .addComponent(jTextFieldBuyingRealValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jFormattedTextFieldBuyingQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
            .addComponent(jButtonBuy)
            .addContainerGap())
    );

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Moedas"));

    jTableMarketCoins.setModel(marketTableModel);
    jScrollPane2.setViewportView(jTableMarketCoins);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2)
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanelMarketLayout = new javax.swing.GroupLayout(jPanelMarket);
    jPanelMarket.setLayout(jPanelMarketLayout);
    jPanelMarketLayout.setHorizontalGroup(
        jPanelMarketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelMarketLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelMarketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanelMarketLayout.setVerticalGroup(
        jPanelMarketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMarketLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jTabbedPane1.addTab("Mercado", jPanelMarket);

    jPanelTransfer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    buttonGroup1.add(jRadioButton1);
    jRadioButton1.setSelected(true);
    jRadioButton1.setText("Depoósito");
    jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButton1ActionPerformed(evt);
        }
    });

    buttonGroup1.add(jRadioButton2);
    jRadioButton2.setText("Saque");

    jLabel1.setText("Conta bancária:");

    jTextField2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField2ActionPerformed(evt);
        }
    });

    jTextField3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField3ActionPerformed(evt);
        }
    });

    jLabel2.setText("Valor:");

    jButton1.setText("Confirmar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanelTransferLayout = new javax.swing.GroupLayout(jPanelTransfer);
    jPanelTransfer.setLayout(jPanelTransferLayout);
    jPanelTransferLayout.setHorizontalGroup(
        jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTransferLayout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanelTransferLayout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelTransferLayout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelTransferLayout.createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(278, Short.MAX_VALUE))
    );
    jPanelTransferLayout.setVerticalGroup(
        jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTransferLayout.createSequentialGroup()
            .addGap(78, 78, 78)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jButton1)
                .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)))
            .addContainerGap(362, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("Transferência", jPanelTransfer);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldSaleQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldSaleQuantityKeyReleased
        updateSaleRealQuantity();
    }//GEN-LAST:event_jFormattedTextFieldSaleQuantityKeyReleased

    private void jFormattedTextFieldSaleQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldSaleQuantityKeyTyped
        consumeLetter(evt);
    }//GEN-LAST:event_jFormattedTextFieldSaleQuantityKeyTyped

    private void jButtonSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSellActionPerformed
        
        int coinTableIndex = jComboBoxSaleCurrency.getSelectedIndex();
        String saleQuantityText = jFormattedTextFieldSaleQuantity.getText().trim();
        
        if ( (coinTableIndex > -1) && (saleQuantityText != null && !saleQuantityText.isEmpty()) ) {
            
            Coin selectedCoin = wallet.getCoins().get(coinTableIndex);
            double quantity = Double.parseDouble(saleQuantityText);
            double value = quantity * selectedCoin.getStockValue();
            double quantityLeft = selectedCoin.getQuantity() - quantity;
            
            if (quantityLeft >= 0) {
                selectedCoin.setQuantity(quantityLeft);
                wallet.setCredits(wallet.getCredits() + value);
                
                if (selectedCoin.getQuantity() <= 0) {
                    List<Coin> updatedCoins = wallet.getCoins();
                    updatedCoins.stream().filter(coin -> coin.getQuantity() >= 0);
                    wallet.setCoins(updatedCoins);
                    
                    ((WalletTableModel)jTableWalletCoins.getModel()).removeRow(coinTableIndex);
  
                    jComboBoxSaleCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(wallet.getCoins().stream().map(Coin::getName).toArray(String[]::new)));
                    jComboBoxSaleCurrency.repaint();
                }
                
                jFormattedTextFieldSaleQuantity.setText("");
                jLabelTotalValue.setText(currencyFormatter.format(wallet.getTotalValue()));
                jLabelTotalCredits.setText(currencyFormatter.format(wallet.getCredits()));
                jLabelTotalCreditsMarket.setText(currencyFormatter.format(wallet.getCredits()));
                jTextFieldSaleRealValue.setText("");
                
                GerenciadorDeUsuarios.getInstance().salvarUsuarioAtual();
                
                jTableWalletCoins.repaint();
                
                JOptionPane.showMessageDialog(null, "Venda realizada com sucésso.","Mensagem", JOptionPane.DEFAULT_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade selecionada maior que a dispinível na carteira para a moeda selecionada.","Aviso", JOptionPane.WARNING_MESSAGE);
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Para efetuar uma venda você deve informar uma moeda e a quantidade a ser vendida.","Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSellActionPerformed

    private void jComboBoxSaleCurrencyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxSaleCurrencyPropertyChange
        updateSaleRealQuantity();
    }//GEN-LAST:event_jComboBoxSaleCurrencyPropertyChange

    private void jComboBoxSaleCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSaleCurrencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSaleCurrencyActionPerformed

    private void jComboBoxSaleCurrencyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSaleCurrencyItemStateChanged
        updateSaleRealQuantity();
    }//GEN-LAST:event_jComboBoxSaleCurrencyItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jComboBoxBuyingCoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBuyingCoinActionPerformed
        updateBuyingRealQuantity();
    }//GEN-LAST:event_jComboBoxBuyingCoinActionPerformed

    private void jFormattedTextFieldBuyingQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldBuyingQuantityKeyTyped
        consumeLetter(evt);
    }//GEN-LAST:event_jFormattedTextFieldBuyingQuantityKeyTyped

    private void jFormattedTextFieldBuyingQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldBuyingQuantityKeyReleased
        // TODO add your handling code here:   
    }//GEN-LAST:event_jFormattedTextFieldBuyingQuantityKeyReleased

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JButton jButtonSell;
    private javax.swing.JComboBox<String> jComboBoxBuyingCoin;
    private javax.swing.JComboBox<String> jComboBoxSaleCurrency;
    private javax.swing.JFormattedTextField jFormattedTextFieldBuyingQuantity;
    private javax.swing.JFormattedTextField jFormattedTextFieldSaleQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotal1;
    private javax.swing.JLabel jLabelTotalCredits;
    private javax.swing.JLabel jLabelTotalCreditsMarket;
    private javax.swing.JLabel jLabelTotalValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelMarket;
    private javax.swing.JPanel jPanelTransfer;
    private javax.swing.JPanel jPanelWallet;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMarketCoins;
    private javax.swing.JTable jTableWalletCoins;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldBuyingRealValue;
    private javax.swing.JTextField jTextFieldSaleRealValue;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

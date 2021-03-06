package gestordemoedas.view;

import gestordemoedas.control.BankManager;
import gestordemoedas.model.Wallet;
import gestordemoedas.model.Coin;
import gestordemoedas.control.CurrencyFormatter;
import gerenciadordearquivos.FileManager;
import autenticacao.GerenciadorDeUsuarios;
import gestordemoedas.model.Market;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;


public class MainScreen extends javax.swing.JFrame {

    private static MainScreen instance;
    private final CurrencyFormatter currencyFormatter;
    private Wallet wallet;
    private Market market;
    private WalletTableModel walletTableModel;
    private MarketTableModel marketTableModel;
    private BankManager bankManager;
    
    public static MainScreen getInstance() {
        if (instance == null)
            instance = new MainScreen();
        return instance;
    }
    
    private MainScreen() {
        this.currencyFormatter = new CurrencyFormatter("pt", "br");
        
        this.wallet = GerenciadorDeUsuarios.getInstance().getUsuarioAtual().getCarteira();
        List<Coin> marketCoins = FileManager.getInstance().readAllObjects("mercado");
        if (marketCoins.isEmpty()) {
            this.market = new Market();
        } else {
            this.market = new Market(marketCoins);
            this.wallet.updateCoinStockValues(marketCoins);
        }
        this.walletTableModel = new WalletTableModel(this.wallet.getCoins());
        this.marketTableModel = new MarketTableModel(this.market.getCoins());
        this.bankManager = new BankManager();
        
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
            double value = Double.parseDouble(jFormattedTextFieldBuyingQuantity.getText()) * (selectedCoin.getStockValue() + market.tax(selectedCoin));
            jTextFieldBuyingRealValue.setText(currencyFormatter.format(value));
            jTextFieldBuyingRealValue.repaint();
        } else {
            jTextFieldBuyingRealValue.setText("");
            jTextFieldBuyingRealValue.repaint();
        }
    }
    
    private void updateCreditListenners() {
        jLabelTotalCredits.setText(currencyFormatter.format(wallet.getCredits()));
        jLabelTotalCreditsMarket.setText(currencyFormatter.format(wallet.getCredits()));
        jLabelTotalCreditsForTransfer.setText(currencyFormatter.format(wallet.getCredits()));    
    }
        
    public void consumeLetter(java.awt.event.KeyEvent evt) {
        char c  = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
        }
    }
    
    private void handleDeposit() {
        String account = jTextFieldTransferAccount.getText().trim();
        double value = Double.parseDouble(jTextFieldTransferValue.getText().trim());
       
        if (value <= this.wallet.getCredits()) {
            try {
                if( this.bankManager.deposit(account, value) ){
                    double updatedCredits = this.wallet.getCredits() - value;
                    this.wallet.setCredits(updatedCredits);
                    updateCreditListenners();

                    JOptionPane.showMessageDialog(null, "Transação efetuada com sucésso.","Mensagem", JOptionPane.DEFAULT_OPTION);
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Algum erro ocorreu no meio da transação.","Mensagem", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Créditos insuficientes.","Mensagem", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void handleWithdraw() {
        String account = jTextFieldTransferAccount.getText().trim();
        double value = Double.parseDouble(jTextFieldTransferValue.getText().trim());
       
        try {
            if( this.bankManager.withdraw(account, value) ){
                double updatedCredits = this.wallet.getCredits() + value;
                this.wallet.setCredits(updatedCredits);
                updateCreditListenners();

                JOptionPane.showMessageDialog(null, "Transação efetuada com sucésso.","Mensagem", JOptionPane.DEFAULT_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Conta sem fundo suficiente para o saque","Mensagem", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu no meio da transação.","Mensagem", JOptionPane.WARNING_MESSAGE);
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
        jButton2 = new javax.swing.JButton();
        jPanelTransfer = new javax.swing.JPanel();
        jRadioButtonDeposit = new javax.swing.JRadioButton();
        jRadioButtonWithdraw = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTransferAccount = new javax.swing.JTextField();
        jTextFieldTransferValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabelTotalCreditsForTransfer = new javax.swing.JLabel();

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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
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
    jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonBuyActionPerformed(evt);
        }
    });

    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel10.setText("Valor disponível na carteira em R$:");

    jLabelTotalCreditsMarket.setText(currencyFormatter.format(wallet.getCredits()));

    jFormattedTextFieldBuyingQuantity.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jFormattedTextFieldBuyingQuantityActionPerformed(evt);
        }
    });
    jFormattedTextFieldBuyingQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jFormattedTextFieldBuyingQuantityKeyReleased(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jFormattedTextFieldBuyingQuantityKeyTyped(evt);
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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
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

    jButton2.setText("Atualizar Cotação");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

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
        .addGroup(jPanelMarketLayout.createSequentialGroup()
            .addGap(332, 332, 332)
            .addComponent(jButton2)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelMarketLayout.setVerticalGroup(
        jPanelMarketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMarketLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton2)
            .addGap(18, 18, 18)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    jTabbedPane1.addTab("Mercado", jPanelMarket);

    jPanelTransfer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    buttonGroup1.add(jRadioButtonDeposit);
    jRadioButtonDeposit.setSelected(true);
    jRadioButtonDeposit.setText("Depoósito");
    jRadioButtonDeposit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonDepositActionPerformed(evt);
        }
    });
    jRadioButtonDeposit.setActionCommand("deposito");

    buttonGroup1.add(jRadioButtonWithdraw);
    jRadioButtonWithdraw.setText("Saque");
    jRadioButtonWithdraw.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jRadioButtonWithdrawActionPerformed(evt);
        }
    });
    jRadioButtonWithdraw.setActionCommand("saque");

    jLabel1.setText("Conta bancária:");

    jTextFieldTransferAccount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldTransferAccountActionPerformed(evt);
        }
    });

    jTextFieldTransferValue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldTransferValueActionPerformed(evt);
        }
    });

    jLabel2.setText("Valor:");

    jButton1.setText("Confirmar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel11.setText("Valor disponível para saque R$:");

    jLabelTotalCreditsForTransfer.setText(currencyFormatter.format(wallet.getCredits()));

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
                    .addComponent(jTextFieldTransferAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelTransferLayout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelTransferLayout.createSequentialGroup()
                            .addComponent(jRadioButtonDeposit)
                            .addGap(18, 18, 18)
                            .addComponent(jRadioButtonWithdraw)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(jTextFieldTransferValue, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelTransferLayout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelTotalCreditsForTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addContainerGap(278, Short.MAX_VALUE))
    );
    jPanelTransferLayout.setVerticalGroup(
        jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTransferLayout.createSequentialGroup()
            .addGap(78, 78, 78)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jTextFieldTransferAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(jTextFieldTransferValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jButton1)
                .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonDeposit)
                    .addComponent(jRadioButtonWithdraw)))
            .addGap(52, 52, 52)
            .addGroup(jPanelTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11)
                .addComponent(jLabelTotalCreditsForTransfer))
            .addContainerGap(258, Short.MAX_VALUE))
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                
                updateCreditListenners();
                
                jTextFieldSaleRealValue.setText("");
                
                GerenciadorDeUsuarios.getInstance().salvarUsuarioAtual();
                
                jTableWalletCoins.repaint();
                
                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso.","Mensagem", JOptionPane.DEFAULT_OPTION);
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
        String transaction = buttonGroup1.getSelection().getActionCommand();
        if (transaction.equals("saque")) {
            handleWithdraw();
        } else {
            handleDeposit();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldTransferValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTransferValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTransferValueActionPerformed

    private void jTextFieldTransferAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTransferAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTransferAccountActionPerformed

    private void jRadioButtonDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDepositActionPerformed
   // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonDepositActionPerformed

    private void jComboBoxBuyingCoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBuyingCoinActionPerformed
        updateBuyingRealQuantity();
    }//GEN-LAST:event_jComboBoxBuyingCoinActionPerformed

    private void jFormattedTextFieldBuyingQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldBuyingQuantityKeyTyped
        consumeLetter(evt);
    }//GEN-LAST:event_jFormattedTextFieldBuyingQuantityKeyTyped

    private void jFormattedTextFieldBuyingQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldBuyingQuantityKeyReleased
        updateBuyingRealQuantity();
    }//GEN-LAST:event_jFormattedTextFieldBuyingQuantityKeyReleased

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        market.updateValues();
        wallet.updateCoinStockValues(market.getCoins());
        jLabelTotalValue.setText(currencyFormatter.format(wallet.getTotalValue()));
        updateSaleRealQuantity();
        updateBuyingRealQuantity();
        jTableMarketCoins.repaint();
        jTableWalletCoins.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void jFormattedTextFieldBuyingQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldBuyingQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldBuyingQuantityActionPerformed

    public void updateWallet(double creditsLeft, Coin coin) {
        wallet.setCredits(creditsLeft);
        wallet.updateCoin(coin);
    }
    
    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyActionPerformed
        
        int coinTableIndex = jComboBoxBuyingCoin.getSelectedIndex();
        String buyingQuantityText = jFormattedTextFieldBuyingQuantity.getText().trim();
        
        if ( (coinTableIndex > -1) && (buyingQuantityText != null && !buyingQuantityText.isEmpty()) ) {
            
            Coin selectedCoin = market.getCoins().get(coinTableIndex);
            double quantity = Double.parseDouble(buyingQuantityText);
            double value = quantity * selectedCoin.getStockValue();
            double creditsLeft = wallet.getCredits() - value;
            
            if (creditsLeft >= 0) {
                updateWallet(creditsLeft, new Coin(selectedCoin).setQuantity(quantity));

                jFormattedTextFieldBuyingQuantity.setText("");
                
                jLabelTotalValue.setText(currencyFormatter.format(wallet.getTotalValue()));
                
                updateCreditListenners();
                
                jTextFieldBuyingRealValue.setText("");
                
                GerenciadorDeUsuarios.getInstance().salvarUsuarioAtual();
                
                this.walletTableModel = new WalletTableModel(this.wallet.getCoins());
                jTableWalletCoins.setModel(walletTableModel);
                jComboBoxSaleCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(wallet.getCoins().stream().map(Coin::getName).toArray(String[]::new)));
                jComboBoxSaleCurrency.repaint();
                jTableWalletCoins.repaint();
                
                JOptionPane.showMessageDialog(null, "Compra realizada com sucesso.","Mensagem", JOptionPane.DEFAULT_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade selecionada maior que a dispinível na carteira para a moeda selecionada.","Aviso", JOptionPane.WARNING_MESSAGE);
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Para efetuar uma compra você deve informar uma moeda e a quantidade a ser comprada.","Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuyActionPerformed

    private void jRadioButtonWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWithdrawActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonWithdrawActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JButton jButtonSell;
    private javax.swing.JComboBox<String> jComboBoxBuyingCoin;
    private javax.swing.JComboBox<String> jComboBoxSaleCurrency;
    private javax.swing.JFormattedTextField jFormattedTextFieldBuyingQuantity;
    private javax.swing.JFormattedTextField jFormattedTextFieldSaleQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabelTotalCreditsForTransfer;
    private javax.swing.JLabel jLabelTotalCreditsMarket;
    private javax.swing.JLabel jLabelTotalValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelMarket;
    private javax.swing.JPanel jPanelTransfer;
    private javax.swing.JPanel jPanelWallet;
    private javax.swing.JRadioButton jRadioButtonDeposit;
    private javax.swing.JRadioButton jRadioButtonWithdraw;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMarketCoins;
    private javax.swing.JTable jTableWalletCoins;
    private javax.swing.JTextField jTextFieldBuyingRealValue;
    private javax.swing.JTextField jTextFieldSaleRealValue;
    private javax.swing.JTextField jTextFieldTransferAccount;
    private javax.swing.JTextField jTextFieldTransferValue;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controllers.ManageOrderController;
import gui.components.MenuItemGrid;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import entities.MenuItem;
import entities.OrderItem;

/**
 *
 * @author eric
 */
public final class OrderFrame extends javax.swing.JFrame {

    private ManageOrderController manageOrderController;
    
    public static final int QUANTITY_COL = 2;
    public static final int PRICE_COL = 1;
    public static final int NAME_COL = 0;
    public static final String QUANTITY_COL_STRING = "Quantity";
    public static final String PRICE_COL_STRING = "Price";
    public static final String NAME_COL_STRING = "Name";
    public static final String CURRENCY_PATTERN = "^\\$?[\\d]+(\\.\\d\\d)?$";
    
    /**
     * Creates new form Orders
     */
    public OrderFrame(ManageOrderController moc) {
        this.manageOrderController = moc;
        initComponents();
        initMenuItemComponent();
        configureTable();
        if (this.manageOrderController.isUpdating) {
            this.updateSummary();
            this.commentsTextArea.setText(this.manageOrderController.getComment());
            this.topButtonActionPerformed(null);
        }
    }
    
    private void configureTable() {
        this.orderItemsTable.setModel(this.manageOrderController.getTableModel());
                //name the tables columns
        TableColumnModel cm = this.orderItemsTable.getColumnModel();
        for (int colIndex = NAME_COL; colIndex <= QUANTITY_COL; colIndex++) {
            switch(colIndex) {
                case PRICE_COL:
                    cm.getColumn(PRICE_COL).setHeaderValue(PRICE_COL_STRING);
                    break;
                case NAME_COL:
                    cm.getColumn(NAME_COL).setHeaderValue(NAME_COL_STRING);
                    break;
                case QUANTITY_COL:
                    cm.getColumn(QUANTITY_COL).setHeaderValue(QUANTITY_COL_STRING);
                    break;
                default:
                    break;
                    
            }
        
        }

    }
    
    private void initMenuItemComponent() {
        this.menuItemsPanel = new MenuItemGrid( this.manageOrderController.getMenuItems(), this);
        this.add(this.menuItemsPanel);
    }
    
    
    public void updateSummary() {
        this.totalAmountLabel.setText(this.manageOrderController.getTotal());
        this.subtotalAmountLabel.setText(this.manageOrderController.getSubtotal());
        this.taxAmountLabel.setText(this.manageOrderController.getTax());
        this.tipAmountField.setText(this.manageOrderController.getTip());
    }
    
    private void setTip() {
        String tipAmountString = this.tipAmountField.getText();
        
        if ( tipAmountString.matches(CURRENCY_PATTERN)) {
            this.manageOrderController.setTip(tipAmountString.replaceFirst("\\$", ""));
            this.tipAmountField.setBorder(BorderFactory.createEmptyBorder());
        }
        else this.tipAmountField.setBorder(BorderFactory.createLineBorder(Color.red));
    }
        
    private void promptUserOfIncorrectOrder() {
        JOptionPane.showMessageDialog(this, "You may not submit an empty order.", "Empty Order", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        orderDetailsScrollPane = new javax.swing.JScrollPane();
        orderItemsTable = new javax.swing.JTable();
        removeButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        orderDetailLabel = new javax.swing.JLabel();
        menuItemsLabel = new javax.swing.JLabel();
        orderStatusPane = new javax.swing.JPanel();
        taxLabel = new javax.swing.JLabel();
        subtotalLabel = new javax.swing.JLabel();
        tipLabel = new javax.swing.JLabel();
        tipAmountField = new javax.swing.JTextField();
        subtotalAmountLabel = new javax.swing.JLabel();
        taxAmountLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        totalLabel = new javax.swing.JLabel();
        totalAmountLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        topButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        bottomButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order");

        orderItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        orderDetailsScrollPane.setViewportView(orderItemsTable);

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        orderDetailLabel.setFont(new java.awt.Font("Papyrus", 0, 24)); // NOI18N
        orderDetailLabel.setText("Order Detail");

        menuItemsLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        menuItemsLabel.setText("Select Menu Items");

        taxLabel.setText("Tax:");

        subtotalLabel.setText("Subtotal:");

        tipLabel.setText("Tip:");

        tipAmountField.setText("$0.00");
        tipAmountField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tipAmountFieldFocusLost(evt);
            }
        });

        subtotalAmountLabel.setText("$0.00");

        taxAmountLabel.setText("$0.00");

        jLabel1.setText("Comments:");

        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        jScrollPane1.setViewportView(commentsTextArea);

        totalLabel.setText("Total:");

        totalAmountLabel.setText("$0.00");

        org.jdesktop.layout.GroupLayout orderStatusPaneLayout = new org.jdesktop.layout.GroupLayout(orderStatusPane);
        orderStatusPane.setLayout(orderStatusPaneLayout);
        orderStatusPaneLayout.setHorizontalGroup(
            orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(orderStatusPaneLayout.createSequentialGroup()
                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(orderStatusPaneLayout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(orderStatusPaneLayout.createSequentialGroup()
                                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(subtotalLabel)
                                    .add(taxLabel))
                                .add(24, 24, 24)
                                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(subtotalAmountLabel)
                                    .add(taxAmountLabel)))
                            .add(orderStatusPaneLayout.createSequentialGroup()
                                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(tipLabel)
                                    .add(totalLabel))
                                .add(44, 44, 44)
                                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(totalAmountLabel)
                                    .add(tipAmountField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                    .add(orderStatusPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1))
                    .add(orderStatusPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 310, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orderStatusPaneLayout.setVerticalGroup(
            orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(orderStatusPaneLayout.createSequentialGroup()
                .add(8, 8, 8)
                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(subtotalLabel)
                    .add(subtotalAmountLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(taxLabel)
                    .add(taxAmountLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tipLabel)
                    .add(tipAmountField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(orderStatusPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(totalLabel)
                    .add(totalAmountLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 143, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        submitButton.setText("Submit Order");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });

        topButton.setText("Top");
        topButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topButtonActionPerformed(evt);
            }
        });

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        bottomButton.setText("Bottom");
        bottomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottomButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(bottomButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(downButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .add(upButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .add(topButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(topButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(upButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22)
                .add(downButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(bottomButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(removeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cancelButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(orderDetailsScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .add(orderStatusPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(360, 360, 360))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, submitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(layout.createSequentialGroup()
                                .add(113, 113, 113)
                                .add(orderDetailLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 316, Short.MAX_VALUE)
                                .add(menuItemsLabel)
                                .add(114, 114, 114))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(orderDetailLabel))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, menuItemsLabel))
                .add(2, 2, 2)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(removeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(orderDetailsScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(orderStatusPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(222, 222, 222)
                                .add(submitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void menuItemButtonActionPerformed( MouseEvent me, MenuItem item) {
        int toRow = this.manageOrderController.addOrderItem(new OrderItem(item));
        this.updateSummary();
        
        ListSelectionModel selectionModel = this.orderItemsTable.getSelectionModel();
        selectionModel.setSelectionInterval(toRow, toRow);
        this.orderItemsTable.setSelectionModel(selectionModel);
    }
    
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int initNumRows = this.orderItemsTable.getRowCount();
        int finalNumRows;
        int selectedRow = this.orderItemsTable.getSelectedRow();
        int toRow = 0;
        if ( selectedRow >= 0) {
            this.manageOrderController.removeOrderItem( this.orderItemsTable.getSelectedRow() );
            toRow = initNumRows!=this.orderItemsTable.getRowCount()? selectedRow - 1: selectedRow;
        }
        
        ListSelectionModel selectionModel = this.orderItemsTable.getSelectionModel();
        selectionModel.setSelectionInterval(toRow, toRow);
        this.orderItemsTable.setSelectionModel(selectionModel);
        
        this.updateSummary();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void tipAmountFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipAmountFieldFocusLost
        // TODO add your handling code here:
        this.setTip();
        this.updateSummary();
    }//GEN-LAST:event_tipAmountFieldFocusLost

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        // TODO add your handling code here:
        if (! this.manageOrderController.isValid()) promptUserOfIncorrectOrder();
        else {
            this.setTip();
            if (!this.manageOrderController.isUpdating) 
                this.manageOrderController.setInvoiceNumber((int)(Math.random() * 1000));
            this.manageOrderController.setComments(this.commentsTextArea.getText());
            this.manageOrderController.submit();
            this.setVisible(false);
            this.dispose();
        }
                
    }//GEN-LAST:event_submitButtonMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void topButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topButtonActionPerformed
        // TODO add your handling code here:
        ListSelectionModel selectionModel = this.orderItemsTable.getSelectionModel();
        selectionModel.setSelectionInterval(0, 0);
        this.orderItemsTable.setSelectionModel(selectionModel);
    }//GEN-LAST:event_topButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.orderItemsTable.getSelectedRow();
        int toRow = selectedRow>0? selectedRow - 1 : selectedRow;
        
        ListSelectionModel selectionModel = this.orderItemsTable.getSelectionModel();
        selectionModel.setSelectionInterval(toRow, toRow);
        this.orderItemsTable.setSelectionModel(selectionModel);
        
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.orderItemsTable.getSelectedRow();
        int toRow = selectedRow<this.orderItemsTable.getRowCount()-1? selectedRow + 1 : selectedRow;
        
        ListSelectionModel selectionModel = this.orderItemsTable.getSelectionModel();
        selectionModel.setSelectionInterval(toRow, toRow);
        this.orderItemsTable.setSelectionModel(selectionModel);
    }//GEN-LAST:event_downButtonActionPerformed

    private void bottomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottomButtonActionPerformed
        // TODO add your handling code here:
        int toRow = this.orderItemsTable.getRowCount()-1;
        
        ListSelectionModel selectionModel = this.orderItemsTable.getSelectionModel();
        selectionModel.setSelectionInterval(toRow, toRow);
        this.orderItemsTable.setSelectionModel(selectionModel);
    }//GEN-LAST:event_bottomButtonActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottomButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea commentsTextArea;
    private javax.swing.JButton downButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel menuItemsLabel;
    private javax.swing.JLabel orderDetailLabel;
    private javax.swing.JScrollPane orderDetailsScrollPane;
    private javax.swing.JTable orderItemsTable;
    private javax.swing.JPanel orderStatusPane;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel subtotalAmountLabel;
    private javax.swing.JLabel subtotalLabel;
    private javax.swing.JLabel taxAmountLabel;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JTextField tipAmountField;
    private javax.swing.JLabel tipLabel;
    private javax.swing.JButton topButton;
    private javax.swing.JLabel totalAmountLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
    private MenuItemGrid menuItemsPanel;

}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controllers.NavigationController;
import controllers.OrderController;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author eric
 */
public class Orders extends javax.swing.JFrame {

    private OrderController controller;
    private NavigationController navigation;
    
    public final static int INVOICE_COL = 0;
    public final static int TOTAL_COL = 1;
    public final static String INVOICE_COL_STRING = "Invoice Number";
    public final static String TOTAL_COL_STRING = "Total (USD)";
    
    /**
     * Creates new form Orders
     */
    public Orders( OrderController oc, NavigationController nc ) {
        this.controller = oc;
        this.navigation = nc;
        
        initComponents();
        configureTable();
        
        if ( this.ordersTable.getRowCount() > 0 ) {
            ListSelectionModel selectionModel = this.ordersTable.getSelectionModel();
            selectionModel.setSelectionInterval(0, 0);
            this.ordersTable.setSelectionModel(selectionModel);
        }
    }
    
    private void configureTable() {
        this.ordersTable.setModel(this.controller.getTableModel());
                //name the tables columns
        TableColumnModel cm = this.ordersTable.getColumnModel();
        for (int colIndex = INVOICE_COL; colIndex <= TOTAL_COL; colIndex++) {
            switch(colIndex) {
                case INVOICE_COL:
                    cm.getColumn(INVOICE_COL).setHeaderValue(INVOICE_COL_STRING);
                    break;
                case TOTAL_COL:
                    cm.getColumn(TOTAL_COL).setHeaderValue(TOTAL_COL_STRING);
                    break;
                default:
                    break;
                    
            }
        
        }

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        manageOrdersLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        makeOrderButton = new javax.swing.JButton();
        manageOrderButton = new javax.swing.JButton();
        removeOrderButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Orders");

        manageOrdersLabel.setFont(new java.awt.Font("Papyrus", 0, 24)); // NOI18N
        manageOrdersLabel.setText("Manage Orders");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ordersTable);

        makeOrderButton.setText("Make Order");
        makeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeOrderButtonActionPerformed(evt);
            }
        });

        manageOrderButton.setText("Manage Order");
        manageOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrderButtonActionPerformed(evt);
            }
        });

        removeOrderButton.setText("Remove Order");
        removeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOrderButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(jSeparator1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(backButton)
                        .add(81, 81, 81)
                        .add(manageOrdersLabel)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 64, Short.MAX_VALUE)
                .add(removeOrderButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(manageOrderButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(makeOrderButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(backButton)
                    .add(manageOrdersLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 388, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(makeOrderButton)
                    .add(manageOrderButton)
                    .add(removeOrderButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.navigation.back();
    }//GEN-LAST:event_backButtonActionPerformed

    private void makeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeOrderButtonActionPerformed
        // TODO add your handling code here:
        this.controller.showOrderFrame();
    }//GEN-LAST:event_makeOrderButtonActionPerformed

    private void removeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOrderButtonActionPerformed
        // TODO add your handling code here:
        this.controller.showDeleteOrderPrompt(this, this.ordersTable.getSelectedRow());
    }//GEN-LAST:event_removeOrderButtonActionPerformed

    private void manageOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrderButtonActionPerformed
        // TODO add your handling code here:
        this.controller.showOrderFrame( this.ordersTable.getSelectedRow() );
    }//GEN-LAST:event_manageOrderButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton makeOrderButton;
    private javax.swing.JButton manageOrderButton;
    private javax.swing.JLabel manageOrdersLabel;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton removeOrderButton;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import entities.Order;
import gui.Orders;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eric
 */
public class OrderTableModel extends AbstractTableModel {
    
    private LinkedList<Order> orders;
    
    public OrderTableModel( LinkedList<Order> items ) {
        this.orders = items;
    }

    @Override
    public int getRowCount() {
        return this.orders.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case Orders.INVOICE_COL:
                return String.valueOf(this.orders.get(i).getInvoiceNumber());
            case Orders.TOTAL_COL:
                return this.orders.get(i).getTotal().toString();
            default:
                return null;
        }
    }

    public Order getItemAt(int rowIndex) {
        
        return this.orders.get(rowIndex);
        
    }
    
}

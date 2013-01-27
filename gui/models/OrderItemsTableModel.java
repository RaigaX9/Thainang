/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import gui.OrderFrame;
import javax.swing.table.AbstractTableModel;
import entities.Order;
import entities.OrderItem;

/**
 *
 * @author eric
 */
public class OrderItemsTableModel extends AbstractTableModel {

    private Order order;
    
    public OrderItemsTableModel( Order order ) {
        this.order = order;
    }
    
    @Override
    public int getRowCount() {
        return this.order.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1) {
            case OrderFrame.PRICE_COL:
                return this.order.itemAt(i).getPrice().toString();
            case OrderFrame.NAME_COL:
                return this.order.itemAt(i).getName();
            case OrderFrame.QUANTITY_COL:
                return "X"+this.order.itemAt(i).getQuantity();
            default:
                break;
        }
        return null;
    }
    
    public OrderItem getItemAtRow(int row ) {
        return this.order.itemAt(row);
    }

    public int getRowAtItem(OrderItem item) {
        return this.order.indexOf(item.getName());
    }
    
}

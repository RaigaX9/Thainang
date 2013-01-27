/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.MenuItem;
import entities.Order;
import entities.OrderItem;
import gui.OrderFrame;
import gui.models.OrderTableModel;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nishad
 */
public class OrderController extends Controller {
    
    private LinkedList<Order> orders;
    private OrderTableModel ordersTableModel;
    private OrderFrame orderDialog;
    private Order selectedItem;
    
    /**Constructor method */
    public OrderController(){
        this.data.open(Order.class);
        this.data.open(OrderItem.class);
        this.data.open(MenuItem.class);
        
        this.orders = new LinkedList(this.data.readAll(Order.class));
    }
    
    public OrderTableModel getTableModel() {
        return this.ordersTableModel = new OrderTableModel( this.orders );
    }   
        
    /** This will create a dialog box that will allow the user to make an order */
    public void showOrderFrame() { 
        this.orderDialog = new OrderFrame( new ManageOrderController( new Order(), this ));
        this.orderDialog.setVisible(true);
        this.orderDialog.pack();
    }
    
    public void showOrderFrame(int rowIndex) {
        this.orderDialog = new OrderFrame( new ManageOrderController( this.ordersTableModel.getItemAt(rowIndex), this));
        this.orderDialog.setVisible(true);
        this.orderDialog.pack();
    }
    
        /** This will give you a dialog box whether or not to delete a order */
    public void showDeleteOrderPrompt(JFrame parent, int rowIndex ) {
        this.selectedItem = this.ordersTableModel.getItemAt(rowIndex);
        
        int optionChosen = JOptionPane.showConfirmDialog(
                parent, 
                "Would you like to delete this item? The item will be irretrievable upon clicking \"yes\".", 
                "Delete invoice #"+this.selectedItem.getInvoiceNumber(), 
                JOptionPane.YES_NO_OPTION
                );
        
        if (optionChosen == JOptionPane.YES_OPTION) {
            this.deleteItem();
        }        
    }    
    
    public void addItem( Order order ) {
        this.orders.add(order);
        this.ordersTableModel.fireTableDataChanged();
    }
    
    private void deleteItem() {
        //commit delete
        this.data.remove(this.selectedItem);
        this.data.commit();
        this.orders.remove(this.selectedItem);
        //refresh changes to the table.
        this.ordersTableModel.fireTableDataChanged();
    }
    
    
    
    
    
}

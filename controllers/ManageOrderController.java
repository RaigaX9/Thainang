/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.MenuItem;
import entities.Order;
import entities.OrderItem;
import gui.models.OrderItemsTableModel;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

/**
 *
 * @author eric
 */
public class ManageOrderController extends Controller {
    
    private Order order;
    private OrderController parentController;
    private OrderItemsTableModel tableModel;
    private LinkedList<MenuItem> menuItems = null;
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    public boolean isUpdating = false;
    
    public ManageOrderController(Order order, OrderController parentController) {
        this.data = parentController.data;
        
        this.order = order;
        this.parentController = parentController;
        this.menuItems = new LinkedList(this.data.readAll(MenuItem.class));
        isUpdating = !this.order.isEmpty();
    }
    
    public void submit() {
        if (this.isUpdating) this.data.update(this.order);
        else {
            this.data.create(this.order);
            this.parentController.addItem(this.order);
        }
        this.data.commit();
    }
    
    public OrderItemsTableModel getTableModel() {
        return this.tableModel = new OrderItemsTableModel( this.order );
    }
 
    public LinkedList<MenuItem> getMenuItems() {
        return this.menuItems;
    }
    
    public int addOrderItem( OrderItem item ) {
        
        int index = this.order.indexOf(item.getName());
        if ( index == -1) this.order.add(item);
        else {
            this.order.itemAt(index).incrementQuantity();
        }
        this.tableModel.fireTableDataChanged();
        
        return this.tableModel.getRowAtItem(item);
        
    }
    
    public void removeOrderItem( int rowIndex ) {
        OrderItem selectedItem = this.tableModel.getItemAtRow(rowIndex);
        if ( selectedItem.getQuantity() == 1 ) {
            this.order.remove(selectedItem);
        }
        else {
            selectedItem.decrementQuantity();
        }
        this.tableModel.fireTableDataChanged();
    }
    
    public String getSubtotal() {
        return currencyFormat.format(this.order.getSubtotal());
    }
    
    public String getTotal() {
        return currencyFormat.format(this.order.getTotal());
    }
    
    public String getTax() {
        return currencyFormat.format(this.order.getTax());
    }
    
    public String getTip() {
        return currencyFormat.format(this.order.getTip());
    }
    
    public String getComment() {
        return this.order.getComment();
    }
    
    public void setTip( String tip ) {
        this.order.setTip(new BigDecimal(Double.parseDouble(tip)));
    }
    
    public void setComments( String comments ) {
        this.order.setComment(comments);
    }
    
    public void setInvoiceNumber( int invoiceNumber ) {
        this.order.setInvoiceNumber(invoiceNumber);
    }
    
    public boolean isValid() {
        return !this.order.isEmpty();
    }
        
}

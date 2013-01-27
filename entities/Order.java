/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author eric
 */
public class Order extends DataModel implements Collection {
    //RECORD
    //ORDER DELEGATES TO LINKED LIST ITEMS.
    private ArrayList<OrderItem> items = new ArrayList<OrderItem>();
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal tax = BigDecimal.ZERO;
    private BigDecimal tip = BigDecimal.ZERO;
    private String comment;
    private int invoiceNumber;
    
    private static final BigDecimal TAX_RATE = new BigDecimal(.08);
    
    //GETTERS
    
    /**Gets the items contained in the order */
    public ArrayList<OrderItem> getItems() {
        return this.items;
    }  
    
    public BigDecimal getSubtotal() {

        this.subtotal = BigDecimal.ZERO;
        for ( OrderItem item : this.items ) {
            this.subtotal = this.subtotal.add(item.getPrice());
        }

        return this.subtotal.setScale(2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getTax() {
        return this.tax = this.getSubtotal().multiply(TAX_RATE).setScale(2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getTip() {
        return this.tip.setScale(2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getTotal() {
        if (this.tip.equals(BigDecimal.ZERO)) return this.total = this.getSubtotal().add(this.getTax()).setScale(2, RoundingMode.HALF_UP);
        return this.getSubtotal().add(this.getTax()).add(this.getTip()).setScale(2, RoundingMode.HALF_UP);
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public int getInvoiceNumber() {
        return this.invoiceNumber;
    }
    
    public OrderItem itemAt( int i ) {
        return this.items.get(i);
    }
     
    public int indexOf( String name ) {
        
        for (int i=0; i<this.size(); i++) {
            if (this.items.get(i).getName().equals(name)) return i;
        }
        
        return -1;
    }
    
    //SETTERS
    
    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }
    
    
    public void setSubtotal( BigDecimal subtotal ) {
        this.subtotal = subtotal;
    }
    
    /**Sets the total amount*/
    public void setTotal( BigDecimal total ) {
        this.total = total;
    }
    
    /**Sets the tax amount*/
    public void setTax( BigDecimal tax ) {
        this.tax = tax;
    }
    
    /**Sets the tip amount*/
    public void setTip( BigDecimal tip ) {
        this.tip = tip;
    }
    
    /**Sets the comment*/
    public void setComment( String comment ) {
        this.comment = comment;
    }
    
    /**Sets invoice number */
    public void setInvoiceNumber(int invoiceNumber){
        this.invoiceNumber = invoiceNumber;
    }    
    
    /*
     * COLLECTION INTERFACE
     */
    
    @Override
    public int size() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.items.contains( (OrderItem)o );
    }
    
    public boolean contains(String name) {
        for (OrderItem item : this.items) {
            if (item.getName().equals(name)) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return this.items.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.items.toArray();
    }

    @Override
    public Object[] toArray(Object[] ts) {
        return this.items.toArray( (OrderItem[]) ts);
    }

    @Override
    public boolean add(Object e) {        
        return this.items.add( (OrderItem) e );
    }

    @Override
    public boolean remove(Object o) {
        return this.items.remove( (OrderItem)o );
    }

    @Override
    public boolean containsAll(Collection clctn) {
        return this.items.containsAll( (LinkedList<OrderItem>) clctn);
    }

    @Override
    public boolean addAll(Collection clctn) {
        return this.items.addAll( (LinkedList<OrderItem>) clctn );
    }

    @Override
    public boolean removeAll(Collection clctn) {
        return this.items.removeAll( (LinkedList<OrderItem>) clctn );
    }

    @Override
    public boolean retainAll(Collection clctn) {
        return this.items.retainAll( (LinkedList<OrderItem>) clctn );
    }

    @Override
    public void clear() {
        this.items.clear();
    }
    
    @Override
    public Class getCollectionClass() {
        return (new OrderItem()).getClass();
    }
    
    
}

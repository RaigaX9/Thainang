/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;

/**
 *
 * @author Nishad
 */
public class OrderItem extends MenuItem {
    //RECORD
    private int quantity = 1;
    private int menuItemId;
    
    public OrderItem() {
        
    }
    
    public OrderItem( MenuItem item ) {
        this.setName(item.getName());
        this.setPrice(item.getPrice());
        this.setDescription(item.getDescription());
        this.setMenuItemId(item.getId());
        //this.setId(item.getId());
    }
    
    public int getMenuItemId() {
        return this.menuItemId;
    }
    
    /** Gets quantity */
    public int getQuantity(){
        return this.quantity;
    }
    
    @Override
    public BigDecimal getPrice() {
        return super.getPrice().multiply( new BigDecimal(this.quantity));
    }
        
    /** Sets quantity */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setMenuItemId(int id) {
        this.menuItemId = id;
    }
    
    public void incrementQuantity() {
        this.quantity++;
    }
    
    public void decrementQuantity() {
        this.quantity--;
    }
    
}

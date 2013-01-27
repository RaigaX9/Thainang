/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;

/**
 * This class represents the entity, Menu Item. A menu item may be any of the 
 * items on the restaurant's menu.
 * 
 * 
 * @author eric
 */
public class MenuItem extends DataModel {
    //RECORD
    private String name;
    private BigDecimal price;
    private String description;
    
    //GETTERS
    /**
     * <p>
     * Returns the name of the menu item.
     * </p>
     * @return String value representing the name of the item.
     * @see String
     * 
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * <p>
     * Returns the decimal price of the menu item.
     * </p>
     * @return Decimal value representing the name of the item.
     * @see BigDecimal
     * 
     */
    public BigDecimal getPrice() {
        return this.price;
    }
    
    /**
     * <p>
     * Returns the description of the menu item.
     * </p>
     * @return String value representing the description of the item.
     * @see String
     * 
     */
    public String getDescription() {
        return this.description;
    }
    
    //SETTERS
    /**
     * <p>
     * Sets the name of the menu item.
     * </p>
     * @param name an instance of {@link String}
     * @see String
     * 
     */
    public void setName( String name ) {
        this.name = name;
    }
    
    /**
     * <p>
     * Sets the price of the menu item.
     * </p>
     * @param price an instance of {@link BigDecimal}
     * @see BigDecimal
     * 
     */
    public void setPrice( BigDecimal price ) {
        this.price = price;
    }
    
    /**
     * <p>
     * Sets the description of the menu item.
     * </p>
     * @param description an instance of {@link String}
     * @see String
     * 
     */
    public void setDescription( String description ) {
        this.description = description;
    }
        
}

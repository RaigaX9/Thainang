package gui.models;

import gui.Menu;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import entities.MenuItem;

/**
 * The Menu Table Model inherits functionality from javax.swing.table.AbstractTableModel. 
 * This table model stores a reference to a linked list of menu items. When 
 * javax.swing.table calls the {@link #getValueAt(int, int) getValueAt( row, col )}, 
 * the appropriate cell in the table will have a value appropriate to it's row 
 * and column. An instance of this model is provided to {@link Table}.
 * 
 * @author eric
 */

public class MenuTableModel extends AbstractTableModel {

    final String PRICE = "price";
    static final int PRICE_ROW = 0;
    final String NAME = "name";
    static final int NAME_ROW = 1;
    
    private LinkedList<MenuItem> items;
    
    /**
     * Constructs a table model provided a linked list of models ({@MenuItem}). 
     * This linked list will function as the data, and each element will function 
     * as a row, while each property of the element will correspond to a respective 
     * column.
     * @param menuItems an instance of LinkedList&lt;{@link MenuItem}&gt;
     */
    public MenuTableModel( LinkedList<MenuItem> menuItems ) {
        this.items = menuItems;
                
    }
    
    /**
     * Returns an integer value representing the number of rows the table needs 
     * to generate. This number of rows corresponds to the size the linked list
     * provided to the constructor.
     * @return int value representing the row count.
     */
    @Override
    public int getRowCount() {
        return this.items.size()>0? this.items.size() : 0;
    }
    /**
     * Returns an integer value representing the number of columns the table needs 
     * to generate. This number of rows corresponds to the number of fields of 
     * the entity.
     * @return int value representing the column count.
     */
    @Override
    public int getColumnCount() {
        return 3;
        //return this.items.size()>0?
          //      this.items.get(0).getClass().getDeclaredFields().length : 0;
    }

    /**
     * Returns the string value of the cell that corresponds the specified row 
     * and column.
     * @param row
     * @param col
     * @return 
     */
    @Override
    public Object getValueAt(int row, int col) {
        
        String string = "";
        
        try {
            MenuItem item = this.items.get(row);
            switch (col) {
                
                case Menu.PRICE_COL:
                    return item.getPrice().toString();
                case Menu.NAME_COL:
                    return item.getName();
                case Menu.DESCRIPTION_COL:
                    return item.getDescription();
                default:
                    break;
            
                
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MenuTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MenuTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    /**
     * Returns the item instance represented by a specific row in a table.
     * @param row
     * @return a menu item
     */
    public MenuItem getItemAt( int row ) {        
        return this.items.get(row);

    }
    
    
    
}

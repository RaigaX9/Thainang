/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gui.MenuItemDialog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import entities.MenuItem;
import gui.models.MenuTableModel;

/**
 *
 * @author eric
 */
public class MenuController extends Controller {
    
    private LinkedList<MenuItem> items;
    private MenuItemDialog itemDialog;
    private MenuTableModel tableModel;
    private MenuItem selectedItem;
    
    /**Constructor method */
    public MenuController() {

        this.data.open(MenuItem.class);

        this.items = new LinkedList((ArrayList<MenuItem>) this.data.readAll(MenuItem.class));
                
    }
    
    /**Uses the Table Model to set up a list of menu items */
    public MenuTableModel getTableModel() {
        return this.tableModel = new MenuTableModel( this.items );
    }
        
    /** This will create a pop-up that will allow the user to make menu items */
    public void showMenuItemDialog( JFrame parent, int rowIndex ) {
        //PRECONDITION
        /*assert item.name != null &&
                item.price != null &&
                item.description != null;*/
        //END PRECONDITION
        
        this.selectedItem = this.tableModel.getItemAt(rowIndex);
        //create a menuItemDialog with intent to update item.
        this.itemDialog = new MenuItemDialog( parent, this, true, true );
        this.itemDialog.populateFields(this.selectedItem);
        this.itemDialog.setVisible(true);
        
    }
    
    /** This will give you a dialog box that will allow the user to make menu items */
    public void showMenuItemDialog( JFrame parent ) {
        //create a menuItemDialog with intent to create item.
        this.itemDialog = new MenuItemDialog( parent, this, true, false );
        this.itemDialog.setVisible(true);
        
    }
    
    /** This will give you a dialog box whether or not to delete a menu item */
    public void showDeleteMenuItemPrompt( JFrame parent, int rowIndex ) {

        selectedItem = this.tableModel.getItemAt(rowIndex);
        
        int optionChosen = JOptionPane.showConfirmDialog(
                parent, 
                "Would you like to delete this item? The item will be irretrievable upon clicking \"yes\".", 
                "Delete "+this.selectedItem.getName(), 
                JOptionPane.YES_NO_OPTION
                );
        
        if (optionChosen == JOptionPane.YES_OPTION) {
            this.deleteItem();
        }        
        
    }
    
    /** This will cancel the dialog box */
    public void cancelMenuItemDialog() {
        
        this.itemDialog.dispose();
        
    }

    /** This will create a menu item */
    public void createItem( String name, String price, String description ) {
        try {
            
            MenuItem newItem = new MenuItem();
            
            newItem.setName(name);
            newItem.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
            newItem.setDescription(description);
            
            this.data.create(newItem);
            this.data.commit();
            
            //add new item to items array
            this.items.add(newItem);
            //update table contents (sends event to model to update using updated array data source)
            this.tableModel.fireTableDataChanged();
            //dispose of the dialog.
            this.itemDialog.dispose();
            
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /** This will update the menu item */
    public void updateItem( String name, String price, String description ) {
        
        this.selectedItem.setName(name);
        this.selectedItem.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
        this.selectedItem.setDescription(description);
        
        this.data.update(this.selectedItem);
        this.data.commit();
                
        //update the items linked list by replacing the old item with the updated one.
        int indexOfUpdatedItem = this.items.indexOf(this.selectedItem);
        this.items.set(indexOfUpdatedItem, this.selectedItem);
        //refresh changes to the table.
        this.tableModel.fireTableDataChanged();
        //dispose of the update item dialog.
        this.itemDialog.dispose();
    }
    
    /** This will delete the menu item */
    public void deleteItem() {
        //commit delete
        this.data.softRemove(this.selectedItem);
        this.data.commit();
        //this.persistor.close(this.selectedItem);
        //update the items linked list by removing the item.
        this.items.remove(this.selectedItem);
        //refresh changes to the table.
        this.tableModel.fireTableDataChanged();
    }
    
}

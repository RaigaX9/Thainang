/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gui.ReservationDialog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import entities.Reservation;
import gui.models.ReservationTableModel;
/**
 *
 * @author Nishad
 */
public class ReservationController extends Controller {
    private LinkedList<Reservation> items;
    private ReservationDialog itemDialog;
    private ReservationTableModel tableModel;
    private Reservation selectedItem;
    
    /**Constructor method */
    public ReservationController(){
        this.data.open(Reservation.class);
        this.items = new LinkedList((ArrayList<Reservation>) this.data.readAll(Reservation.class));
    }
    
    /**Uses the Table Model to set up a list of menu items */
    public ReservationTableModel getTableModel() {
        return this.tableModel = new ReservationTableModel( this.items );
    }
    
    /** This will create a dialog box that will allow the user to make reservations */
    public void showReservationDialog( JFrame parent, int rowIndex ) {
        //PRECONDITION
        /*assert item.name != null &&
                item.price != null &&
                item.description != null;*/
        //END PRECONDITION
        
        this.selectedItem = this.tableModel.getItemAt(rowIndex);
        //create a ReservationDialog with intent to update item.
        this.itemDialog = new ReservationDialog( parent, this, true, true );
        this.itemDialog.populateFields(this.selectedItem);
        this.itemDialog.setVisible(true);
    
    }
    
    /** This will give you a dialog box that will allow the user to make reservation */
    public void showReservationDialog( JFrame parent ) {
        //create a menuItemDialog with intent to create item.
        this.itemDialog = new ReservationDialog( parent, this, true, false );
        this.itemDialog.setVisible(true);
        
    }
    
    /** This will give you a dialog box whether or not to delete a reservation */
    public void showDeleteReservationPrompt( JFrame parent, int rowIndex ) {
                selectedItem = this.tableModel.getItemAt(rowIndex);
        
        int optionChosen = JOptionPane.showConfirmDialog(
                parent, 
                "Would you like to delete this reservation? The reservation will be irretrievable upon clicking \"yes\".", 
                "Delete "+this.selectedItem.getGroupName(), 
                JOptionPane.YES_NO_OPTION
                );
        
        if (optionChosen == JOptionPane.YES_OPTION) {
            this.deleteReservation();
        }        
        
    }
    
    /** This will cancel the dialog box */
    public void cancelReservationDialog() {
        this.itemDialog.dispose();
        
    }
    
    /** This will create a reservation */
    public void createReservation(String groupName, String numberOfPeople, String date, String time) {
        try {
            
            Reservation newItem = new Reservation();
            

            newItem.setGroupName(groupName);
            newItem.setNumberOfPeople(numberOfPeople);
            newItem.setDate(date);
            newItem.setTime(time);
            
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
    
    /** This will update the reservation */

    public void updateReservation(String groupName, String numberOfPeople, String date, String time) {
        this.selectedItem.setGroupName(groupName);
        this.selectedItem.setNumberOfPeople(numberOfPeople);
        this.selectedItem.setDate(date);
        this.selectedItem.setTime(time);
        
        this.data.update(this.selectedItem);
        this.data.commit();
                
        //update the reservations linked list by replacing the old item with the updated one.
        int indexOfUpdatedItem = this.items.indexOf(this.selectedItem);
        this.items.set(indexOfUpdatedItem, this.selectedItem);
        //refresh changes to the table.
        this.tableModel.fireTableDataChanged();
        //dispose of the update reservation dialog.
        this.itemDialog.dispose();
        
    }
    
    /** This will delete a reservation */
    public void deleteReservation() {
        //commit delete
        this.data.remove(this.selectedItem);
        this.data.commit();
        //this.persistor.close(this.selectedItem);
        //update the items linked list by removing the item.
        this.items.remove(this.selectedItem);
        //refresh changes to the table.
        this.tableModel.fireTableDataChanged();
        
    }
}

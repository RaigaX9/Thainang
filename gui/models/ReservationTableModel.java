/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.models;

import gui.Reservations;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import java.util.Date;
import entities.Reservation;

/**
 * The Reservation Table Model inherits functionality from javax.swing.table.AbstractTableModel. 
 * This table model stores a reference to a linked list of reservations. When 
 * javax.swing.table calls the {@link #getValueAt(int, int) getValueAt( row, col )}, 
 * the appropriate cell in the table will have a value appropriate to it's row 
 * and column. An instance of this model is provided to {@link Table}.
 * 
 * @author Nishad Shah
 */
public class ReservationTableModel extends AbstractTableModel{
    final String GROUP = "group's name";
    final String NUM_OF_PEOPLE = "0";
    final String DATE_RESERVE = "date";
    final String TIME_RESERVE = "time";
    
    private LinkedList<Reservation> reserves;
    
     /**
     * Constructs a table model provided a linked list of models ({@ReservationItem}). 
     * This linked list will function as the data, and each element will function 
     * as a row, while each property of the element will correspond to a respective 
     * column.
     * @param reserveItems an instance of LinkedList&lt;{@link ReservationItem}&gt;
     */
    
    public ReservationTableModel(LinkedList<Reservation> reserveItems){
        this.reserves = reserveItems;
    }
      /**
     * Returns an integer value representing the number of rows the table needs 
     * to generate. This number of rows corresponds to the size the linked list
     * provided to the constructor.
     * @return int value representing the row count.
     */
    @Override
    public int getRowCount() {
        return this.reserves.size()>0? this.reserves.size() : 0;
    }
    /**
     * Returns an integer value representing the number of columns the table needs 
     * to generate. This number of rows corresponds to the number of fields of 
     * the entity.
     * @return int value representing the column count.
     */
    @Override
    public int getColumnCount() {
        return 4;
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
            Reservation reserves = this.reserves.get(row);
            switch (col) {
                
                case Reservations.GROUP_COL:
                    return reserves.getGroupName().toString();
                case Reservations.NUMBER_COL:
                    return reserves.getNumberOfPeople();
                case Reservations.DATE_COL:
                    return reserves.getDate();
                case Reservations.TIME_COL:
                    return reserves.getTime();
                default:
                    break;
            
                
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReservationTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReservationTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
   /**
   * Returns the item instance represented by a specific row in a table.
   * @param row
   * @return a menu item
   */
   public Reservation getItemAt( int row ) {        
        return this.reserves.get(row);

    }
    
}

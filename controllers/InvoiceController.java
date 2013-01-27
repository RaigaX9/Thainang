/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nishad
 */
public class InvoiceController extends Controller {
    
    /**Constructor method */
    public InvoiceController(){
    
    }
    
    /** This will create a pop-up that will allow the user to make the invoice */
    public void showInvoiceDialog(JFrame parent, int rowIndex ) {
    
    }
    
    /** This will give you a dialog box whether or not to delete the invoice */
    public void showDeleteInvoicePrompt(JFrame parent, int rowIndex ) {
    }
    
    /** This will cancel the dialog box */
    public void cancelInvoiceDialog() {
        
    }
    
    /** This will create the invoice */
    public void createInvoice(String menuItems, int quantity, double subtotal, double tax, double tip, String comments) {
        
    }
    
    /** This will update the invoice */
    public void updateInvoice(String menuItems, int quantity, double subtotal, double tax, double tip, String comments) {
        
    }
    
    /** This will delete a invoice */
    public void deleteInvoice() {
        
    }
    
}

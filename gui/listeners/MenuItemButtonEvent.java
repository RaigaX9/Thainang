/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.listeners;

import gui.OrderFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import entities.MenuItem;

/**
 *
 * @author eric
 */
public class MenuItemButtonEvent implements MouseListener {
    
    private MenuItem item;

    public MenuItemButtonEvent( MenuItem item ) {
    
        this.item = item;
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        ((OrderFrame)((Component)me.getSource()).getParent().getParent().getParent().getParent().getParent()).menuItemButtonActionPerformed(me, this.item);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components;

import entities.MenuItem;
import gui.listeners.MenuItemButtonEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author eric
 */
public class MenuItemGrid extends JPanel {

    private LinkedList<MenuItem> items;
    
    public final int HEIGHT;
    public final int WIDTH;
    public final int X;
    public final int Y;
    private static final int COL_COUNT = 3;
    private static final int ITEM_WIDTH = 90;
    private static final int ITEM_HEIGHT = 45;
    private static final int ITEM_LEFT_PADDING = 20;
    private static final int ITEM_TOP_PADDING = 20;
        
    public MenuItemGrid( LinkedList<MenuItem> menuItems, Component parent ) {
        super();
        
        this.items = menuItems;
        
        this.WIDTH = 350;
        this.HEIGHT = (this.items.size() / COL_COUNT + 1) * ITEM_HEIGHT;      
        this.setSize(WIDTH, HEIGHT);
        
        this.X = parent.getWidth()-WIDTH-10;
        this.Y = 80;
        this.setLocation(X, Y);
        
        this.populateGrid();
    }

    public MenuItem itemAt( int row, int col) {
        return this.items.get( (row * COL_COUNT) + col);
    }
    
    @Override
    public Color getBackground() {
        return Color.WHITE;
    }
    
    private void populateGrid() {
        
        GridLayout layout = new GridLayout( this.items.size() / COL_COUNT + 1, COL_COUNT);
        
        this.setLayout(layout);
        
        for ( MenuItem item : this.items ) {
            
            JButton gridButton = new JButton(item.getName());
            gridButton.setPreferredSize(new Dimension(ITEM_WIDTH, ITEM_HEIGHT));
            gridButton.addMouseListener(new MenuItemButtonEvent(item));
            this.add(gridButton);
        }
        
    }
    
    
/*
    @Override
    public Point getLocation() {
        Component parent = this.getParent();
        Point position = new Point();
        
        position.setLocation(parent.getWidth()-10, parent.getHeight()-10);
        
        return position;
    }*/
    
   
    
    

    
    
}
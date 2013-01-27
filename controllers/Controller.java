/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.XMLPersister;

/**
 * This class is abstract and shall be extended by all functional controllers 
 * that represent use cases of this application.
 * @author eric
 */
public abstract class Controller {
    
    public XMLPersister data;
    
    public Controller() {
        this.data = new XMLPersister();

    }
    
}

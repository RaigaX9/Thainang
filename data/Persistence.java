/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entities.DataModel;

/**
 *
 * @author eric
 */
public interface Persistence {
    
    public boolean open( Class model );
    public boolean close( Class model );
    public boolean closeAll();
    public void setFilter( Class model, String fieldName, String expression );
    public boolean read( DataModel model, int recordNumber );
    public boolean create( DataModel model );
    public boolean update( DataModel model );
    public boolean remove( DataModel model );
    
}

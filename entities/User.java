/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ejames788
 */
public class User extends DataModel {
    
    private String username;
    private String password;
    private boolean isAdmin;
        
    
    /** Gets username */
    public String getUsername() {
        return this.username;
    }
    
    /** Gets password */
    public String getPassword() {
        return this.password;
    }
    
    /** Gets if the user logged in is an administrator */
    public boolean getIsAdmin() {
        return this.isAdmin;
    }
    
    /** Sets username */
    public void setUsername( String username ) {
        this.username = username;
    }
    
    /** Sets password */
    public void setPassword( String password ) {
        this.password = password;
    }
    
    /** Sets the program if the user logged in is an administrator */
    public void setIsAdmin( boolean isAdmin ) {
        this.isAdmin = isAdmin;
    }
}

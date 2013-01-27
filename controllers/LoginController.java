/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import entities.User;

/**
 * The login controller provides login logic to the application.
 * @author ejames788
 */
public class LoginController extends Controller {
    
    private User model;
    private boolean isLoggedIn = false;
    
    /**
     * Creates a new instance of LoginController.
     */
    public LoginController() {
    }
    
    /**
     * Returns a boolean indicating whether the provided user credentials allowed 
     * the user to login to the system.
     * @param username
     * @param password
     * @return boolean representing the successfulness of logging in.
     */
    public boolean login(String username, String password) {
        
        ArrayList<User> usersFound;
                
        this.data.open(User.class);
        
        this.data.setFilter(User.class, "username", username);
        this.data.setFilter(User.class, "password", password);
        //FIND USER WITH SPECIFIED USERNAME AND PASSWORD.
        usersFound = (ArrayList<User>) this.data.readAll( User.class );
        
        if ( usersFound.size() == 1 ) {
            this.model = usersFound.get(0);
            this.isLoggedIn = true;
        }
        else usersFound.clear();
                
        this.data.close(User.class);
                
        return this.isLoggedIn;
        
    }
    
    /**
     * Returns the current logged user of the system.
     * @return an instance of the User entity with the current logged user's attributes. 
     */
    public User getLoggedUser() {
        if ( this.isLoggedIn ) {
            this.model.setPassword(null);
            return this.model;
        }
        else return null;
    }
    
    /**
     * Logs the current user out of the system.
     */
    public void logout() {
        this.model = null;
        this.isLoggedIn = false;
    }
        
}

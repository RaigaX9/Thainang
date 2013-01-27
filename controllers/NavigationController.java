/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gui.Home;
import gui.Login;
import gui.MainPage;
import gui.Menu;
import gui.Orders;
import gui.Reservations;
import java.util.Stack;
import javax.swing.JFrame;
import entities.User;

/**
 *
 * @author CurryTeers
 */
public class NavigationController {
    
    //Navigation Logic for Forward/Back
    private Stack<JFrame> navigationStack = new Stack<JFrame>();
    
    //Home Page Instances
    private Home homeFrame;
    //Login Instances
    private Login loginFrame;
    private User loggedUser;
    //Main Page Instances
    private MainPage mainMenu;
    //Restaurant Menu
    private Menu menu;
    //Restaurant Reservation System
    private Reservations reservations;
    //Orders System
    private Orders orders;
    
    /**Launches the login frame when the program is executed */
    public void launchApp() {
        
        this.homeFrame = new Home(this);
        this.homeFrame.setVisible(true);
        
        this.navigationStack.push(homeFrame);
        
        /*this.loginFrame = new Login( new LoginController(), this );
        this.loginFrame.setVisible(true);
        
        this.navigationStack.push(loginFrame);*/
        
        
    }
    
    /**Launch login frame after pressing the start button from the home frame */
    public void launchLogin(){
        this.navigationStack.peek().setVisible(false);
        this.navigationStack.peek().dispose();
        
        this.loginFrame = new Login(new LoginController(), this);
        this.loginFrame.setVisible(true);
        this.navigationStack.push(this.loginFrame);
    }
    
    /**Launches the main menu frame after logging in */
    public void launchMainMenu( User user ) {
        
        this.loggedUser = user;
        this.navigationStack.pop().dispose();
        this.mainMenu = new MainPage( this );
        if (! this.loggedUser.getIsAdmin() ) {
            this.mainMenu.hideAdminFunctions();
        }
        this.mainMenu.setVisible(true);
        this.navigationStack.push(mainMenu);
        
    }
    
    /**Launches the Menu frame when the "Menu" button is clicked */
    public void launchMenu() {
        
        this.navigationStack.peek().setVisible(false);
        this.navigationStack.peek().dispose();
        this.menu = new Menu( new MenuController(), this );
        if (! this.loggedUser.getIsAdmin() ) {
            this.menu.hideAdminFunctions();
        }
        this.menu.setVisible(true);
        
        this.navigationStack.push(this.menu);
        
    }
    
    /**Launches the Order frame when the "Order" button is clicked */
    public void launchOrders() {
        
        this.navigationStack.peek().setVisible(false);
        this.navigationStack.peek().dispose();
        this.orders = new Orders( new OrderController(), this );
        this.orders.setVisible(true);
        this.navigationStack.push(this.orders);
        
    }
        
    /**Launches the Reservation frame when the "Reservation" button is clicked */
    public void launchReservations() {
        
        this.navigationStack.peek().setVisible(false);
        this.navigationStack.peek().dispose();
        this.reservations = new Reservations( new ReservationController(), this );
        this.reservations.setVisible(true);
        this.navigationStack.push(this.reservations);
        
    }
    
    /**Navigates back to the main menu */
    public void back() {
        this.navigationStack.peek().dispose();
        this.navigationStack.pop().setVisible(false);
        this.navigationStack.peek().pack();
        this.navigationStack.peek().setVisible(true);
    }
        
    /**Logs out from the current session and goes back to the login frame */
    public void logout() {
        
        this.navigationStack.peek().dispose();
        this.navigationStack.removeAllElements();
        this.loggedUser = null;
        this.launchApp();
        
    }
    
}

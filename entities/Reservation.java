/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigDecimal;
import java.util.Date;
/**
 * This class represents the entity, Reservation Item. A reservation item may be any of the 
 * items on the restaurant's reservations.
 * @author Nishad Shah
 */
public class Reservation extends DataModel {
    
    //RECORD
    private String groupName;
    private String numberOfPeople;
    private String date;
    private String time;
    
    //GETTERS
    /**
     * <p>
     * Returns the name of the group.
     * </p>
     * @return String value representing the name of the group.
     * @see String
     * 
     */
    public String getGroupName() {
        return this.groupName;
    }
    
        /**
     * <p>
     * Returns the number of people in the group.
     * </p>
     * @return int value representing the name of the group.
     * @see int
     * 
     */
    public String getNumberOfPeople(){
        return this.numberOfPeople;
    }
    
        /**
     * <p>
     * Returns the date.
     * </p>
     * @return Date type representing the name of the group.
     * @see Date
     * 
     */
    public String getDate(){
        return this.date;
    }
    
        /**
     * <p>
     * Returns the time.
     * </p>
     * @return String value representing the time.
     * @see String
     * 
     */
    public String getTime(){
        return this.time;
    }
    
     //SETTERS
    /**
     * <p>
     * Sets the name of the group.
     * </p>
     * @param groupName an instance of {@link String}
     * @see String
     * 
     */
    
     /**
     * <p>
     * Sets the number of people from the group.
     * </p>
     * @param numOfPeople an instance of {@link int}
     * @see int
     * 
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
     
    /**
     * <p>
     * Sets the number of people from the group.
     * </p>
     * @param numOfPeople an instance of {@link int}
     * @see int
     * 
     */

    public void setNumberOfPeople(String numberOfPeople){
        this.numberOfPeople = numberOfPeople;

    }
    
    /**
     * <p>
     * Sets the date.
     * </p>
     * @param date an instance of {@link Date}
     * @see Date
     * 
     */   
    public void setDate(String date){
        this.date = date;
    }
    
    /**
     * <p>
     * Sets the time.
     * </p>
     * @param time an instance of {@link String}
     * @see String
     * 
     */
    public void setTime(String time){
        this.time = time;
    }
}

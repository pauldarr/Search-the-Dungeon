/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class Player implements Serializable {
    
    // Class instance Variables
    private String name;
    public int powerLevel;
    
    //Default Constructor
    public Player() {
    }
    
    
    
    //Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }
    
    //hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.powerLevel) ^ (Double.doubleToLongBits(this.powerLevel) >>> 32));
        return hash;
    }
    
    //toString

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", powerLevel=" + powerLevel + '}';
    }
    
    //equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.powerLevel) != Double.doubleToLongBits(other.powerLevel)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
    
    
    
}

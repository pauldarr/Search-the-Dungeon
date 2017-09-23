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
public class InventoryItem implements Serializable{
   
    //class instance variables
    private String description;
    private String itemType;
    private int powerLevel;
    private int amount;
    
    //default constructor
    public InventoryItem() {
    }
    
    
    //getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    //equals and hashcode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + Objects.hashCode(this.itemType);
        hash = 41 * hash + this.powerLevel;
        hash = 41 * hash + this.amount;
        return hash;
    }
    
    //toString
    @Override
    public String toString() {
        return "InventoryItem{" + "description=" + description + ", itemType=" 
                + itemType + ", powerLevel=" + powerLevel + ", amount=" + amount + '}';
    }
    

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
        final InventoryItem other = (InventoryItem) obj;
        if (this.powerLevel != other.powerLevel) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.itemType, other.itemType);
    }

    
    
}

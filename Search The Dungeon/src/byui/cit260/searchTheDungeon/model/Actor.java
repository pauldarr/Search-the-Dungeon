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
public class Actor implements Serializable {
    
    // Class instance Variables
    private String name;
    private String description;
    private double coordinates;
    public int powerLevel;
    private boolean enemy;
 
    public Actor() {
    }
    
    public Actor(String name, String description, double coordinates, int powerLevel, boolean enemy) {
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
        this.powerLevel = powerLevel;
        this.enemy = enemy;
    }

public boolean isEnemy() {
        return enemy;
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
//        this.description = description;
    }

    public double getCoordinants() {
        return coordinates;
    }

    public void setCoordinants(double coordinates) {
        this.coordinates = coordinates;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.coordinates) ^ (Double.doubleToLongBits(this.coordinates) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.powerLevel) ^ (Double.doubleToLongBits(this.powerLevel) >>> 32));
        return hash;
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
        final Actor other = (Actor) obj;
        if (Double.doubleToLongBits(this.coordinates) != Double.doubleToLongBits(other.coordinates)) {
            return false;
        }
        if (Double.doubleToLongBits(this.powerLevel) != Double.doubleToLongBits(other.powerLevel)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", coordinants=" + coordinates + ", powerLevel=" + powerLevel + '}';
    }
}
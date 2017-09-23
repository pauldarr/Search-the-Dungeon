/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.model;
import byui.cit260.searchTheDungeon.control.InventoryControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class Game implements Serializable {
    
    private boolean gameOver;
    private Player player;
    private Map map;
    private Actor[] actors; // enum
    private InventoryItem[] inventory;
    private ArrayList<InventoryItem> backpack;
    
    //Default Constructor

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ArrayList<InventoryItem> getBackpack() {
        return backpack;
    }
    
    public InventoryItem[] getInventory() {
        return inventory;
    }
    
    public void setInventory (InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public Game() {
        gameOver=false;
        backpack = new ArrayList<InventoryItem>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public Actor[] getActors() {
        return actors;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }
    
    public void addItemToBackpack(InventoryItem item) {
        InventoryItem newItem = new InventoryItem();
        newItem.setAmount(item.getAmount());
        newItem.setDescription(item.getDescription());
        newItem.setItemType(item.getItemType());
        newItem.setPowerLevel(item.getPowerLevel());
        
        //add item to backpack
        backpack.add(newItem);
    }

}

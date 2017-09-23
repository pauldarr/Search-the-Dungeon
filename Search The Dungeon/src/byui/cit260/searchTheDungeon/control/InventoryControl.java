/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.control;
import byui.cit260.searchTheDungeon.model.InventoryItem;

/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class InventoryControl {
    
    public static InventoryItem[] createInventoryList() {
    
        // created array (list) of inventory items
        InventoryItem[] inventory = new InventoryItem[6];
        
        // created list of items
        InventoryItem sword = new InventoryItem();
        sword.setDescription("Sword");
        sword.setItemType("Weapon");
        sword.setPowerLevel(2);
        sword.setAmount(0);
        inventory[ItemType.sword.ordinal()]=sword;
        
        InventoryItem dagger = new InventoryItem();
        dagger.setDescription("Dagger");
        dagger.setItemType("Weapon");
        dagger.setPowerLevel(1);
        dagger.setAmount(0);
        inventory[ItemType.dagger.ordinal()]=dagger;
        
        InventoryItem basicShield = new InventoryItem();
        basicShield.setDescription("Basic Shield");
        basicShield.setItemType("Shield");
        basicShield.setPowerLevel(1);
        basicShield.setAmount(0);
        inventory[ItemType.basicShield.ordinal()]=basicShield;

        InventoryItem powerShield = new InventoryItem();
        powerShield.setDescription("Advanced Shield");
        powerShield.setItemType("Shield");
        powerShield.setPowerLevel(2);
        powerShield.setAmount(0);
        inventory[ItemType.powerShield.ordinal()]=powerShield;
        
        InventoryItem basicArmor = new InventoryItem();
        basicArmor.setDescription("Basic Armor");
        basicArmor.setItemType("Armor");
        basicArmor.setPowerLevel(1);
        basicArmor.setAmount(0);
        inventory[ItemType.basicArmor.ordinal()]=basicArmor;
        
        InventoryItem powerArmor = new InventoryItem();
        powerArmor.setDescription("Power Armor");
        powerArmor.setItemType("Armor");
        powerArmor.setPowerLevel(2);
        powerArmor.setAmount(0);
        inventory[ItemType.powerArmor.ordinal()]=powerArmor;
        
        return inventory;
    }
    public enum ItemType {
        sword,
        dagger,
        basicShield,
        powerShield,
        basicArmor,
        powerArmor;
    }
}


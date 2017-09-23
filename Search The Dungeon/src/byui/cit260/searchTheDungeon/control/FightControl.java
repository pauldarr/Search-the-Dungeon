/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.control;

import byui.cit260.searchTheDungeon.model.Actor;
import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.InventoryItem;
import byui.cit260.searchTheDungeon.model.Player;
import java.util.ArrayList;
import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author Les Aycock
 */
public class FightControl {

    public static boolean winFight(Player player, Actor actor) {
        int playerLevel = 0;
        Game game = SearchTheDungeon.getCurrentGame();
        ArrayList<InventoryItem> backpack = game.getBackpack();

        // retrieve player power level        
        for (InventoryItem item : backpack) {
            playerLevel = playerLevel + item.getPowerLevel();
        }

        int monsterLevel = actor.powerLevel; // retrieve power level of monster
        System.out.println(monsterLevel + "\n" + playerLevel);
        return playerLevel >= monsterLevel;
    }
}

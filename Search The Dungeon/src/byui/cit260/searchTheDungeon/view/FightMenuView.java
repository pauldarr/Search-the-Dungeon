/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import byui.cit260.searchTheDungeon.control.FightControl;
import byui.cit260.searchTheDungeon.model.Actor;
import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.Player;
import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author Les and Sue
 */
public class FightMenuView extends View {

    Game game = SearchTheDungeon.getCurrentGame();

    public FightMenuView() {

        super("\n"
                + "\n***********************************************\r"
                + "\n*                    ORCS                     *\r"
                + "\n* Oh No! You have come face to face with one  *\r"
                + "\n* of the UGLIEST creatures in the dungeon, an *\r"
                + "\n* ORC! And he does not look too happy to see  *\r"
                + "\n* you, as he is raising his club to attack!   *\r"                
                + "\n***********************************************\r"
                + "\n*                 FIGHT MENU                  *\r"
                + "\n***********************************************\r"
                + "\n* A - Attack                                  *\r"
                + "\n* Q - Run Away                                *\r"
                + "\n***********************************************\r\n");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert choice to uppsercase

        switch (choice) {
            case "A": // Player Chose to Fight
                this.displayFight();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n***Invalid option. Either fight or retreat!");
                break;
        }
        return false;
    }

    private void displayFight() {
        Player player = SearchTheDungeon.getPlayer();
        Actor tempActor = new Actor();
        tempActor.powerLevel = 1;
        boolean winFight = FightControl.winFight(player, tempActor);
        if (!winFight) {
            this.console.println("\n You’ve lost the fight!");
        } else {
            this.console.println("\n You WON! The room has been cleared! Now"
                    + "\nQuit and let's move on.");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import byui.cit260.searchTheDungeon.control.GameControl;
import byui.cit260.searchTheDungeon.model.Player;
import java.util.Scanner;


/**
 *
 * @author pauldarr
 */
public class PlayerView extends View {

    public PlayerView(){
        
        
        super("\n"
                  +"***********************************************"
                  +"\n*          Player Information                 *"
                  +"\n***********************************************"
                  +"\n* N - Display player name                     *"
                  +"\n* T - Display best time                       *"
                  +"\n* P - Display Power level                     *"
                  +"\n* Q - Quit                                    *"
                  +"\n***********************************************");
           
    }

    @Override
    public boolean doAction(String choice) {
       choice = choice.toUpperCase(); //convert choice to uppsercase

       switch (choice) {
           case "N": // Name
               this.displayName();
               break;
           case "T": // Best time
               this.displayTime();
               break;
           case "P": // How to explore a room
               this.displayPowerLevel();
               break;
           default:
               ErrorView.display(this.getClass().getName(),
                       "\n***Invalid selection *** Try again");
               break;
       }
       return false;
    }
    private void displayName() {
        this.console.println("\n player.getName()");
    }

    private void displayTime() {
        this.console.println("\n Display Time");
    }

    
    private void displayPowerLevel() {
        this.console.println("\n Display Power Level");
    }
}


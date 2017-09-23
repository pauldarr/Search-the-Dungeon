/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author Les Aycock
 */
public class WinGameView extends View{
    private String banner;
    
    public WinGameView() {
        
        super ("\nEnter N to start a New Game, or E to Exit the Game: ");
        
        this.banner = "\n"
        +"\n***********************************************"
        +"\n*               You have won!                 *" 
        +"\n***********************************************" 
        +"\n*                                             *" 
        +"\n* You just won THE GAME! You feel like you    *"
        +"\n* should start celebrating or something.      *"
        +"\n* You haven't had a win like this in weeks,   *"
        +"\n* this is amazing!                            *"
        +"\n*                                             *"
        +"\n***********************************************";
       
       
       this.displayBanner();
    }
    
    private void displayBanner() {   
        this.console.println("\n" + this.banner);
    }
    
 @Override
 public boolean doAction(String choice) {
    choice = choice.toUpperCase(); //convert choice to uppsercase
    
    switch (choice) {
        case "E": // Exit the game
            System.exit(0);
            return true;
        case "N": // Starting a new game
            // start a new game
            SearchTheDungeon.getCurrentGame().setGameOver(true);
            return true;
        }
    return false;
    }
}

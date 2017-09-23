/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import byui.cit260.searchTheDungeon.control.GameControl;
import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author Gibran Millan
 */
public class MainMenuView extends View {

    public MainMenuView(){
        
        super("\n"
                  +"***********************************************"
                  +"\n*                  MAIN MENU                  *"
                  +"\n***********************************************"
                  +"\n* N - Start new game                          *"
                  +"\n* G - Get and start saved game                *"
                  +"\n* H - Get help on how to play the game        *"
                  +"\n* S - Save Game                               *"
                  +"\n* Q - Quit                                    *"
                  +"\n***********************************************");
           
    }
    @Override       
    public boolean doAction(String menuOption) {
       menuOption = menuOption.toUpperCase(); //convert choice to uppsercase

       switch (menuOption) {
           case "N": // create and start a new game
               this.startNewGame();
               break;
           case "G": // get and start an existing game
               this.startSavedGame();
               break;
           case "H": // display the help menu
               this.displayHelpMenu();
               break;
           case "S": // save current game
               this.saveGame();
               break;

           default: // if none of the above applies
               ErrorView.display(this.getClass().getName(),
                       "\n***Invalid selection *** Try again");
               break;
       }
       return false;
    }
    private void startNewGame() {
        // Create a new game
        GameControl.createNewGame(SearchTheDungeon.getPlayer());
        
        // Display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startSavedGame() {
        
      
      // prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for the file where the game " 
                            + "is to be saved");
        String filePath = this.getInput();
        
        try {
            // save the game to the specified file
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpMenu() {
        // Display the help menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
        // prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for the file where the game " 
                            + "is to be saved");
        String filePath = this.getInput();
        
        try {
            // save the game to the specified file
            GameControl.saveGame(SearchTheDungeon.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

}

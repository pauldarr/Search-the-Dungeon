/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import byui.cit260.searchTheDungeon.control.MapControl;
import byui.cit260.searchTheDungeon.exceptions.MapControlException;
import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.Location;
import byui.cit260.searchTheDungeon.model.Map;
import byui.cit260.searchTheDungeon.control.InventoryControl;
import byui.cit260.searchTheDungeon.model.InventoryItem;
import java.io.IOException;
import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author Les and Sue
 */
public class GameMenuView extends View {
    Game game = SearchTheDungeon.getCurrentGame();
    InventoryItem[] inventory = game.getInventory();
    public GameMenuView(){
        
        super("\n"
                  +"***********************************************"
                  +"\n*                  GAME MENU                  *"
                  +"\n***********************************************"
                  +"\n*                                             *"
                  +"\n* You have entered the dungeon! It is cold    *"
                  +"\n* and dark. You should hurry and explore a    *"
                  +"\n* new room. You can take a look at your       *"
                  +"\n* items also.                                 *"
                  +"\n*                                             *"
                  +"\n* What will you do now?                       *"                
                  +"\n*                                             *"
                  +"\n* V - View the Map                            *"
                  +"\n* M - Move to new location                    *"
                  +"\n* R - Report View (Items, Enemies, ect.)      *"
                  +"\n* Q - Quit                                    *"                
                  +"\n***********************************************");      
    }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert choice to uppsercase

        switch (choice) {
            case "V": // Go to the map and choose a room
               this.displayMap();
               break;
            case "M": {
                try {
                this.move(); // Go to the map and choose a room
                break;                              
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                    "\n*** You must enter a value *** ");
            }
           }
           case "R": // View Reports 
               this.viewReports();
               break;               
           default:
               ErrorView.display(this.getClass().getName(),
                       "\n***Invalid selection *** Try again\n");
               break;
       }
       return false;
    }

    //Display Map
    public void displayMap() {
        String leftIndicator;
        String rightIndicator;

        Game game = SearchTheDungeon.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map
        this.console.print("  |");
        for( int column = 0; column < locations[0].length; column++){
        // print col numbers to side of map
        this.console.print("  " + column + " |"); 
    }
    // Now build the map.  For each row, show the column information
        this.console.println();
        for( int row = 0; row < locations.length; row++){
        this.console.print(row + " "); // print row numbers to side of map
            for (Location location : locations[row]) {
                // set default indicators as blanks
                leftIndicator = " ";
                rightIndicator = " ";
                if (location == map.getCurrentLocation()) {
                    // Set star indicators to show this is the current location.
                    leftIndicator = "*";
                    rightIndicator = "*";
                } 
                else if (location.visited) {
                    // Set < > indicators to show this location has been visited.
                    leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                    rightIndicator = "<"; // same as above
                }
                this.console.print("|"); // start map with a |
                if (location.getScene() == null) {
                    // No scene assigned here so use ?? for the symbol
                    this.console.print(leftIndicator + "??" + rightIndicator);
                } else {
                    this.console.print(leftIndicator + location.getScene().getMapSymbol() + rightIndicator);
                }
            }
     this.console.println("|");
    }
        this.console.println(""+map.getCurrentLocation().getScene().getDescription());
        if (map.getCurrentLocation().getScene().getItem()!=null){
            this.console.println("There is something here! "+map.getCurrentLocation().getScene().getItem().getDescription());
        }
 }

    //View Functions
    private void viewReports() {
        ReportsView reportsView = new ReportsView();
        reportsView.display();
    }    
    private void displayFairiesView() {       
        FairiesView fairiesView = new FairiesView();
        fairiesView.display(); 
    }
    private void displayDragonView() {
       DragonView dragonView = new DragonView();
       dragonView.display();  
    }
    private void displayTrapView() {
       TrapView trapView = new TrapView();
       trapView.display();  
    }
    private void displayWizardView() {
       WizardView wizardView = new WizardView();
       wizardView.display();  
    }
    private void winGameView() {
       WinGameView winGameView = new WinGameView();
       winGameView.display();  
    }
    
    //Move
    private void move() throws IOException{ 
        try {
            Game game = SearchTheDungeon.getCurrentGame(); // retreive the game
            Map map = game.getMap(); // retreive the map from game
            displayMap();
            int row = getIntInput("Enter row: ",0,4);
            if (row == -999)
                return;
            int column = getIntInput ("Enter column: ",0,4);
            if (column == -999)
                return;
            MapControl.movePlayer(SearchTheDungeon.getCurrentGame().getMap(), row, column);
            displayMap();
            checkRoom(row, column);
        } catch (MapControlException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //Function to load views upon entering rooms.
    private void checkRoom(int row, int column) {
        String coordinates;
        coordinates = Integer.toString(row) + Integer.toString(column);
        switch (coordinates) {
                case "02":
                    game.addItemToBackpack(game.getInventory()[InventoryControl.ItemType.basicShield.ordinal()]);
                    break;
                case "04":
                    game.addItemToBackpack(game.getInventory()[InventoryControl.ItemType.basicArmor.ordinal()]);
                    break;
                case "12":
                    this.displayFairiesView();
                    break;
                case "20":
                    this.displayFight();
                    break;
                case "21":
                    this.displayWizardView();
                    break;
                case "22":
                    game.addItemToBackpack(game.getInventory()[InventoryControl.ItemType.sword.ordinal()]);
                    break;
                case "23":
                    this.displayFight();
                    break;
                case "24":
                    this.displayTrapView();
                    break;
                case "30":
                    game.addItemToBackpack(game.getInventory()[InventoryControl.ItemType.powerShield.ordinal()]);
                    break;
                case "32":
                    game.addItemToBackpack(game.getInventory()[InventoryControl.ItemType.powerArmor.ordinal()]);
                    break;  
                case "34":
                    this.displayFight();
                    break;
                case "42":
                    this.displayFight();
                    break;
                case "43":
                    this.displayDragonView();
                    break;
                case "44":
                    this.winGameView();
        }
    }

    private void displayFight() {
        FightMenuView fightView = new FightMenuView();
        fightView.display();
    }
}

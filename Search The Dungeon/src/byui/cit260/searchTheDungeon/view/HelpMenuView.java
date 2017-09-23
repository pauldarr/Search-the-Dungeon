/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

/**
 *
 * @author Paul Darr
 */

public class HelpMenuView extends View {

    public HelpMenuView(){
        
        super("\n"
                  +"***********************************************"
                  +"\n*                   HELP MENU                 *"
                  +"\n***********************************************"
                  +"\n* G - What is the goal of the game?           *"
                  +"\n* M - How to move to a new room?              *"
                  +"\n* E - How to Explore a room?                  *"
                  +"\n* V - How to view gear in inventory?          *"
                  +"\n* A - How to add gear to inventory?           *"
                  +"\n* F - Fighting enemies                        *"
                  +"\n* I - Game interactions                       *"
                  +"\n* Q - Quit                                    *"
                  +"\n***********************************************");
           
    }

    @Override
    public boolean doAction(String choice) {
       choice = choice.toUpperCase(); //convert choice to uppsercase

       switch (choice) {
           case "G": // What is the goal of the game?
               this.displayGame();
               break;
           case "M": // How to move to a new room
               this.displayMove();
               break;
           case "E": // How to explore a room
               this.displayExplore();
               break;
           case "V": // How to view gear in inventory
               this.displayView();
               break;
           case "A": // How to add gear to inventory
               this.displayAdd();
               break;
           case "F": // Fighting enemies
               this.displayFight();
               break;
           case "I": // Game interactions
               this.displayInteractions();
               break;
           default:
               ErrorView.display(this.getClass().getName(),
                       "\n***Invalid selection *** Try again");
               break;
       }
       return false;
    }
    private void displayGame() {

        this.console.println(
                 "\n***********************************************"
                +"\n*                Goal of Game                 *"
                +"\n***********************************************"
                +"\n* What is your purpose in this dungeon?       *"
                +"\n* Simple, to survive. In this dungeon live    *"
                +"\n* many creatures. Your goal is to survive     *"
                +"\n* the challenges, and conquer the dragon      *"
                +"\n* hidden somewhere in this dungeon.           *"
                +"\n***********************************************");
    }

    private void displayMove() {
        this.console.println(
                 "\n***********************************************"
                +"\n*                 How to Move                 *"
                +"\n***********************************************"
                +"\n* How to move around in the dungeon is        *"
                +"\n* just a matter of chosing what room you want *"
                +"\n* to explore, in the map, and putting in the  *"
                +"\n* appropriate grid coordinates. Of course you *"
                +"\n* can quit at any time or go back a menu by   *"
                +"\n* entering a Q.                               *"
                +"\n***********************************************");
    }

    private void displayExplore() {
        this.console.println(
                 "\n***********************************************"
                +"\n*               How to Explore                *"
                +"\n***********************************************"
                +"\n* Once you are in a room, you will either be  *"
                +"\n* confronted with a creature from the dungeon *"
                +"\n* or a trap, or an empty room. By responding  *"
                +"\n* to the questions you are asked you will     *"
                +"\n* be allowed to continue or die.              *"
                +"\n***********************************************");
    }

    private void displayView() {
        this.console.println(
                 "\n***********************************************"
                +"\n*           How to View Inventory             *"
                +"\n***********************************************"
                +"\n* To view your inventory, from the game menu, *"
                +"\n* select Review the items in your inventory.  *"
                +"\n***********************************************");
    }

    private void displayAdd() {
        this.console.println(
                 "\n************************************************"
                +"\n*         How to Add To Your Inventory         *"
                +"\n************************************************"
                +"\n* You will add equipment based on interactions *"
                +"\n* with the dungeon residents and random rooms. *"
                +"\n************************************************");
    }
    
    private void displayFight() {
        this.console.println(
                 "\n************************************************"
                +"\n*                How to Fight                  *"
                +"\n************************************************"
                +"\n* Fighting in this dungeon is based on your    *"
                +"\n* answers to these riddle-obsessed residents   *"
                +"\n* questions. Correct answers earn rewards.     *"
                +"\n* Incorrect answers will cost you.             *"
                +"\n************************************************");
    }
    
    private void displayInteractions() {
        this.console.println(
                 "\n*************************************************"
                +"\n*                Interactions                   *"
                +"\n*************************************************"
                +"\n* Throughout this dungeon, you will be faced    *"
                +"\n* with various creatures living in the dungeon. *"
                +"\n* You will be asked either riddles, or other    *"
                +"\n* random questions. Your continued existance    *"
                +"\n* will depend on your responses to these        *"
                +"\n* questions.                                    *"
                +"\n*************************************************");
    }
}

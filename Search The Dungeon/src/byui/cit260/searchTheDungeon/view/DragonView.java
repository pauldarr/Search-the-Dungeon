/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import byui.cit260.searchTheDungeon.control.RiddleControl;
import byui.cit260.searchTheDungeon.exceptions.RiddleControlException;

/**
 *
 * @author Paul Darr
 */

public class DragonView extends View  {
    private String banner;
    
    public DragonView(){
    
     super("\nWhat are two numbers whose product is 48 and sum is 14? \nWhat is your first number (or Q to quit): ");
    
     this.banner = "\n"
      +"\n***********************************************"
      +"\n*            The Dragon!                      *" 
      +"\n***********************************************" 
      +"\n*                                             *" 
      +"\n* Hello human, you have defeated many         *"
      +"\n* enemies but are you wise? If you            *"
      +"\n* can answer my question, I might             *"
      +"\n* decide to allow you to leave this           *"
      +"\n* room without being made into a              *"
      +"\n* toasted treat.                              *"
      +"\n*                                             *"
      +"\n* To Quit use Q                               *"
      +"\n*                                             *"
      +"\n***********************************************";
       
       
       this.displayBanner();
    }
    
    private void displayBanner() {
        
        this.console.println("\n" + this.banner);
    }
    
      @Override
      public boolean doAction(String value) {
          String numberOneRaw = getInput();
          double numberOne = 0;
          try{
          numberOne = Double.parseDouble(numberOneRaw);
          
          } catch (NumberFormatException nf) {
              ErrorView.display(this.getClass().getName(),"\n You must enter a valid number." 
                      + "Try again or enter Q to quit");
          
          }
          
          this.displayMessage="\nWhat is your second number? ";
          String numberTwoRaw = getInput();
          double numberTwo = 0;
          try{
          numberTwo = Double.parseDouble(numberTwoRaw);
          
          } catch (NumberFormatException nf) {
              ErrorView.display(this.getClass().getName(),"\n You must enter a valid number." 
                      + "Try again or enter Q to quit");
          
          }
        
//          double mathDragon = 0; 
          try{ 
          double mathDrag = RiddleControl.calcDragon(numberOne,numberTwo);
          if (numberOne == 0) //User wants to quit

              return false; //exit the game
        
       if (mathDrag == -1) {  //incorrect
        this.console.println(
        "\n***********************************************"
        +"\n*                                             *" 
        +"\n*       Foolish human, you have lost.         *" 
        +"\n*                                             *" 
        +"\n***********************************************");
           
        this.displayLoseGameView();
        }
       
        else {
        this.console.println(
        "\n***********************************************"
        +"\n*                                             *" 
        +"\n*   Well done! The numbers six and eight      *" 
        +"\n*   are the answer to my riddle.              *"
        +"\n*                                             *" 
        +"\n***********************************************");
        
        this.displayWinGameView();
        }
        } catch (RiddleControlException we) {
        ErrorView.display(this.getClass().getName(),we.getMessage());
        }
        return true;   
    }
      
        private void displayLoseGameView() {
        LoseGameView loseGameView = new LoseGameView();
        loseGameView.display();
    }
        
        private void displayWinGameView() {
        WinGameView winGameView = new WinGameView();
        winGameView.display();
    }

}
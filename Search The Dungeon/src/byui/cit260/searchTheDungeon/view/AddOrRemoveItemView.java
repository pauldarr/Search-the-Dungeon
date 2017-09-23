/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

/**
 *
 * @author Gibran Millan
 */
public class AddOrRemoveItemView extends View {
     public AddOrRemoveItemView(){
        
        super("\n"
                  +"***********************************************"
                  +"\n*          YOU HAVE FOUND A NEW ITEM          *"
                  +"\n***********************************************"
                  +"\n* you can only carry three items with you at  *"
                  +"\n* a time: a weapon, a shield, and a set of    *"
                  +"\n* armor.                                      *"
                  +"\n* If you find an item that is stronger than   *"
                  +"\n* the one that you are carrying, you can      *" 
                  +"\n* replace it. If it is less powerful than     *"
                  +"\n* the one you are carrying, you might want to *"
                  +"\n* leave it there and keep yours.              *"
                  +"\n*                                             *"
                  +"\n* You have found a new item! what do you      *"
                  +"\n* want to do with it?                         *"
                  +"\n*                                             *"
                  +"\n* S - Switch the item found with the one      *"
                  +"\n*     that I am carrying                      *"
                  +"\n* L - Leave item found and keep the one that  *"
                  +"\n*     I am carrying                           *"
                  +"\n***********************************************");
    
}
     
@Override
    public boolean doAction(String choice) {
       choice = choice.toUpperCase(); //convert choice to uppsercase

       switch (choice) {
           case "S": // Switch the item found with the one that I am carrying
               this.switchItem();
               break;
           case "L": // Leave item found and keep the one that I am carrying
               this.leaveItem();
               break;   
       }
       return false;
    }

    private void switchItem() {
        this.console.println("*** switchItem function called ***");
    }

    private void leaveItem() {
        this.console.println("*** leaveItem function called ***");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import byui.cit260.searchTheDungeon.control.InventoryControl;
import byui.cit260.searchTheDungeon.control.RiddleControl;
import byui.cit260.searchTheDungeon.exceptions.RiddleControlException;
import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.InventoryItem;
import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author Les and Sue
 */
public class FairiesView extends View {

    private String banner;
    Game game = SearchTheDungeon.getCurrentGame();
    InventoryItem[] inventory = game.getInventory();

    public FairiesView() {

        super("\nHow many rooms have you explored so far? (enter Q to quit) ");

        this.banner = "\n"
                + "\n***********************************************"
                + "\n*                                             *"
                + "\n*             The Fairies!                    *"
                + "\n*                                             *"
                + "\n* Hello traveler! We are fairies, lots of     *"
                + "\n* fairies! We might look like tiny winged     *"
                + "\n* humans, but we are not. We are mythical,    *"
                + "\n* Metaphysical, and magical tree spirits!     *"
                + "\n*                                             *"
                + "\n* We love and reward hardworking travelers    *"
                + "\n* and hate and curse lazy travellers!         *"
                + "\n***********************************************";

        this.displayBanner();
    }

    private void displayBanner() {

        this.console.println("\n" + this.banner);
    }

    @Override
    public boolean doAction(String value) {
        String numberRoomsRaw = getInput();
        int numberRooms = 0;
        try {
            numberRooms = Integer.parseInt(numberRoomsRaw);

        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(), "\n You must enter a valid number."
                    + "Try again or enter Q to quit");
        }

        if (numberRooms > 26) {
            ErrorView.display(this.getClass().getName(),
                    "\n There are only so many rooms! Try again!");
            return false;
        }
        // call checkRooms() control function
        try {
            boolean half = RiddleControl.calcFairies(numberRooms);

            if (!half) {  //if usuccessful
                this.console.println(
                        "\n***********************************************"
                        + "\n*                                             *"
                        + "\n*            Less than HALF?                  *"
                        + "\n*                                             *"
                        + "\n* You are one lazy traveller! You still have  *"
                        + "\n* so much to explore and learn! You have      *"
                        + "\n* brought upon yourself the 'Weak Item'       *"
                        + "\n* damnation! NOW GET OUT OF OUR ROOM!         *"
                        + "\n***********************************************"
                );
            } else {
                this.console.println(
                        "\n***********************************************"
                        + "\n*                                             *"
                        + "\n*             Over HALF!                      *"
                        + "\n*                                             *"
                        + "\n* You have found grace in our sight,          *"
                        + "\n* traveller! You have explored more than half *"
                        + "\n* of this dungeon. You are definately one     *"
                        + "\n* hard worker! Accept this powerful item      *"
                        + "\n* as a gift to you.                           *"
                        + "\n* Now go and continue exploring!              *"
                        + "\n***********************************************"
                );
                game.addItemToBackpack(game.getInventory()[InventoryControl.ItemType.basicShield.ordinal()]);
            }
        } catch (RiddleControlException we) {
            ErrorView.display(this.getClass().getName(), we.getMessage());
        }
        return true; // success!
    }
}

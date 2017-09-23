/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import byui.cit260.searchTheDungeon.model.Actor;
import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.InventoryItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import search.the.dungeon.SearchTheDungeon;
import static search.the.dungeon.SearchTheDungeon.player;

/**
 *
 * @author Paul Darr, Gibran Milan, Les Aycock
 */
public class ReportsView extends View {

    public ReportsView() {

        super("\n"
                + "\n***************************************"
                + "\n* Which report would you like to see? *"
                + "\n***************************************"
                + "\n* I - List all items in game          *"
                //                + "\n* P - Print all items in game         *"
                + "\n* C - List all in your backpack       *"
                //                + "\n* D - Print all in your backpack      *"
                + "\n* A - List all actors in game         *"
                //                + "\n* B - Print all actors in game        *"
                + "\n* E - List all enemies in game        *"
                //                + "\n* X - Print all enemies in game       *"
                + "\n* Q - Quit                            *"
                + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert choice to upper case
        try {
            switch (choice) {
                case "I": // List all items in game
                    this.displayInventory();
                    break;
                case "P": // List all items in game
                    this.printInventory();
                    break;
                case "C":
                    // List all items carried
                    this.displayInventoryCarried();
                    break;
                case "D": // print content of backpack
                    this.printBackPack();
                    break;
                case "A": // List all actors in game
                    this.displayActors();
                    break;
                case "B": // List all Actors in game
                    this.printActors();
                    break;
                case "E": // List all enemies in game
                    this.displayEnemies();
                    break;
                case "X": // List all enemies in game
                    this.printEnemy();
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "\n***Invalid selection *** Try again");
                    break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),
                    "Error reading input: " + e.getMessage());
        }
        return false;
    }

    private void displayInventory() throws IOException {
        StringBuilder line;

        Game game = SearchTheDungeon.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        String answer;

        this.console.println("\n LIST OF GAME INVENTORY ITEMS");
        line = new StringBuilder("                                                                  ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "LEVEL");
        line.insert(30, "QUANTITY");
        this.console.println(line.toString());

        //for each inventory item
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                                                        ");
            line.insert(0, item.getDescription());
            line.insert(23, item.getPowerLevel());
            line.insert(32, item.getAmount());

            //DISPLAY the line
            this.console.println(line.toString());

            this.console.println("\nSave to file (Y/N)? ");
            answer = this.keyboard.readLine();
            answer = answer.toUpperCase();
            if ("Y".equals(answer) || "YES".equals(answer)) {
                printInventory();
            }
        }
    }
// done by Paul Darr

    private void printInventory() {

        Game game = SearchTheDungeon.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();

        this.console.println("\nWhat would you like the file name to be? Please use format: 'example.txt'");
        String outputLocation;

        try {
            outputLocation = this.keyboard.readLine();

            //create object for input file
            try (PrintWriter out = new PrintWriter(outputLocation)) {
                //print report form
                out.println("\n"
                        + "\n*********************************************************\r"
                        + "\n*                                                       *\r"
                        + "\n*                 Inventory  Report                     *\r"
                        + "\n*                                                       *\r"
                        + "\n*********************************************************\r"
                        + "\n Item Type  Item Description  Power Level  Number Carried\r"
                        + "\n*********************************************************\r");

                //print the description and strength of each item
                for (InventoryItem item : inventory) {
                    out.printf("%n%-13s%-20s%-30s%-5d", item.getItemType(),
                            item.getDescription(),
                            item.getPowerLevel(),
                            item.getAmount());
                }

                this.console.println("Your report was saved successfully.");

            } catch (IOException ex) {
                ErrorView.display("ReportView", ex.getMessage());
            }
        } catch (IOException ex) {
            ErrorView.display("ReportView", ex.getMessage());
        }
    }

    private void displayInventoryCarried() throws IOException {
        StringBuilder line;

        //Retrieve list of items
        Game game = SearchTheDungeon.getCurrentGame();
        ArrayList<InventoryItem> backpack = game.getBackpack();
        String answer;
        boolean answer2;

        this.console.println("\n LIST OF INVENTORY ITEMS\n");
        line = new StringBuilder("                                              ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "LEVEL");
        this.console.println(line.toString());

        //for each inventory item
        for (InventoryItem item : backpack) {
            line = new StringBuilder("                                              ");
            line.insert(0, item.getDescription());
            line.insert(23, item.getPowerLevel());

            //DISPLAY the line
            this.console.println(line.toString());
        }
        this.console.println("\nSave to file (Y/N)? ");
        answer = this.keyboard.readLine();
        answer = answer.toUpperCase();
        if ("Y".equals(answer) || "YES".equals(answer)) {
            printBackPack();
        }
    }

    private void displayActors() throws IOException {
        StringBuilder line;

        //retrieve list of actors
        Game game = SearchTheDungeon.getCurrentGame();
        Actor[] actors = game.getActors();
        String answer;
        ArrayList<InventoryItem> backpack = game.getBackpack();
        int playerStrength = 0;

        this.console.println("\n   LIST OF ACTORS IN GAME\n");
        line = new StringBuilder("                                                 ");
        line.insert(0, "NAME");
        line.insert(20, "STRENGTH");
        this.console.println(line.toString());

        //for each actor
        for (Actor actor : actors) {
            line = new StringBuilder("                                                 ");
            line.insert(0, actor.getName());
            line.insert(24, actor.getPowerLevel());

            //Display line
            this.console.println(line.toString());
        }
        for (InventoryItem item : backpack) {
            playerStrength = playerStrength + item.getPowerLevel();
        }
        line = new StringBuilder("                                                 ");
        line.insert(0, player.getName());
        line.insert(24, playerStrength);

        this.console.println(line.toString());
        this.console.println("\nSave to file (Y/N)? ");
        answer = this.keyboard.readLine();
        answer = answer.toUpperCase();
        if ("Y".equals(answer) || "YES".equals(answer)) {
            printActors();
        }
    }

    private void displayEnemies() throws IOException {
        StringBuilder line;

        //retrieve list of actors
        Game game = SearchTheDungeon.getCurrentGame();
        Actor[] actors = game.getActors();
        String answer;

        this.console.println("\n   LIST OF ENEMIES IN GAME\n");
        line = new StringBuilder("                                                 ");
        line.insert(0, "NAME");
        line.insert(20, "STRENGTH");
        this.console.println(line.toString());

        //for each actor
        for (Actor actor : actors) {
            if (actor.isEnemy() != false) {
                line = new StringBuilder("                                                 ");
                line.insert(0, actor.getName());
                line.insert(24, actor.getPowerLevel());
                this.console.println(line.toString());
            }
        }
        answer = this.keyboard.readLine();
        answer = answer.toUpperCase();
        if ("Y".equals(answer) || "YES".equals(answer)) {
            printEnemy();
        }
    }

    // by Les Aycock
    private void printEnemy() {

        //retrieve list of actors
        Game game = SearchTheDungeon.getCurrentGame();
        Actor[] actors = game.getActors();

        this.console.println("\nWhat filename do you want to use? ");
        String outputLocation;
        try {
            outputLocation = this.keyboard.readLine();

            //create object for input file
            try (PrintWriter out = new PrintWriter(outputLocation)) {
                //print report form
                out.println("\n"
                        + "\n*********************************\r"
                        + "\n*                               *\r"
                        + "\n*          Enemy List           *\r"
                        + "\n*                               *\r"
                        + "\n*********************************\r"
                        + "\n*Enemy Name          Power Level*\r"
                        + "\n*********************************\r");

                //print the description and strength of each item
                for (Actor actor : actors) {
                    if (actor.isEnemy() != false) {
                        out.printf("%n%-25s%-5d", actor.getName(),
                                actor.getPowerLevel());
                    }
                }

                this.console.println("Your report was saved successfully.");

            } catch (IOException ex) {
                ErrorView.display("ReportView", ex.getMessage());
            }
        } catch (IOException ex) {
            ErrorView.display("ReportView", ex.getMessage());
        }
    }

    // By Gibran Millan
    private void printActors() {

        Game game = SearchTheDungeon.getCurrentGame();
        Actor[] actors = game.getActors();

        this.console.println("\nWhat filename do you want to use? Please use format: 'example.txt' ");
        String outputLocation;
        try {
            outputLocation = this.keyboard.readLine();

            try (PrintWriter out = new PrintWriter(outputLocation)) {

                out.println("\n"
                        + "\n*********************************\r"
                        + "\n*                               *\r"
                        + "\n*         Actor's list          *\r"
                        + "\n*                               *\r"
                        + "\n*********************************\r"
                        + "\n*Name                Power Level*\r"
                        + "\n*********************************\r");

                for (Actor actor : actors) {

                    out.printf("%n%-25s%-5d", actor.getName(),
                            actor.getPowerLevel());
                }
                this.console.println("Your report was saved successfully.");

            } catch (IOException ex) {
                ErrorView.display("ReportView", ex.getMessage());
            }
        } catch (IOException ex) {
            ErrorView.display("ReportView", ex.getMessage());
        }
    }
// by Les

    private void printBackPack() {

        //Retrieve list of items
        Game game = SearchTheDungeon.getCurrentGame();
        ArrayList<InventoryItem> backpack = game.getBackpack();

        this.console.println("\nWhat would you like the file name to be? Please use format: 'example.txt'");
        String outputLocation;

        try {
            outputLocation = this.keyboard.readLine();

            //create object for input file
            try (PrintWriter out = new PrintWriter(outputLocation)) {
                //print report form
                out.println("\n"
                        + "\n*****************************************\r"
                        + "\n*                                       *\r"
                        + "\n*           Inventory  Report           *\r"
                        + "\n*                                       *\r"
                        + "\n*****************************************\r"
                        + "\n Item Type  Item Description  Power Level\r"
                        + "\n*****************************************\r");

                //print the description and strength of each item
//                inventory.forEach((item) -> {
                for (InventoryItem item : backpack) {
                    out.printf("%n%-13s%-20s%-5d", item.getItemType(),
                            item.getDescription(),
                            item.getPowerLevel());
                }
            }

            this.console.println("Your report was saved successfully.");

        } catch (IOException ex) {
            ErrorView.display("ReportView", ex.getMessage());
        }
    }
}

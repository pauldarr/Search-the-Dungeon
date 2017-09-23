/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.the.dungeon;

import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.Player;
import byui.cit260.searchTheDungeon.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class SearchTheDungeon {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    public static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    
    //Getter and Setter
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        SearchTheDungeon.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        SearchTheDungeon.inFile = inFile;
    }
    
    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        SearchTheDungeon.logFile = logFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        SearchTheDungeon.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        SearchTheDungeon.player = player;
    }
    public static void main(String[] args) {
        
        try{
            //open character stream files for end user input and output
            SearchTheDungeon.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
            SearchTheDungeon.outFile = new PrintWriter(System.out, true);
                       
            //create StartProgramViewOrig and display the start program view
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
        
        } catch (Throwable te) {
            System.out.println(te.getMessage());
        
        try {    
            //open log file
            String filePath = "log.txt";
            SearchTheDungeon.logFile = new PrintWriter(filePath);                        
        
        } catch (Exception e) {
            System.err.println( 
                    "\nCause: " + "Exception: " + e.toString()
                            + e.getCause() + "\nMessage: " + e.getMessage());
        }
            
        }
        
        finally {
            try {
                if (SearchTheDungeon.inFile != null)
                    SearchTheDungeon.inFile.close();
                if (SearchTheDungeon.outFile != null)
                    SearchTheDungeon.outFile.close();
                if (SearchTheDungeon.logFile != null)
                    SearchTheDungeon.logFile.close();
            } catch (IOException ex) {
                System.err.println("Error closing files");
                return;
            }
            
        }
    }
}
    


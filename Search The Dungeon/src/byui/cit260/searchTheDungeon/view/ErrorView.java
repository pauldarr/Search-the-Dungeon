/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.view;

import java.io.PrintWriter;
import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author pauldarr
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = SearchTheDungeon.getOutFile();
    private static final PrintWriter logFile = SearchTheDungeon.getLogFile();
            
    public static void display(String className, String errorMessage) {
        
        errorFile.println(
                    "_______________________________________________________"
                   +"\n- ERROR -" + errorMessage
                   +"\n______________________________________________________");
        // log error
//        errorFile.println(className + " - " + errorMessage);
    }        
    
}

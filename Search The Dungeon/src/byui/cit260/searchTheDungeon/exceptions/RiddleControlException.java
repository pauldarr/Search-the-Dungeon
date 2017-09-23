/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.exceptions;

/**
 *
 * @author Gibran Millan
 */
public class RiddleControlException extends Exception {

    public RiddleControlException() {
    }

    public RiddleControlException(String message) {
        super(message);
    }

    public RiddleControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public RiddleControlException(Throwable cause) {
        super(cause);
    }

    public RiddleControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

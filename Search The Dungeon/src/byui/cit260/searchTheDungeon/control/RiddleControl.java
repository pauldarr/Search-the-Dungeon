/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.control;
import byui.cit260.searchTheDungeon.exceptions.RiddleControlException;

/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class RiddleControl {
    
    /**
    * 
    * @author Paul Darr
    * @param numberOne
    * @param numberTwo
    * @param numberThree
    * @return 
    * @throws byui.cit260.searchTheDungeon.exceptions.RiddleControlException 
    */
    
    public static double calcWizard ( double numberOne, double numberTwo, double numberThree)throws RiddleControlException{ 
       
        if (numberOne <= 0 && numberTwo <= 0 && numberThree <= 0){ 
            throw new RiddleControlException("Can't be less than or equal to zero.");
        }
 
        double addedNumber = numberOne + numberTwo + numberThree;
        double multipliedNumber = numberOne * numberTwo * numberThree;
        
        if ((addedNumber == 6) && (multipliedNumber == 6)){    
             return 1 ;
        }
        
    return -1;
    }
    
/**
 *
 * @author Les Aycock, Paul Darr
 * @param numberRooms
 * @return 
 * @throws byui.cit260.searchTheDungeon.exceptions.RiddleControlException 
 */
public static boolean calcFairies (int numberRooms)throws RiddleControlException{
        if (numberRooms <= 0){
            throw new RiddleControlException("Can't be less than or equal to zero.");
        }
        // 25 rooms in the dungeon
        int totalRooms = 25; 
        // getting half the number of rooms
        int halfRooms = totalRooms / 2; 
        // returning if user explored half or not
        return numberRooms >= halfRooms; 
    }    
    
    /**
     * @author Gibran Millan
     * @param radius
     * @param height
     * @return 
     * @throws byui.cit260.searchTheDungeon.exceptions.RiddleControlException 
    */
    public static double calcTrap ( double radius, double height )throws RiddleControlException{ 
       
        if (radius <= 0 && height <= 0){ 
            throw new RiddleControlException("Can't be less than or equal to zero.");
        }
       
        double volumeNotRounded = ( Math.PI * Math.pow(radius, 2) * height );
        double volume = Math.round(volumeNotRounded*100.0)/100.0;
        if ( volume >= 3141.59 && volume <= 10602.88){    
             return volume ;
        }
        
        return -1;
    }
    
    /**
    * 
    * @author Paul Darr
    * @param numberOne
    * @param numberTwo
    * @return 
     * @throws byui.cit260.searchTheDungeon.exceptions.RiddleControlException 
    */
    public static double calcDragon ( double numberOne, double numberTwo)throws RiddleControlException{ 
       
        if (numberOne <= 0 && numberTwo <= 0){ 
            throw new RiddleControlException("Can't be less than or equal to zero.");
        }
 
        double addedNumber = numberOne + numberTwo;
        double multipliedNumber = numberOne * numberTwo;
        
        if ((addedNumber == 14) && (multipliedNumber == 48)){    
             return 1;
        }
        
    return -1;
    }
}   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.control;


import byui.cit260.searchTheDungeon.control.MapControl.SceneType;
import byui.cit260.searchTheDungeon.exceptions.GameControlException;
import byui.cit260.searchTheDungeon.model.Actor;
import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.InventoryItem;
import byui.cit260.searchTheDungeon.model.Location;
import byui.cit260.searchTheDungeon.model.Map;
import byui.cit260.searchTheDungeon.model.Player;
import byui.cit260.searchTheDungeon.model.Scene;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import search.the.dungeon.SearchTheDungeon;


/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class GameControl {

    public static Player createPlayer(String name)throws GameControlException {
       
        if (name == null) {
            throw new GameControlException("The name variable was null.");
        }
        
        Player player = new Player();
        player.setName(name);
        
        SearchTheDungeon.setPlayer(player); // save the player
        return  player;
    }

    public static void createNewGame(Player player) {
      Game game = new Game();
      game.setActors(createActorList());
      game.setPlayer(player);
      SearchTheDungeon.setCurrentGame(game);
      
      InventoryItem[] inventoryList = InventoryControl.createInventoryList();
      game.setInventory(inventoryList);
      
      Map map = MapControl.createMap();
      game.setMap(map);
      MapControl.movePlayerToStartingLocation(map);
    }

    public static void saveGame(Game game, String filePath)
            throws GameControlException {
        
        try( FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            // Pg 24 group assign. may need more objects?
            output.writeObject(game); // write the game object out to file
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void getSavedGame(String filePath)
                        throws GameControlException {
        
        Game game = null;
        
        try( FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject(); //read the game object from file
        }    
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
        //close the output file
        SearchTheDungeon.setCurrentGame(game);
    }

    public boolean starNewGame(boolean player, boolean newGame, boolean saveFile, boolean starNewGame){
        if (player == newGame && player ==saveFile){
            return false;   
        }
        if (player == newGame && player != saveFile){
            return true;
        }
        
        return starNewGame;
        }
        
    public static Actor[] createActorList(){
       Actor[] actors = new Actor[5]; 
        
        Actor newActor = new Actor();
        
        newActor.setName("Fairie");
        newActor.setDescription("Lot's of trouble");
        newActor.setEnemy(false);
        actors[0] = newActor;

	newActor = new Actor();
        newActor.setName("Blue Wizard");
        newActor.setDescription("He might be helpful");
        newActor.setEnemy(false);
        actors[1] = newActor;
        
        newActor = new Actor();
        newActor.setName("Dragon");
        newActor.setDescription("A common enemy in the dungeon");
        newActor.setEnemy(false);
        actors[2] = newActor;
        
        newActor = new Actor();
        newActor.setName("Troll");
        newActor.setDescription("A common enemy in the dungeon");
        newActor.setPowerLevel(2);
        newActor.setEnemy(true);
        actors[3] = newActor;
                
        newActor = new Actor();
        newActor.setName("Orc");
        newActor.setDescription("A common enemy in the dungeon");
        newActor.setPowerLevel(1);
        newActor.setEnemy(true);
        actors[4] = newActor;
        return actors;
        
    }
        
    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.room1.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.room2.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.room3.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.room4.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.room5.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.room6.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.fairies.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.room7.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.room8.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.room9.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.blueWizard.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.room10.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.room11.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.trap.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.room12.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.room13.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.room14.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.room15.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.room16.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.room17.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.room18.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.room19.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.dragon.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.finish.ordinal()]);
    }
}

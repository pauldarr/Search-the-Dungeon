/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.control;
import byui.cit260.searchTheDungeon.control.InventoryControl.ItemType;
import byui.cit260.searchTheDungeon.exceptions.MapControlException;
import byui.cit260.searchTheDungeon.model.Game;
import byui.cit260.searchTheDungeon.model.InventoryItem;
import byui.cit260.searchTheDungeon.model.Map;
import byui.cit260.searchTheDungeon.model.Scene;
import java.util.ArrayList;
import search.the.dungeon.SearchTheDungeon;

/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class MapControl {
    static Map createMap() {
        // create the map
        Map map = new Map(5, 5);
        // create teh scenes for the game
        Scene[] scenes = createScenes();
        // assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);
        return map;        
    }
    
    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
        Game game = SearchTheDungeon.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        ArrayList<InventoryItem> backpack = game.getBackpack();
        
        Scene startScene = new Scene();
        startScene.setDescription(                
        "***********************************************"
        +"\n                                            "
        +"\n You open the door and listen as it         "
        +"\n screeches open. Well, so much for surprise."
        +"\n You are now in the dungeon. Where do you   "
        +"\n want to go?                                "
        +"\n                                            "        
        +"\n***********************************************");   
        startScene.setMapSymbol("ST");
	startScene.setItem(inventory[InventoryControl.ItemType.dagger.ordinal()]);
        game.addItemToBackpack(game.getInventory()[InventoryControl.ItemType.dagger.ordinal()]);
        scenes[SceneType.start.ordinal()] = startScene;
        
        Scene finishScene = new Scene();
        finishScene.setDescription("Congratulations! You have completed the dungeon! What will you do next?");
        finishScene.setMapSymbol("FN");
        scenes[SceneType.finish.ordinal()] = finishScene;
        
        // Monster and Treasure Encounters
        
        Scene room1Scene = new Scene();
        room1Scene.setDescription(
           
        "***********************************************"
        +"\n                                            "
        +"\n Rats inside the room shriek when they hear "
        +"\n the door open, then they run in all        "
        +"\n directions from a putrid corpse lying in   "
        +"\n the center of the floor. As these creatures"
        +"\n crowd around the edges of the room, seeking"
        +"\n to crawl through a hole in one corner, they"
        +"\n fight one another. The stinking corpse in  "
        +"\n the middle of the room looks human, but the"
        +"\n damage both time and the rats have wrought "
        +"\n are enough to make determining its race by "
        +"\n appearance an extremely difficult task at  "
	+"\n best.                                      "
        +"\n                                            "
        +"\n***********************************************");

        room1Scene.setMapSymbol("ZR");
        scenes[SceneType.room1.ordinal()] = room1Scene;

        Scene room2Scene = new Scene();
        room2Scene.setDescription(
	"***********************************************"
        +"\n                                            "
	+"\n The strong, sour-sweet scent of vinegar    "
	+"\n assaults your nose as you enter this room. " 
	+"\n Sundered casks and broken bottle glass     " 
	+"\n line the walls of this room. Clearly this  " 
	+"\n was someone's wine cellar for a time. The  "
	+"\n shards of glass are somewhat dusty, and    "
	+"\n the spilled wine is nothing more than a    "
	+"\n sticky residue in some places. Only one    "
	+"\n small barrel remains unbroken amid the     "
	+"\n rubbish.                                   "
	+"\n                                            "
        +"\n***********************************************");
        room2Scene.setMapSymbol("WC");
        room2Scene.setItem(inventory[InventoryControl.ItemType.basicShield.ordinal()]);
        scenes[SceneType.room2.ordinal()] = room2Scene;
        
        Scene room3Scene = new Scene();
        room3Scene.setDescription(
	"***********************************************"
        +"\n                                            "
	+"\n A chill wind blows against you as you open "
	+"\n the door. Beyond it, you see that the floor"
	+"\n and ceiling are nothing but iron grates.   "
	+"\n Above and below the grates the walls extend" 
	+"\n up and down with no true ceiling or floor  "
	+"\n within your range of vision. It's as though" 
	+"\n the chamber is a bridge through the shaft  "
	+"\n of a great well. Standing on the edge of   "
	+"\n this shaft, you feel a chill wind pass down" 
	+"\n it and over your shoulder into the hall    "
	+"\n beyond.                                    "
	+"\n                                            "
        +"\n***********************************************");
        room3Scene.setMapSymbol("GR");
        scenes[SceneType.room3.ordinal()] = room3Scene;
        
        Scene room4Scene = new Scene();
        room4Scene.setDescription(
	"***********************************************"
        +"\n                                            "
	+"\n You gaze into the room and hundreds of     "
	+"\n skulls gaze coldly back at you. They're    "
	+"\n set in niches in the walls in a            "
	+"\n checkerboard pattern, each skull bearing a "
	+"\n half-melted candle on its head. The        "
	+"\n grinning bones stare vacantly into the     "
	+"\n room, which otherwise seems empty.         "
	+"\n                                            "
        +"\n***********************************************");
        room4Scene.setMapSymbol("CE");
        room4Scene.setItem(inventory[InventoryControl.ItemType.basicArmor.ordinal()]);
        scenes[SceneType.room4.ordinal()] = room4Scene;
        
        Scene room5Scene = new Scene();
        room5Scene.setDescription(
	"***********************************************"
        +"\n                                            "
	+"\n You have entered an empty room as the      " 
	+"\n rusty door creaks shut!                    "
	+"\n                                            "
        +"\n***********************************************");
        room5Scene.setMapSymbol("SR");
        scenes[SceneType.room5.ordinal()] = room5Scene;
        
        Scene room6Scene = new Scene();
        room6Scene.setDescription(
	"***********************************************"
        +"\n                                            "
	+"\n The reek of garbage assaults your nose.    "
	+"\n Looking inside, you see a pile of refuse   "
	+"\n and offal that nearly reaches the ceiling. "
	+"\n In the ceiling above it is a small hole    "
	+"\n that is roughly as wide as two human hands."
	+"\n No doubt some city dweller high above      "
	+"\n disposes of his rubbish without ever       "
	+"\n thinking about where it goes.              "
	+"\n                                            "
        +"\n***********************************************");
        room6Scene.setMapSymbol("JR");
        scenes[SceneType.room6.ordinal()] = room6Scene;
        
        Scene room7Scene = new Scene();
        room7Scene.setDescription(
	"***********************************************"
        +"\n                                            "
	+"\n Many doors fill the room ahead. Doors of   " 
	+"\n varied shape, size, and design are set in  "
	+"\n every wall and even the ceiling and floor. "
	+"\n Barely a hand's width lies between one door"
	+"\n and the next. All the doors but the one    "
	+"\n you entered by are shut, and many have     "
	+"\n obvious locks.                             "
	+"\n                                            "
        +"\n***********************************************");
        room7Scene.setMapSymbol("EC");
        scenes[SceneType.room7.ordinal()] = room7Scene;
        
        Scene room8Scene = new Scene();
        room8Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n A skeleton dressed in moth-eaten garb lies "
        +"\n before a large open chest in the rear of   "
        +"\n this chamber. The chest is empty, but you  "
        +"\n note two needles projecting from the       "
        +"\n now-open lock. Dust coats something sticky "
        +"\n on the needles' points.                    "
	+"\n                                            "
        +"\n***********************************************");
        room8Scene.setMapSymbol("TR");
        scenes[SceneType.room8.ordinal()] = room8Scene;
        
        Scene room9Scene = new Scene();
        room9Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n Stinking smoke wafts up from braziers made "
        +"\n of skulls set around the edges of this     "
        +"\n room. The walls bear scratch marks and     "
        +"\n lines of soot that form crude pictures and "
        +"\n what looks like words in some language     "
        +"\n [Goblin]. To the left lies a pile of       "
        +"\n rubbish and rubble heaped into a crude     "
        +"\n dais. The dais has upon it an ironbound    "
        +"\n chest that has been painted with a         "
        +"\n goblinlike face. Furs and skins of unknown "
        +"\n origin are strewn haphazardly about the    "
        +"\n floor before the dais.                     "
	+"\n                                            "
        +"\n***********************************************");
        room9Scene.setMapSymbol("HR");       
        scenes[SceneType.room9.ordinal()] = room9Scene;
        
        Scene room10Scene = new Scene();
        room10Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n This room looks like it was designed by    " 
        +"\n drow. Rusted metal tiles create a huge     "
        +"\n mosaic of a spider in the floor, and       " 
        +"\n someone set up rusted gratings like        "
        +"\n draperies of webs. At the far end of the   "
        +"\n chamber, the carving of a spider squats on "
        +"\n the floor. It's about 3 feet tall and seems"
        +"\n molded into the floor. Beyond it stands    "
	+"\n tall double doors of stone, their surface  "
        +"\n coveredin a glittering web of gold.        "
	+"\n                                            "
        +"\n***********************************************");
        room10Scene.setMapSymbol("MR");
        room10Scene.setItem(inventory[InventoryControl.ItemType.sword.ordinal()]);
        scenes[SceneType.room10.ordinal()] = room10Scene;
        
        Scene room11Scene = new Scene();
        room11Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n The manacles set into the walls of this    "
        +"\n room give you the distinct impression that "
        +"\n it was used as a prison and torture        "
        +"\n chamber, although you can see no evidence  "
        +"\n of torture devices. One particularly large "
        +"\n set of manacles -- big enough for an       "
        +"\n ogre -- have been broken open.             "
	+"\n                                            "
        +"\n***********************************************");
        room11Scene.setMapSymbol("DU");        
        scenes[SceneType.room11.ordinal()] = room11Scene;
        
        Scene room12Scene = new Scene();
        room12Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n Rounded green stones set in the floor      "
        +"\n form a snake's head that points in the     "
        +"\n direction of the doorway you stand in.     "
        +"\n The body of the snake flows back and       "
        +"\n toward the wall to go round about the      "
        +"\n room in ever smaller circles, creating a   "
        +"\n spiral pattern on the floor. Similar       "
        +"\n green-stone snakes wend along the walls,   "
        +"\n seemingly at random heights, and their     "
        +"\n long bodies make wave shapes.              "
	+"\n                                            "
        +"\n***********************************************");
        room12Scene.setMapSymbol("ER");
        room12Scene.setItem(inventory[InventoryControl.ItemType.powerShield.ordinal()]);
        scenes[SceneType.room12.ordinal()] = room12Scene;
        
        Scene room13Scene = new Scene();
        room13Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n You open the door to a long narrow room    "
        +"\n with a high ceiling. Three thick circles   "
        +"\n of wood rest on wooden stands. You're not  "
        +"\n certain what they are because you came     "
        +"\n into the room behind them.                 "
	+"\n                                            "
        +"\n***********************************************");
        room13Scene.setMapSymbol("TC");        
        scenes[SceneType.room13.ordinal()] = room13Scene;
        
        Scene room14Scene = new Scene();
        room14Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n Huge rusted metal blades jut out of cracks "
        +"\n in the walls, and rusting spikes project   "
        +"\n down from the ceiling almost to the floor. "
        +"\n This room may have once been trapped       "
        +"\n heavily, but someone triggered them,       "
        +"\n apparently without getting killed. The     "
        +"\n traps were never reset and now seem        "
        +"\n rusted in place.                           "
	+"\n                                            "
        +"\n***********************************************");
        room14Scene.setMapSymbol("DG");
        room14Scene.setItem(inventory[InventoryControl.ItemType.powerArmor.ordinal()]);
        scenes[SceneType.room14.ordinal()] = room14Scene;
        
        Scene room15Scene = new Scene();
        room15Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n You enter a small room and your steps echo." 
        +"\n Looking about, you're uncertain why, but   "
        +"\n then a wall vanishes and reveals an        "
        +"\n enormous chamber. The wall was an illusion "
        +"\n and whoever cast it must be nearby!        "
	+"\n                                            "
        +"\n***********************************************");
        room15Scene.setMapSymbol("RE");        
        scenes[SceneType.room15.ordinal()] = room15Scene;
        
        Scene room16Scene = new Scene();
        room16Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n This room is hung with hundreds of dusty   "
        +"\n tapestries. All show signs of wear: moth   "
        +"\n holes, scorch marks, dark stains, and      "
        +"\n the damage of years of neglect. They hang  "
        +"\n on all the walls and hang from the ceiling "
        +"\n to brush against the floor, blocking your  "
        +"\n view of the rest of the room.              "
	+"\n                                            "
        +"\n***********************************************");
        room16Scene.setMapSymbol("TG");       
        scenes[SceneType.room16.ordinal()] = room16Scene;
        
        Scene room17Scene = new Scene();
        room17Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n This room holds six dry circular basins    "
        +"\n large enough to hold a man and a dry       "
        +"\n fountain at its center. All possess chipped" 
        +"\n carvings of merfolk and other sea          "
        +"\n creatures. It looks like this room once    "
        +"\n served some group of people as a bath.     "
	+"\n                                            "
        +"\n***********************************************");
        room17Scene.setMapSymbol("BA");       
        scenes[SceneType.room17.ordinal()] = room17Scene;

        Scene room18Scene = new Scene();
        room18Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n A dozen statues stand or kneel in this     "
        +"\n room, and each one lacks a head and stands "
        +"\n in a posture of action or defense. All are "
        +"\n garbed for battle. It's difficult to tell  "
        +"\n for sure without their heads, but two      "
        +"\n appear to be dwarves, one might be an elf, "
        +"\n six appear human, and the rest look like   "
        +"\n they might be orcs.                        "
	+"\n                                            "
        +"\n***********************************************");
        room18Scene.setMapSymbol("ST"); 
        scenes[SceneType.room18.ordinal()] = room18Scene;
        
        Scene room19Scene = new Scene();
        room19Scene.setDescription(
	"***********************************************"
        +"\n                                            "
        +"\n This tiny room holds a curious array of    "
        +"\n machinery. Winches and levers project from "
        +"\n every wall, and chains with handles dangle "
        +"\n from the ceiling. On a nearby wall, you    "
        +"\n note a pictogram of what looks like a      "
        +"\n scythe on a chain.                         "
	+"\n                                            "
        +"\n***********************************************");
        room19Scene.setMapSymbol("TI");        
        scenes[SceneType.room19.ordinal()] = room19Scene;
        
        // Riddle Scenes
        
        Scene fairiesScene = new Scene();
        fairiesScene.setDescription("You have entered the fairies domain!");
        fairiesScene.setMapSymbol("FD");
        scenes[SceneType.fairies.ordinal()] = fairiesScene;
        
        Scene blueWizardScene = new Scene();
        blueWizardScene.setDescription("You have entered the realm of the Blue Wizard!");
        blueWizardScene.setMapSymbol("BW");
        scenes[SceneType.blueWizard.ordinal()] = blueWizardScene;
        
        Scene trapScene = new Scene();
        trapScene.setDescription("You have fallen for a TRAP!");
        trapScene.setMapSymbol("RO");
        scenes[SceneType.trap.ordinal()] = trapScene;
        
        Scene dragonScene = new Scene();
        dragonScene.setDescription("You have entered the Dragon's Lair!");
        dragonScene.setMapSymbol("BR");
        scenes[SceneType.dragon.ordinal()] = dragonScene;
        
        return scenes;
    }    
    
    public enum SceneType{
        start,
        blueWizard,
        trap,
        dragon,
        room1,
        room2,
        room3,
        room4,
        room5,
        room6,
        room7,
        room8,
        room9,
        room10,
        room11,
        room12,
        room13,
        room14,
        room15,
        room16,
        room17,
        room18,
        room19,
        fairies,
        finish;
    }
    
    public static void movePlayerToStartingLocation(Map map) {
        try {
            // If starting location is not supposed to be 0,0 then use the correct values here.
            movePlayer(map, 0, 0); // or instead of 0,0 you can select a different starting location
        } catch (MapControlException ex) { // not used - dont' remove
//            Logger.getLogger(MapControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void movePlayer(Map map, int row, int column) 
        throws MapControlException{
        if (map == null)
            throw new MapControlException("Unitialized map");
        if (row < 0 || row >= map.getRowCount())
            throw new MapControlException("Invalid row. Try again.");
        if (column < 0 || column >= map.getColumnCount())
            throw new MapControlException("Invalid column. Try again.");
        map.setCurrentRow(row);
        map.setCurrentColumn(column);
        map.getCurrentLocation().setVisited(true);

    } 
        
}
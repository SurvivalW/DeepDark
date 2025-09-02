package Global;
public class GloabalStates {
    public static boolean inDungeon;
    public static boolean inTown;

    //Quests
    public static boolean firstswordDONE = false;
    public static boolean firstswordSTORE = false;
    public static boolean enteredDungeon = false;

    //enum for game states
    public static enum GameState {
        OUTSIDE,
        IN_TAVERN,
        IN_WEAPON_SHOP
    }

    //current game state
    public static GameState currentState;
}

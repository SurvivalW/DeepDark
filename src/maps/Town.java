package maps;
import Global.GloabalStates;
import Global.GloabalStates.GameState;
import Humanoids.Player;

public class Town {
    public static String[][] map;
    public Player player;

    public Town(Player player) 
    {
        this.player = player;

        map = new String[25][25];

        //start empty
        for (int i = 0; i < 25; i++) 
        {
            for (int j = 0; j < 25; j++) 
            {
                map[i][j] = ".";
            }
        }

        map[3][4] = "T";//tavern
        map[5][10] = "W";//Weapon shop

        map[21][14] = "D";//dungeon entrance

        //Spawn all roads
        map[4][4] = "R";
        map[4][5] = "R";
        map[4][6] = "R";
        map[4][7] = "R";
        map[4][8] = "R";
        map[4][9] = "R";
        map[5][9] = "R";
        map[6][9] = "R";
        map[7][9] = "R";

        //River
        map[19][0] = "~";
        map[19][1] = "~";
        map[19][2] = "~";
        map[19][3] = "~";
        map[19][4] = "~";
        map[19][5] = "~";
        map[19][6] = "~";
        map[19][7] = "~";
        map[19][8] = "~";
        map[19][9] = "~";
        map[19][10] = "~";
        map[19][11] = "~";
        map[19][12] = "~";
        map[19][13] = "~";
        map[19][14] = "~";
        map[19][15] = "~";
        map[19][16] = "~";
        map[19][17] = "~";
        map[19][18] = "~";
        map[19][19] = "~";
        map[19][20] = "~";
        map[19][21] = "~";
        map[19][22] = "~";
        map[19][23] = "~";
        map[19][24] = "~";

        map[18][0] = "~";
        map[18][1] = "~";
        map[18][2] = "~";
        map[18][3] = "~";
        map[18][4] = "~";
        map[18][5] = "~";
        map[18][6] = "~";
        map[18][7] = "~";
        map[18][8] = "~";
        map[18][9] = "~";
        map[18][10] = "~";
        map[18][11] = "~";
        map[18][12] = "~";
        map[18][13] = "~";
        map[18][14] = "~";
        map[18][15] = "~";
        map[18][16] = "~";
        map[18][17] = "~";
        map[18][18] = "~";
        map[18][19] = "~";
        map[18][20] = "~";
        map[18][21] = "~";
        map[18][22] = "~";
        map[18][23] = "~";
        map[18][24] = "~";
    }

    public void showMap()
    {
        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 25; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void updatePlayer()//program note: yx
    {
        for (int i = 0; i < 25; i++) 
        {
            for (int j = 0; j < 25; j++) 
            {
                if(map[i][j] == "P")
                {
                    map[i][j] = ".";
                }
                else if(map[i][j] == "t")
                {
                    map[i][j] = "T";
                }
                else if(map[i][j] == "w")
                {
                    map[i][j] = "W";
                }
                else if(map[i][j] == "r")
                {
                    map[i][j] = "R";
                }
                else if(map[i][j] == "b")
                {
                    map[i][j] = "B";
                }
            }
        }

        //cap positions so they stay within 0–24
        if(player.xPos < 0) player.xPos = 0;
        if(player.xPos > 24) player.xPos = 24;

        if(player.yPos < 0) player.yPos = 0;
        if(player.yPos > 24) player.yPos = 24;

        if(map[player.yPos][player.xPos] == "T")
        {
            map[player.yPos][player.xPos] = "t";
            GloabalStates.currentState = GameState.IN_TAVERN;
        }
        else if(map[player.yPos][player.xPos] == "W")
        {
            map[player.yPos][player.xPos] = "w";
            GloabalStates.currentState = GameState.IN_WEAPON_SHOP;
        }
        else if(map[player.yPos][player.xPos] == ".")
        {
            map[player.yPos][player.xPos] = "P";
            GloabalStates.currentState = GameState.OUTSIDE;
        }
        else if(map[player.yPos][player.xPos] == "R")
        {
            map[player.yPos][player.xPos] = "r";
            GloabalStates.currentState = GameState.OUTSIDE;
        }
        else if(map[player.yPos][player.xPos] == "B")
        {
            map[player.yPos][player.xPos] = "b";
            GloabalStates.currentState = GameState.OUTSIDE;
        }
    }
}

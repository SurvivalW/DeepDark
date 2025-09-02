import java.util.ArrayList;
import java.util.Scanner;
import Humanoids.NPC;
import Humanoids.Player;
import Items.Food;
import Items.Item;
import maps.Town;
import Global.GloabalStates;
import Global.GloabalStates.GameState;

public class GamePlay {
    public static boolean running; 

    //initialize
    Player player = new Player(null);
    public static ArrayList<NPC> NPCs = new ArrayList<NPC>();

    public Town town = new Town(player);
    public static NPC Ford = new NPC("Ford", "Tavern", "Acquaintance");

    public static boolean doneTut = false;

    //NPC's
    public static boolean charWilliamUnlock;

    //colors for terminal
    public static final String RESET = "\u001b[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";


    /**
     * clears screen to keep it tidy
     */
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * this takes text or the dialogue and turns it into 
     * individual chars that will be printed with a wait time of 65 millis
     * @param text
     * @throws InterruptedException
     */
    public static void dialogue(String text) throws InterruptedException
    {
        char[] chars = text.toCharArray();

        for (char c : chars) 
        {
            Thread.sleep(65);
            System.out.print(c);
        }
        System.out.println();
    }


    //CMDs
    public void map()
    {
        clearScreen();
        if (GloabalStates.inTown)
        {
            town.showMap();
        }
        if (GloabalStates.inDungeon)
        {

        }
    }

    public static void see() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        String input;

        ArrayList<NPC> npcShown = new ArrayList<NPC>();
        if (GloabalStates.currentState == GameState.IN_TAVERN)
        {
            //base
            clearScreen();
            System.out.println(GREEN + "\nTavern       *enter there name to talk to them*" + RESET);
            System.out.println("-------------------");
            System.out.println(BLUE + "Name---Relationship\n" + RESET);

            for(NPC npc : NPCs)
            {
                if(npc.location.equalsIgnoreCase("tavern"))
                {
                    npcShown.add(npc);
                }
            }

            for(NPC npc : npcShown)
            {
                System.out.println(npc.name + "   -  " + npc.relationship);
            }
        }
        System.out.println(BLUE + "\n'back': go back" + RESET);

        while(true)
        {
            input = scan.nextLine();

            if(input.equalsIgnoreCase("ford"))
            {
                if(GloabalStates.firstswordDONE == false && GloabalStates.firstswordSTORE == false)
                {
                    dialogue("Ford: \"Ahoy! I see you you don't have a sword, here I'll give you my old sword from back in my day...\" *SHING*");
                    dialogue(RED + "+lvl-1 Sword" + RESET);
                    dialogue("You: \"Oh! thank you Ford that's very kind of you.\"");
                    dialogue("Ford: \"Don't sweat it!\"");
                    GloabalStates.firstswordDONE = true;
                    player.
                }
                else if(GloabalStates.firstswordSTORE == true && GloabalStates.enteredDungeon == false)
                {
                    dialogue("Ford: \"Ahoy! I see you already got a sword, well better get the dungeon!\"");
                    dialogue("You: \"....\"");
                }
                else//normal reply
                {
                    dialogue("Ford: \"Ahoy! I don't have a lot to talk about right now.\"");
                }
            }
            else if(input.equalsIgnoreCase("back"))
            {
                clearScreen();
                break;
            }
            else
            {
                System.out.println(BLUE + "Please enter a valid command" + RESET);
            }
        }
    }

    public void ls()
    {
        clearScreen();
        //basic stuff
        System.out.println(GREEN + "Movement: " + BLUE + "\nmovel - Move left\nmover - Move right\nmoveu - Move up\nmoved - Move down");
        System.out.println(GREEN + "Basic:" + BLUE + "\nm - map\nc - see\ninv - inventory\nls - cmd's" + RESET);
        if(GloabalStates.currentState == GameState.IN_TAVERN)//tavern only
        {
            System.out.println(GREEN + "\nTavern:" + BLUE + "\nsleep - get a room for the night" + RESET + "(" + RED + "Mana+15% HP+10%" + RESET + ")" + YELLOW + " ¥35" + BLUE + "\nmenu - see the food menu" + RESET);
        }
        if(GloabalStates.currentState == GameState.IN_WEAPON_SHOP)//weapon shop only
        {
            System.out.println(GREEN + "\nWeapon shop:           *Type the number to buy.*" + BLUE + "\n1 - lvl-1 Sword" + RESET + "(" + RED + "DMG:3" + RESET + ")" + YELLOW + " ¥35" + RESET);
        }
    }

    public void inventory()
    {
        Scanner scan = new Scanner(System.in);
        String input;

        clearScreen();
        System.out.println(YELLOW + "¥" + player.Money + RESET);
        System.out.println(RED + "HP: " + player.HP + "/" + player.MaxHP + RESET);
        System.out.println(RED + "Mana: " + player.Mana + "/" + player.MaxMana + RESET);
        System.out.println("-----------------");

        for(int i = 0; i < player.inventory.size(); i++)
        {
            Item item = player.inventory.get(i);
            int printNum = i + 1;

            if(item instanceof Food)
            {
                Food food = (Food) item;
                System.out.println(printNum + ":" + food.itemName + " |lvl: " + food.lvl + "|+HP: " + food.HP + "||*type " + printNum + " to eat*");
            }
        }

        System.out.println(BLUE + "\n'back': go back" + RESET);

        while(true)
        {
            input = scan.nextLine();
            if(input.equalsIgnoreCase("back"))
            {
                clearScreen();
                return;
            }
            else
            {
                System.out.println(BLUE + "Please enter a valid command" + RESET);
            }
        }
    }




    //TAVERN
    public void sleep() throws InterruptedException
    {
        float bonusHP = player.MaxHP * 0.1f;
        float bonusMana = player.MaxMana * 0.15f;
        player.setHP(player.HP + bonusHP);
        player.setMana(player.Mana + bonusMana);
        clearScreen();
        dialogue("You: \".....\"");
        System.out.println(RED + "Mana: " + player.Mana + "/" + player.MaxMana + "  -  "  + player.HP + "/" + player.MaxHP + RESET);
    }
    public void menu() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        String input;

        clearScreen();
        System.out.println("------------------");
        System.out.println("'1':" + BLUE + "Steak & Potatoes" + RESET + "(" + RED + "7+HP" + RESET + ")" + YELLOW + "¥10" + RESET);

        System.out.println(BLUE + "'back': go back" + RESET);

        while(true)
        {
            input = scan.nextLine();
            if(input.equalsIgnoreCase("1"))
            {
                player.setMoney(player.Money - 10);
                player.inventory.add(new Food("Steak & Potatoes", 7, 10, 1));
                dialogue(RED + "+Steak & Potatoes" + RESET);
            }
            else if(input.equalsIgnoreCase("back"))
            {
                clearScreen();
                return;
            }
            else
            {
                System.out.println(BLUE + "Please enter a valid command" + RESET);
            }
        }
    }



    public void tutorial() throws InterruptedException
    {
        town.updatePlayer();

        //add ford right quick...
        NPCs.add(Ford);

        player.setMoney(53);//start money
        player.setMaxMana(20);//start mana
        player.setMana(20);
        player.setMaxHP(15);
        player.setHP(15);

        Scanner scan = new Scanner(System.in);
        String input;



        clearScreen();
        // dialogue("*BOOOM*");
        // dialogue("Ford: \"..hey...Hey, traveler, wake up!\"");
        // dialogue("You: \"...wha—?\"");
        // dialogue("Ford: \"Did you feel that shake? The whole tavern rattled... it can only mean one thing.\"");
        // dialogue("You: \"...still half asleep here, Ford. What's going on?\"");
        // dialogue("Ford: \"Didn't you say you were trained under the king's knights?\"");
        // dialogue("You: \"Yes, I was. Why?\"");
        // dialogue("Ford: \"Then maybe you can handle this. They say" + RED + " Dima's dungeon" + RESET + " has risen again.\"");
        // dialogue("You: \"" + RED + "Dima's dungeon?" + RESET + " Never heard of it.\"");
        // dialogue("Ford: \"It's no ordinary place... Long ago, there was a warlord named Dima. Cruel, bloodthirsty—he carved his fortress deep beneath the earth. When the king's army finally brought him down, the ground swallowed the fortress whole.\"");
        // dialogue("You: \"And now it's... back?\"");
        // dialogue("Ford: \"Aye. Every few generations, the dungeon claws its way to the surface. Each time it does, plague and monsters spill from it, and villages vanish overnight.\"");
        // dialogue("You: \"...And you expect me to walk into that hell alone?\"");
        // dialogue("Ford: \"I wouldn't ask, but we've got no choice. If someone doesn't enter soon, the whole valley is finished.\"");
        // dialogue("You: \"...Then I'll go, Ford. I'll see this dungeon with my own eyes.\"");
        // dialogue("Ford: \"Thank the gods. Just be careful... Dima is still down there waiting....\"");
        // dialogue("You: \"If that's true, he'll regret waiting for me.\"");

        GloabalStates.inTown = true;
        GloabalStates.currentState = GameState.IN_TAVERN;

        //tut before freedom XD
        System.out.println(BLUE + "\nYou get out of bed and head down the tavern's stairs. Type 'C' to list the people around you." + RESET);
        while(true)
        {
            input = scan.nextLine();
            if(input.equalsIgnoreCase("c"))
            {
                see();
                break;
            }
            else
            {
                System.out.println(BLUE + "Type 'C'" + RESET);
            }
        }
        System.out.println(BLUE + "\nType 'M' to see your map" + RESET);
        while(true)
        {
            input = scan.nextLine();
            if(input.equalsIgnoreCase("m"))
            {
                map();
                System.out.println(BLUE + "\nTip! when the letter is lowercase that means your on that tile\nif you go on the grass or '.' then your 'P' marker will apear." + RESET);
                System.out.println(BLUE + "One other thing, to move you enter \"movel\"-Move left|\"mover\"-Move right|\"moveu\"-Move up|\"moved\"-Move down" + RESET);
                break;
            }
            else
            {
                System.out.println(BLUE + "Type 'M'" + RESET);
            }
        }
        System.out.println(BLUE + "\nType 'inv' to see your inventory, HP and how much ¥ you have." + RESET);
        while(true)
        {
            input = scan.nextLine();
            if(input.equalsIgnoreCase("inv"))
            {
                inventory();
                break;
            }
            else
            {
                System.out.println(BLUE + "Type inv" + RESET);
            }
        }
        System.out.println(BLUE + "\nType 'ls' to list out everything you can do" + RESET);
        while(true)
        {
            input = scan.nextLine();
            if(input.equalsIgnoreCase("ls"))
            {
                ls();
                break;
            }
            else
            {
                System.out.println(BLUE + "Type 'ls'" + RESET);
            }
        }

        System.out.println(BLUE + "\n\nLet's pick out your name: (enter your name)" + RESET);
        input = scan.nextLine();
        player.setName(input);
        System.out.println(BLUE + player.Name + ", may the gods be with you..." + RESET);

        while(true)
        {
            System.out.println(BLUE + "\nType 'R' when your ready to start (:" + RESET);
            input = scan.nextLine();
            if(input.equalsIgnoreCase("r"))
            {
                doneTut = true;
                clearScreen();
                Update();
            }
            else
            {
                System.out.println(BLUE + "Type 'r'" + RESET);
            }
        }
    }

    public void Update() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        String input;
        running = true;
        while(running)
        {
            input = scan.nextLine();
            Handlecmd(input);
        }
    }

    public void Handlecmd(String cmd) throws InterruptedException
    {
        cmd = cmd.toLowerCase();

        //MOVEMENT
        if (cmd.startsWith("movel") || cmd.startsWith("mover") || cmd.startsWith("moveu") || cmd.startsWith("moved")) 
        {
            char direction = cmd.charAt(4); // 'l', 'r', 'u', or 'd'
            int amount = 1;

            if (cmd.length() > 5)
            {
                try {
                    amount = Integer.parseInt(cmd.substring(5));
                } catch (NumberFormatException e) {
                    //just use one
                }
            }   

            switch (direction) {
                case 'l' -> player.movePlayer(player.xPos - amount, player.yPos);
                case 'r' -> player.movePlayer(player.xPos + amount, player.yPos);
                case 'u' -> player.movePlayer(player.xPos, player.yPos - amount);
                case 'd' -> player.movePlayer(player.xPos, player.yPos + amount);
            }

            town.updatePlayer();
        }


        //TAVERN
        if(GloabalStates.currentState == GameState.IN_TAVERN)
        {
            if(cmd.equals("sleep"))
            {
                if(player.Money >= 35)
                {
                    player.Money -= 35;
                    sleep();
                }
                else
                {
                    System.out.println(BLUE + "Not enough ¥" + RESET);
                }
            }

            if(cmd.equals("menu"))
            {
                menu();
            }
        }

        //WEAPON STORE
        if(GloabalStates.currentState == GameState.IN_WEAPON_SHOP)
        {
            
        }



        //BASIC
        if(cmd.equals("ls"))
        {
            ls();
        }
        else if(cmd.equals("m"))
        {
            map();
        }
        else if(cmd.equals("c"))
        {
            see();
        }
        else if(cmd.equals("inv"))
        {
            inventory();
        }
    }
}

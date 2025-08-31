import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {
    public static boolean running; 

    //initialize
    public static ArrayList<NPC> NPCs = new ArrayList<NPC>();

    public static Town town = new Town();
    public static NPC Ford = new NPC("Ford", "Tavern", "Acquaintance");

    //Game state vars
    public static boolean inTown;//MAIN
    public static boolean outside;//child to town
    public static boolean inTavern;//child to town
    public static boolean inWeaponShop;//child to town
    public static boolean inFoodShop;//child to town

    public static boolean inDungeon;//MAIN

    //NPC's
    public static boolean charWilliamUnlock;

    //Player
    public static String Name;


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


    public static void map()
    {
        clearScreen();
        if (inTown)
        {
            town.showMap();
        }
        if (inDungeon)
        {

        }
    }

    public static void see()
    {
        ArrayList<NPC> npcShown = new ArrayList<NPC>();
        if (inTavern)
        {
            //base
            clearScreen();
            System.out.println("\nTavern");
            System.out.println("-------------------");
            System.out.println("Name---Relationship\n");

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
    }

    public void ls()
    {
        clearScreen();
        //basic stuff
        System.out.println("Basic:\nm - map\nc - see\nls - cmd's");
        if(inTavern)//tavern only
        {
            System.out.println("Tavern:\nsleep - get a room for the night(HP+70%) ¥45\nmenu - see the food menu");
        }
    }


    public void start() throws InterruptedException
    {
        //add ford right quick...
        NPCs.add(Ford);

        Scanner scan = new Scanner(System.in);
        String input;

        String red = "\u001b[31m";
        String reset = "\u001b[0m";


        clearScreen();
        dialogue("*BOOOM*");
        dialogue("Ford: \"..hey...Hey, traveler, wake up!\"");
        dialogue("You: \"...wha—?\"");
        dialogue("Ford: \"Did you feel that shake? The whole tavern rattled... it can only mean one thing.\"");
        dialogue("You: \"...still half asleep here, Ford. What's going on?\"");
        dialogue("Ford: \"Didn't you say you were trained under the king's knights?\"");
        dialogue("You: \"Yes, I was. Why?\"");
        dialogue("Ford: \"Then maybe you can handle this. They say" + red + " Dima's dungeon" + reset + " has risen again.\"");
        dialogue("You: \"" + red + "Dima's dungeon?" + reset + " Never heard of it.\"");
        dialogue("Ford: \"It's no ordinary place... Long ago, there was a warlord named Dima. Cruel, bloodthirsty—he carved his fortress deep beneath the earth. When the king's army finally brought him down, the ground swallowed the fortress whole.\"");
        dialogue("You: \"And now it's... back?\"");
        dialogue("Ford: \"Aye. Every few generations, the dungeon claws its way to the surface. Each time it does, plague and monsters spill from it, and villages vanish overnight.\"");
        dialogue("You: \"...And you expect me to walk into that hell alone?\"");
        dialogue("Ford: \"I wouldn't ask, but we've got no choice. If someone doesn't enter soon, the whole valley is finished.\"");
        dialogue("You: \"...Then I'll go, Ford. I'll see this dungeon with my own eyes.\"");
        dialogue("Ford: \"Thank the gods. Just be careful... Dima is still down there waiting....\"");
        dialogue("You: \"If that's true, he'll regret waiting for me.\"");

        inTown = true;
        inTavern = true;

        //tut before freedom XD
        System.out.println("\nYou get out of bed and head down the tavern's stairs. Type 'C' to list the people around you.");
        input = scan.nextLine();
        if(input.equalsIgnoreCase("c"))
        {
            see();
        }
        System.out.println("\nType 'M' to see your map");
        input = scan.nextLine();
        if(input.equalsIgnoreCase("m"))
        {
            map();
            System.out.println("\nTip! when the letter is lowercase that means your on that tile\nif you go on the grass or '.' then your 'P' marker will apear.");
        }
        System.out.println("\nType 'ls' to list out everything you can do");
        input = scan.nextLine();
        if(input.equalsIgnoreCase("ls"))
        {
            ls();
            System.out.println("\n\nLet's pick out your name: (enter your name)");
            input = scan.nextLine();
            Name = input;
            System.out.println(Name + ", may the gods be with you...");
        }

        System.out.println("\nType 'R' when your ready to start (:");
        input = scan.nextLine();
        if(input.equalsIgnoreCase("r"))
        {
            clearScreen();
            Update();
        }
    }

    public void Update()
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

    public void Handlecmd(String cmd)
    {
        if(cmd.equalsIgnoreCase("ls"))
        {
            ls();
        }
    }
}

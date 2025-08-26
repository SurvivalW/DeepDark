import java.util.Scanner;

public class GamePlay {
    //initialize
    public static Town town = new Town();

    //Game state vars
    public static boolean inTown;//MAIN
    public static boolean outside;//child to town
    public static boolean inTavern;//child to town
    public static boolean inWeaponShop;//child to town
    public static boolean inFoodShop;//child to town

    public static boolean inDungeon;//MAIN


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


    public static void Map()
    {
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

    }


    public void start() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);

        String input;

        String red = "\u001b[31m";
        String reset = "\u001b[0m";


        clearScreen();
        dialogue("*BOOOM*");
        dialogue("Ford: \"..hey...Hey, traveler, wake up!\"");
        dialogue("You: \"...wha—?\"");
        dialogue("Ford: \"Did you feel that shake? The whole tavern rattled... it can only mean one thing.\"");
        dialogue("You: \"...still half asleep here, Ford. What’s going on?\"");
        dialogue("Ford: \"Didn’t you say you were trained under the king’s knights?\"");
        dialogue("You: \"Yes, I was. Why?\"");
        dialogue("Ford: \"Then maybe you can handle this. They say" + red + " Dima's dungeon" + reset + " has risen again.\"");
        dialogue("You: \"" + red + "Dima's dungeon?" + reset + " Never heard of it.\"");
        dialogue("Ford: \"It’s no ordinary place... Long ago, there was a warlord named Dima. Cruel, bloodthirsty—he carved his fortress deep beneath the earth. When the king’s army finally brought him down, the ground swallowed the fortress whole.\"");
        dialogue("You: \"And now it’s... back?\"");
        dialogue("Ford: \"Aye. Every few generations, the dungeon claws its way to the surface. Each time it does, plague and monsters spill from it, and villages vanish overnight.\"");
        dialogue("You: \"...And you expect me to walk into that hell alone?\"");
        dialogue("Ford: \"I wouldn’t ask, but we’ve got no choice. If someone doesn’t enter soon, the whole valley is finished.\"");
        dialogue("You: \"...Then I’ll go, Ford. I’ll see this dungeon with my own eyes.\"");
        dialogue("Ford: \"Thank the gods. Just be careful... Dima is still down there waiting....\"");
        dialogue("You: \"If that’s true, he’ll regret waiting for me.\"");

        inTown = true;

        //tut before freedom XD
        System.out.println("\nYou get out of bed and head down the tavern’s stairs. Type 'C' to list the people around you.");
        input = scan.nextLine();
        if(input.equalsIgnoreCase("c"));
        {
            see();
        }
        System.out.println("Type 'M' to see your map");
        input = scan.nextLine();
        if(input.equalsIgnoreCase("m"));
        {
            Map();
        }
    }
}

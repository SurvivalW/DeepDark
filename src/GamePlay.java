public class GamePlay {

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


    public void start() throws InterruptedException
    {
        String red = "\u001b[31m";
        String reset = "\u001b[0m";


        clearScreen();
        dialogue("Ford: \"..hey...Hey wake up traveler..\"");
        dialogue("You: \"...\"");
        dialogue("Ford: \"Didn’t you say you were trained under the king’s knights?\"");
        dialogue("You: \"...hmm?...Oh! yes, yes I was Ford.");
        dialogue("Ford: \"Perfect, then will you save our town and go into" + red + " Dima's dungeon\"" + reset);
        dialogue("You: \"" + red + "Dima's dungeon?" + reset + " What is that?\"");
    }
}

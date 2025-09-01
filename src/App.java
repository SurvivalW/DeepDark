import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        mainMenu();
    }

    public static void mainMenu() throws InterruptedException
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello Welcome to Deep Dark, To get started Choose a save or start fresh.");
        System.out.println("Type \"1\" for first save.");
        System.out.println("Type \"2\" for second save.");
        System.out.println("Type \"3\" for third save.");
        System.out.println("--------");
        System.out.println("Or type \"Start\" to start fresh.");

        if (input.hasNextInt())
        {
            int savePicked = input.nextInt();
            if (savePicked > 3 || savePicked < 1)
            {
                System.out.println("Please enter 1, 2 or 3");
            }
            else
            {
                switch (savePicked) 
                {
                    case 1:

                        break;
                
                    case 2:

                        break;

                    case 3:

                        break;
                    default:
                        break;
                }
            }
        }
        else if(input.hasNext())
        {
            String userString = input.nextLine();
            if(userString.equalsIgnoreCase("start"))
            {
                GamePlay fresh = new GamePlay();
                fresh.tutorial();
            }
        }
    }
}

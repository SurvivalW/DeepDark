public class Town {
    public static String[][] map;

    public Town() 
    {
        map = new String[25][25];

        for (int i = 0; i < 25; i++) 
        {
            for (int j = 0; j < 25; j++) 
            {
                map[i][j] = ".";
            }
        }


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
}

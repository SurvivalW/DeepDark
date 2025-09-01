public class Player {
    public String Name;
    public int HP;
    public int MaxHP;
    public int Money;

    public Player(String Name)
    {
        this.Name = Name;
    }


    public void setHP(int HP)
    {
        if(HP <= MaxHP)
        {
            this.HP = HP;
        }
    }


    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getName()
    {
        return Name;
    }
}

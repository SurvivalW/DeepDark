public class Player {
    public String Name;
    public float HP;
    public float MaxHP;
    public int Money;

    public Player(String Name)
    {
        this.Name = Name;
    }


    public void setHP(float HP)
    {
        if(HP <= MaxHP)
        {
            this.HP = HP;
        }
    }

    public void setMaxHP(float MaxHP)
    {
        this.MaxHP = MaxHP;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public void setMoney(int newMoney)
    {
        Money = newMoney;
    }
}

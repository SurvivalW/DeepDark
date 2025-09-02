package Humanoids;
import java.util.ArrayList;
import Items.Item;

public class Player {
    public String Name;
    public float HP;
    public float MaxHP;
    public float Mana;
    public float MaxMana;
    public int Money;

    public int xPos = 4;
    public int yPos = 3;

    public ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(String Name)
    {
        this.Name = Name;
    }


    public void setHP(float newHP)
    {
        if(newHP <= MaxHP)
        {
            this.HP = newHP;
        }
    }

    public void setMaxHP(float MaxHP)
    {
        this.MaxHP = MaxHP;
    }

    public void setMana(float newMana)
    {
        if(newMana <= MaxMana)
        {
            this.Mana = newMana;
        }
    }

    public void setMaxMana(float MaxMana)
    {
        this.MaxMana = MaxMana;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public void setMoney(int newMoney)
    {
        Money = newMoney;
    }

    public void movePlayer(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}

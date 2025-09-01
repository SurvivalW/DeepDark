package Items;

public class Food extends Item {
    public int HP;
    
    public Food(String itemName, int HP, int Price, int lvl)
    {
        this.itemName = itemName;
        this.HP = HP;
        this.Price = Price;
        this.lvl = lvl;
    }
}

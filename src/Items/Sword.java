package Items;

public class Sword extends Item {
    public int DMG;
    
    public Sword(String itemName, int Price, int lvl, int DMG)
    {
        this.itemName = itemName;
        this.Price = Price;
        this.lvl = lvl;
        this.DMG = DMG;
    }
}

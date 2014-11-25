package pheonixTeam.main.entity.living;

import pheonixTeam.main.Map;
import pheonixTeam.main.entity.enums.PrimaryClasses;
import pheonixTeam.main.entity.enums.Races;
import pheonixTeam.main.entity.enums.SecondaryClasses;
import pheonixTeam.main.item.Item;

import java.util.List;

/**
 * @author Strikingwolf
 */
public class EntityPlayer extends EntityLiving
{
    private int heldItemIndex = 0;
    public Item heldItem;
    public List<Item> inventory;

    public void switchHeldItemRight() {
        heldItemIndex++;
        heldItem = inventory.get(heldItemIndex);
    }

    public Item getHeldItem() {
        return inventory.get(heldItemIndex);
    }

    @Override
    public void update(Map map) {
        super.update(map);
        heldItem = inventory.get(heldItemIndex);
    }

    //Race
    public Races race = Races.NONE;

    //Class
    public PrimaryClasses primaryClass = PrimaryClasses.NONE;
    public SecondaryClasses secondaryClass = SecondaryClasses.NONE;

    //Stats
    int constitution = 0;
    int strength = 0;
    int dexterity = 0;
    int wisdom = 0;
}
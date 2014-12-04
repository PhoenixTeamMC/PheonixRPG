package pheonixTeam.main.entity.living.enemy;

import pheonixTeam.main.entity.Entity;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.map.Map;

import java.util.ArrayList;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class EntityEnemy extends EntityLiving
{
    public Entity target;
    public float trackRangeX;
    public float trackRangeY;
    public float attackRangeX;
    public float attackRangeY;

    public EntityEnemy(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(Map map) {
        ArrayList<Entity> entitiesWithin = map.getEntitiesWithin(x, y, trackRangeX, trackRangeY);
        ArrayList<Entity> validTargets = new ArrayList<Entity>();
        for (Entity entity : entitiesWithin) {
            if (!(entity instanceof EntityEnemy)) {
                validTargets.add(entity);
            }
        }
        target = map.getClosestEntityOutOf(x, y, validTargets);
        moveToEntity(target, attackRangeX - 1, attackRangeY - 1);
    }
}

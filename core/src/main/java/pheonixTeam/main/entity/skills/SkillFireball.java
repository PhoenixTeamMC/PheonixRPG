package pheonixTeam.main.entity.skills;

import pheonixTeam.main.entity.EntityFireball;
import pheonixTeam.main.entity.enums.PrimaryClasses;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.entity.living.player.EntityPlayer;
import pheonixTeam.main.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class SkillFireball extends Skill
{
    public SkillFireball() {
    	super("Fireball");
    }

    @Override
    public void doSkill(EntityLiving entity) {
        if (entity.mana >= 20) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                if (player.primaryClass == PrimaryClasses.MAGE) {
                    if (checkIfEntityHasSkill(entity, this)) {
                        Map.entityList.add(new EntityFireball(player.x, player.y, player.facing));
                        player.mana -= 20;
                    }
                }
            } else if (checkIfEntityHasSkill(entity, this)) {
                entity.map.spawnEntity(new EntityFireball(entity.x, entity.y, entity.facing));
                entity.mana -= 20;
            }
        }
    }
}
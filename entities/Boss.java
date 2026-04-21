package entities;

import entities.boss.behavior.*;

public class Boss extends GameEntity {
    private final String intro;
    private BossBehaviorStrategy bossBehavior = new DefaultBossBehavior();

    // Updated constructor to include name and intro
    public Boss(String name, String intro, double initHp) {
        super(initHp, name);
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }
  
    @Override
    public void attack(GameEntity target, double modifier) {
        if (bossBehavior != null) {
            double damage = bossBehavior.calculateDamage() * modifier;
            target.updateHp(-damage);
        }
    }

    public void setBossBehavior(BossBehaviorStrategy behavior) {
        this.bossBehavior = behavior;
    }
}
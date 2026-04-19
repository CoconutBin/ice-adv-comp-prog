package entities.boss;

import entities.GameEntity;
import entities.boss.behavior.*;

public class Boss extends GameEntity {
    private BossBehaviorStrategy bossBehavior = new DefaultBossBehavior();

    public Boss(double initialHp) {
        super(initialHp, "Boss");
    }

    @Override
    public void attack(GameEntity target) {
        double damage = bossBehavior.calculateDamage();
        target.updateHp(-damage);
    }

    public void setBossBehavior(BossBehaviorStrategy behavior) {
        this.bossBehavior = behavior;
    }
}

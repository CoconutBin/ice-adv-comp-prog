package entities.observers;

import entities.GameEntity;
import entities.boss.Boss;
import entities.boss.behavior.*;

public class BossBehaviorObserver extends EntityObserver {
    @Override
    public void onHpChange(GameEntity entity) {
        if (!(entity instanceof Boss)) return;
        Boss boss = (Boss) entity;
        double hpPercentage = boss.getHp() / boss.getMaxHp();
        if (hpPercentage > 0.5) {
            boss.setBossBehavior(new DefaultBossBehavior());
        } else if (hpPercentage > 0.2) {
            boss.setBossBehavior(new MidHPBossBehavior());
        } else {
            boss.setBossBehavior(new LowHPBossBehavior());
        }
    }

    @Override
    public void onEntityDeath(GameEntity entity) {
        // Handle boss death event
    }
}

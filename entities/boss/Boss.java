package entities.boss;

import entities.GameEntity;
import entities.boss.behavior.*;

public class Boss extends GameEntity {
    private final String name;
    private final String intro;
    private BossBehaviorStrategy bossBehavior;

    // Updated constructor to include name and intro
    public Boss(String name, String intro, double init_hp) {
        super(init_hp);
        this.name = name;
        this.intro = intro;
    }

    // Getters for name and intro so Visuals can use them
    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    @Override
    public void attack(GameEntity target) {
        if (bossBehavior != null) {
            double damage = bossBehavior.calculateDamage();
            target.updateHp(-damage);
        }
    }

    public void setBossBehavior(BossBehaviorStrategy behavior) {
        this.bossBehavior = behavior;
    }
}
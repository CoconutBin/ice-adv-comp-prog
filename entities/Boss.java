package entities;

import entities.boss.behavior.*;

public class Boss extends GameEntity {
    private final String intro;
    private BossBehaviorStrategy bossBehavior = new DefaultBossBehavior();
    private BossPhase bossPhase = BossPhase.DEFAULT;

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

    public BossPhase getBossPhase(){
        return bossPhase;
    }

    public void setBossBehavior(BossBehaviorStrategy behavior) {
        this.bossBehavior = behavior;
    }

    @Override
    protected void updateHp(double hpChange) {
        super.updateHp(hpChange);
        double hpPercentage = this.getHp() / this.getMaxHp(); 

        if (hpPercentage <= 0.0) {
            this.bossPhase = BossPhase.DEFEAT;
        } 
        else if (hpPercentage <= 0.2) {
            this.bossPhase = BossPhase.LOW_HP;
            setBossBehavior(new LowHPBossBehavior());
        } 
        else if (hpPercentage <= 0.5) {
            this.bossPhase = BossPhase.MID_HP;
            setBossBehavior(new MidHPBossBehavior());
        }
    }
}
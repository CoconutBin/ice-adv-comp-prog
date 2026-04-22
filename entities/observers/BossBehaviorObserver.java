package entities.observers;

import game.io.IOHandler;
import entities.Boss;
import entities.BossPhase;
import entities.GameEntity;
import entities.boss.behavior.DefaultBossBehavior;
import entities.boss.behavior.LowHPBossBehavior;
import entities.boss.behavior.MidHPBossBehavior;

public class BossBehaviorObserver implements EntityObserver {
    private final IOHandler ioHandler;
    private final Boss boss;

    public BossBehaviorObserver(IOHandler ioHandler, Boss boss) {
        this.ioHandler = ioHandler;
        this.boss = boss;
    }

    @Override
    public void onHpChange(GameEntity entity) {
        double hpPercentage = boss.getHp() / boss.getMaxHp();
        
        BossPhase newPhase;
        if (hpPercentage <= 0.0) {
            boss.setBossBehavior(new DefaultBossBehavior());
            newPhase = BossPhase.DEFEAT;
        } else if (hpPercentage <= 0.2) {
            boss.setBossBehavior(new LowHPBossBehavior());
            newPhase = BossPhase.LOW_HP;
        } else if (hpPercentage <= 0.5) {
            boss.setBossBehavior(new MidHPBossBehavior());
            newPhase = BossPhase.MID_HP;
        } else {
            return;
        }
        
        ioHandler.printTyping(newPhase.getColor().apply("[!] " + boss.getName() + ": " + newPhase.getDialogue()));
    }
}

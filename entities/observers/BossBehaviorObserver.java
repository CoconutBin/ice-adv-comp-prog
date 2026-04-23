package entities.observers;

import entities.Boss;
import entities.GameEntity;
import entities.boss.behavior.BossBehaviorStrategy;
import entities.boss.behavior.DefeatBossBehavior;
import entities.boss.behavior.LowHPBossBehavior;
import entities.boss.behavior.MidHPBossBehavior;
import game.io.IOHandler;

public class BossBehaviorObserver implements EntityObserver {
    private final IOHandler ioHandler;
    private final Boss boss;
    private int currentPhase = 0; // 0=default, 1=mid, 2=low, 3=defeat

    public BossBehaviorObserver(IOHandler ioHandler, Boss boss) {
        this.ioHandler = ioHandler;
        this.boss = boss;
    }

    @Override
    public void onHpChange(GameEntity entity, double hpChange) {
        double hpPercentage = boss.getHp() / boss.getMaxHp();
        // double hpPercentage = newHp / boss.getMaxHp();

        int newPhase;
        BossBehaviorStrategy newBehavior;
        if (hpPercentage <= 0.0) {
            newPhase = 3;
            newBehavior = new DefeatBossBehavior();
        } else if (hpPercentage <= 0.2) {
            newPhase = 2;
            newBehavior = new LowHPBossBehavior();
        } else if (hpPercentage <= 0.5) {
            newPhase = 1;
            newBehavior = new MidHPBossBehavior();
        } else {
            return;
        }

        if (newPhase == currentPhase) return;
        currentPhase = newPhase;

        boss.setBossBehavior(newBehavior);
        ioHandler.printTyping(newBehavior.getColor().apply("[!] " + boss.getName() + ": " + newBehavior.getDialogue()));
    }
}

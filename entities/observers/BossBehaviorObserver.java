package entities.observers;

import game.io.IOHandler;
import entities.BossPhase;
import entities.Boss;

public class BossBehaviorObserver implements EntityObserver {
    private IOHandler ioHandler;
    private Boss boss;
 
    public BossBehaviorObserver(IOHandler ioHandler, Boss boss) {
        this.ioHandler = ioHandler;
        this.boss = boss;
    }

    @Override
    public void update() {
        BossPhase bossPhase = boss.getBossPhase();
        ioHandler.printTyping(bossPhase.getColor().apply("[!] " + boss.getName() + ": " + bossPhase.getDialogue()));
    }
}

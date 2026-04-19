package game;

import entities.*;
import entities.boss.Boss;
import entities.observers.*;

public class GameSetup {
    private Player player;
    private Boss boss;
    private IOHandler ioHandler;

    public GameSetup(Player player, Boss boss, IOHandler ioHandler) {
        this.player = player;
        this.boss = boss;
        this.ioHandler = ioHandler;
    }

    public void initializeGame() {
        setupObservers();
    }

    public Player getPlayer() {
        return player;
    }

    public Boss getBoss() {
        return boss;
    }
    
    public IOHandler getIoHandler() {
        return ioHandler;
    }

    private void setupObservers() {
        EntityLoggerObserver loggerObserver = new EntityLoggerObserver(ioHandler);
        player.addObserver(loggerObserver);
        boss.addObserver(loggerObserver);
        BossBehaviorObserver behaviorObserver = new BossBehaviorObserver();
        boss.addObserver(behaviorObserver);
    }
}

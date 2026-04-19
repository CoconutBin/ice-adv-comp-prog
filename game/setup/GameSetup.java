package game.setup;

import entities.Player;
import entities.boss.Boss;
import entities.observers.EntityLoggerObserver;
import entities.observers.BossBehaviorObserver;
import game.io.IOHandler;

public class GameSetup {
    private final Player player;
    private final Boss boss;
    private final IOHandler ioHandler;

    public GameSetup(Player player, Boss boss, IOHandler ioHandler) {
        this.player = player;
        this.boss = boss;
        this.ioHandler = ioHandler;
    }

    /**
     * Registers all observers with entities (Observer pattern)
     */
    public void setupObservers() {
        // Logger: logs all HP changes for debugging/UI
        EntityLoggerObserver loggerObserver = new EntityLoggerObserver(ioHandler);
        player.addObserver(loggerObserver);
        boss.addObserver(loggerObserver);

        // Behavior: switches boss attack strategy based on HP %
        BossBehaviorObserver behaviorObserver = new BossBehaviorObserver();
        boss.addObserver(behaviorObserver);
    }
}
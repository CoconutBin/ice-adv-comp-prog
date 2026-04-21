package game.setup;

import entities.*;
import entities.observers.*;
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
        player.addObserver(new EntityLoggerObserver(new game.ui.Visuals(ioHandler), player));
        boss.addObserver(new EntityLoggerObserver(new game.ui.Visuals(ioHandler), boss));

        // Behavior: switches boss attack strategy based on HP %
        BossBehaviorObserver behaviorObserver = new BossBehaviorObserver(ioHandler, boss);
        boss.addBossObserver(behaviorObserver);
    }
}
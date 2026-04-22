package game.setup;

import entities.*;
import entities.observers.*;
import game.io.IOHandler;
import game.ui.Visuals;

public class GameSetup {
    private final Player player;
    private final Boss boss;
    private final IOHandler ioHandler;
    private final Visuals visuals;

    public GameSetup(Player player, Boss boss, IOHandler ioHandler, Visuals visuals) {
        this.player = player;
        this.boss = boss;
        this.ioHandler = ioHandler;
        this.visuals = visuals;
    }

    public void setupObservers() {
        player.addObserver(new EntityLoggerObserver(visuals, true));
        boss.addObserver(new EntityLoggerObserver(visuals, false));
        boss.addObserver(new BossBehaviorObserver(ioHandler, boss));
    }
}

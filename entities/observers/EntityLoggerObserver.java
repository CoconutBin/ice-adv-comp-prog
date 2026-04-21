package entities.observers;

import entities.GameEntity;
import game.ui.Visuals;

public class EntityLoggerObserver implements EntityObserver {
    private final Visuals visuals;
    private GameEntity entity;

    public EntityLoggerObserver(Visuals visuals, GameEntity entity) {
        this.visuals = visuals;
        this.entity = entity;
    }

    @Override
    public void update() {
        boolean isPlayer = entity instanceof entities.Player;
        visuals.displayStatus(isPlayer, entity.getHp(), entity.getName());
    }
}

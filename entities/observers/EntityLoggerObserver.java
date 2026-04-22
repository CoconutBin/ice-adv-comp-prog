package entities.observers;

import entities.GameEntity;
import game.ui.Visuals;

public class EntityLoggerObserver implements EntityObserver {
    private final Visuals visuals;
    private final boolean isPlayer;

    public EntityLoggerObserver(Visuals visuals, boolean isPlayer) {
        this.visuals = visuals;
        this.isPlayer = isPlayer;
    }

    @Override
    public void onHpChange(GameEntity entity) {
        visuals.displayStatus(isPlayer, entity.getHp(), entity.getName());
    }
}

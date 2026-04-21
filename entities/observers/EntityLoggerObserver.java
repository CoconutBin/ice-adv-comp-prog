package entities.observers;

import entities.GameEntity;
import game.ui.Visuals;

public class EntityLoggerObserver extends EntityObserver {
    private final Visuals visuals;

    public EntityLoggerObserver(Visuals visuals) {
        this.visuals = visuals;
    }

    @Override
    public void onHpChange(GameEntity entity) {
        boolean isPlayer = entity instanceof entities.Player;
        visuals.displayStatus(isPlayer, entity.getHp(), entity.getName());
    }
}

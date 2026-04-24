package entities.observers;

import entities.GameEntity;
import game.ui.Visuals;

public class EntityLoggerObserver implements EntityObserver {
    private final Visuals visuals;

    public EntityLoggerObserver(Visuals visuals) {
        this.visuals = visuals;
    }

    @Override
    public void onHpChange(GameEntity entity, double hpChange) {
        visuals.displayStatus(entity, oldHp, hpChange);
    }
}

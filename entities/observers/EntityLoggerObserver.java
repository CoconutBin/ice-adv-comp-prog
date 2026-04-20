package entities.observers;

import entities.GameEntity;
import game.ui.Visuals;

public class EntityLoggerObserver extends EntityObserver {
    private final Visuals visuals;

    public EntityLoggerObserver(game.io.IOHandler ioHandler) {
        this.visuals = new Visuals(ioHandler);
    }

    @Override
    public void onHpChange(GameEntity entity) {
        visuals.displayStatus(entity.getType(), entity.getHp(), entity.getName());
    }
}

package entities.observers;

import entities.GameEntity;

public class EntityLoggerObserver extends EntityObserver {
    private game.io.IOHandler ioHandler;

    public EntityLoggerObserver(game.io.IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    @Override
    public void onHpChange(GameEntity entity) {
        ioHandler.print("HP changed for entity " + entity.getName() + ": " + entity.getHp() + "/" + entity.getMaxHp());
    }

    @Override
    public void onEntityDeath(GameEntity entity) {
        ioHandler.print("entity " + entity.getName() + " died");
    }
}

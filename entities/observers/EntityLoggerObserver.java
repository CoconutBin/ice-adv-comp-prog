package entities.observers;

import entities.GameEntity;

public class EntityLoggerObserver extends EntityObserver {
    @Override
    public void onHpChange(GameEntity entity) {
        System.out.println("HP changed for entity " + entity.getName() + ": " + entity.getHp() + "/" + entity.getMaxHp());
    }

    @Override
    public void onEntityDeath(GameEntity entity) {
        System.out.println("entity " + entity.getName() + " died");
    }
}

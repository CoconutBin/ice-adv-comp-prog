package entities.observers;

import entities.GameEntity;

public interface EntityObserver {
    void onHpChange(GameEntity entity, double hpChange);
}

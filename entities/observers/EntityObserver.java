package entities.observers;

import entities.GameEntity;

public abstract class EntityObserver {
    public abstract void onHpChange(GameEntity entity);
}
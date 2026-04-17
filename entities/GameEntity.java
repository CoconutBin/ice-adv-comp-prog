package entities;

import java.util.ArrayList;

import entities.observers.EntityObserver;

public abstract class GameEntity {
    protected ArrayList<EntityObserver> observers;
    private double maxHp;
    private double hp;

    public GameEntity(double initHp) {
        this.maxHp = initHp;
        this.hp = initHp;
        this.observers = new ArrayList<>();
    }

    public abstract void attack(GameEntity target);

    public double getHp() {
        return hp;
    }

    public void addObserver(EntityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(EntityObserver observer) {
        observers.remove(observer);
    }

    private void notifyHpChanged() {
        for (EntityObserver observer : observers) {
            observer.onHpChange(this);
        }
    }

    private void notifyDeath() {
        for (EntityObserver observer : observers) {
            observer.onEntityDeath(this);
        }
    }

    public void updateHp(double hpChange) {
        this.hp += hpChange;
        notifyHpChanged();
        if (this.hp <= 0) notifyDeath();
    }
}

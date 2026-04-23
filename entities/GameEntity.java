package entities;

import entities.observers.EntityObserver;
import java.util.ArrayList;

public abstract class GameEntity {
    protected ArrayList<EntityObserver> observers;
    private final double maxHp;
    private double hp;
    private String name;

    public GameEntity(double initHp, String name) {
        this.maxHp = initHp;
        this.hp = initHp;
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public abstract void attack(GameEntity target, double modifier);

    public double getHp() {
        return hp;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addObserver(EntityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(EntityObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(double oldHp, double newHp){
        for(EntityObserver observer: observers){
            observer.onHpChange(this, oldHp, newHp);
        }
    }

    protected void updateHp(double hpChange) {
        if (hpChange == 0) return;
        this.hp = Math.max(0, Math.min(this.hp + hpChange, maxHp));
        notifyObservers(this.hp - hpChange, this.hp);
    }
}

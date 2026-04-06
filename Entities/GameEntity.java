package Entities;

public abstract class GameEntity {
    private double hp;

    public abstract void attack(GameEntity target);

    protected void updateHp(double hp) {
        this.hp += hp;
    }
}

package entities;

public abstract class GameEntity {
    private double hp;

    public GameEntity(double init_hp) {
        this.hp = init_hp;
    }

    public abstract void attack(GameEntity target);

    protected void updateHp(double hp_change) {
        this.hp += hp_change;
    }

    public double getHp() {
        return hp;
    }
}

package entities;

public class Player extends GameEntity {
    private String name;

    public Player(String name, double initialHp) {
        super(initialHp, name);
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack(GameEntity target) {
        // Implementation for player attack
    }
}

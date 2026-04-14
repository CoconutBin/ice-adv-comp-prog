package entities;

public class Player extends GameEntity {
    private String name;

    public Player(String name, double init_hp) {
        super(init_hp);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack(GameEntity target) {
        
    }
}

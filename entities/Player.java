package entities;

public class Player extends GameEntity {
    private final int path;
    public Player(String name, double initialHp, int path) {
        super(initialHp, name);
        this.path = path;
    }

    @Override
    public void attack(GameEntity target) {
        target.updateHp(-Math.random() * 7);
    }

    @Override
    public String getType(){
        return "player";
    }

    public int getPath(){
        return path;
    }
}

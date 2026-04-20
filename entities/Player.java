package entities;

public class Player extends GameEntity {

    public Player(String name, double initialHp) {
        super(initialHp, name);
    }

    @Override
    public void attack(GameEntity target) {
        target.updateHp(-Math.random() * 7);
    }

    @Override
    public String getType(){
        return "player";
    }
}

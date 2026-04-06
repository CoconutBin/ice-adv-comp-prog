package Entities;

public class Player extends GameEntity {
    private String name;

    public Player(String name) {
        super();
        this.name = name;
        updateHp(50);
    }

    @Override
    public void attack(GameEntity target) {
        // TODO Auto-generated method stub
        
    }
}

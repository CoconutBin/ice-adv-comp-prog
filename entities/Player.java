package entities;

public class Player extends GameEntity {
    private final PlayerGift playerGift;

    public Player(String name, double initialHp, PlayerGift playerGift) {
        super(initialHp, name);
        this.playerGift = playerGift;
    }

    @Override
    public void attack(GameEntity target, double modifier) {
        target.updateHp(-1 * playerGift.getAttackStat() * modifier);
    }

    public PlayerGift getPlayerGift(){
        return playerGift;
    }
}

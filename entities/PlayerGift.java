package entities;

public enum PlayerGift {
    INTELLIGENCE(1, 5),
    STRENGTH(2, 10),
    CHARISMA(3, 5);

    PlayerGift(int id, int attackStat){
        this.id = id;
        this.attackStat = attackStat;
    }

    private final int id;
    private final int attackStat;

    public int getId() {
        return id;
    }

    public int getAttackStat() {
        return attackStat;
    }

    public String toString(){
        return this.name().toUpperCase();
    }

    public static PlayerGift fromId(int id) {
        for (PlayerGift gift : values()) {
            if (gift.getId() == id) {
                return gift;
            }
        }
        throw new IllegalArgumentException("Invalid PlayerGift ID: " + id);
    }
}


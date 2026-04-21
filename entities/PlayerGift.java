package entities;

public enum PlayerGift {
    INTELLIGENCE(1, 5, "Be blessed with the scholarly knowledge of realms beyond."),
    STRENGTH(2, 7, "Hone your true potential and unleash a stronger strike when opportunity arises."),
    CHARISMA(3, 5, "Possess a charm so wonderful, even your enemies slip and leak their secrets."),
    NONE(4, 5, "Defy fate and receive no advantages.");

    PlayerGift(int id, int attackStat, String description){
        this.id = id;
        this.attackStat = attackStat;
        this.description = description;
    }

    private final int id;
    private final int attackStat;
    private final String description;

    public int getId() {
        return id;
    }

    public int getAttackStat() {
        return attackStat;
    }

    public String getDescription() {
        return description;
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


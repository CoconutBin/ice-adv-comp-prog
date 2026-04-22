package entities;

public enum PlayerGift {
    INTELLIGENCE(1, 5, "Be blessed with the scholarly knowledge of realms beyond.", true, 0.25, 0.5, false, false),
    STRENGTH(2, 7, "Hone your true potential and unleash a stronger strike when opportunity arises.", false, 0, 0, false, false),
    CHARISMA(3, 5, "Possess a charm so wonderful, even your enemies slip and leak their secrets.", false, 0, 0, true, false),
    NONE(4, 5, "Defy fate and receive no advantages.", false, 0, 0, false, true);

    private final int id;
    private final int attackStat;
    private final String description;
    private final boolean hasRetry;
    private final double critBonus;
    private final double critDamageReduction;
    private final boolean hasCombatHints;
    private final boolean hasSpecialVictoryScreen;

    PlayerGift(int id, int attackStat, String description,
               boolean hasRetry, double critBonus, double critDamageReduction,
               boolean hasCombatHints, boolean hasSpecialVictoryScreen) {
        this.id = id;
        this.attackStat = attackStat;
        this.description = description;
        this.hasRetry = hasRetry;
        this.critBonus = critBonus;
        this.critDamageReduction = critDamageReduction;
        this.hasCombatHints = hasCombatHints;
        this.hasSpecialVictoryScreen = hasSpecialVictoryScreen;
    }

    public int getId() { return id; }
    public int getAttackStat() { return attackStat; }
    public String getDescription() { return description; }

    /** Whether this gift grants a free retry on a wrong answer. */
    public boolean hasRetry() { return hasRetry; }

    /** Bonus added to the Critical Hit modifier on a player attack. */
    public double getCritBonus() { return critBonus; }

    /** Damage reduction applied to the Critical Hit modifier when hit by the boss. */
    public double getCritDamageReduction() { return critDamageReduction; }

    /** Whether this gift reveals a non-weak / non-safe combat hint each phase. */
    public boolean hasCombatHints() { return hasCombatHints; }

    /** Whether this gift unlocks the special S-Rank victory screen. */
    public boolean hasSpecialVictoryScreen() { return hasSpecialVictoryScreen; }

    public String toString() { return this.name().toUpperCase(); }

    public static PlayerGift fromId(int id) {
        for (PlayerGift gift : values()) {
            if (gift.getId() == id) return gift;
        }
        throw new IllegalArgumentException("Invalid PlayerGift ID: " + id);
    }
}

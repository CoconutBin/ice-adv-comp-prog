package attacks;

public enum AttackResult {
    DODGE(0),
    HIT(1),
    CRITICAL_HIT(2);

    private double baseHitModifier;

    AttackResult(double baseHitModifier) {
        this.baseHitModifier = baseHitModifier;
    }

    public double getBaseHitModifier() {
        return baseHitModifier;
    }

    public double getHitModifierWithBonus(double bonus) {
        return baseHitModifier + bonus;
    }
}

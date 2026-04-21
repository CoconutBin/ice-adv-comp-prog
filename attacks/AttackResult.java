package attacks;

public enum AttackResult {
    DODGE(0),
    HIT(1),
    CRITICAL_HIT(2);

    private double hitModifier;

    AttackResult(double hitModifier) {
        this.hitModifier = hitModifier;
    }

    public double getHitModifier() {
        return hitModifier;
    }
}

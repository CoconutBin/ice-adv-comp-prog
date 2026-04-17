package entities.boss.behavior;

public class DefaultBossBehavior implements BossBehaviorStrategy {
    @Override
    public double calculateDamage() {
        return 5 + Math.random() * 2; // Example damage calculation for default behavior
    }
}

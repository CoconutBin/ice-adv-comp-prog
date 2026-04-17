package entities.boss.behavior;

public class LowHPBossBehavior implements BossBehaviorStrategy {
    @Override
    public double calculateDamage() {
        return 5 + Math.random() * 10; // Example damage calculation for low HP behavior
    }
}

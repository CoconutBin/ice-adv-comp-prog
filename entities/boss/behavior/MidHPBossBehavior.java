package entities.boss.behavior;

public class MidHPBossBehavior implements BossBehaviorStrategy {
    @Override
    public double calculateDamage() {
        return 5 + Math.random() * 5; // Example damage calculation for mid HP behavior
    }
    
}

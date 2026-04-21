package entities.boss.behavior;

public class DefaultBossBehavior implements BossBehaviorStrategy {
    @Override
    public int calculateDamage() {
        return 5;
    }
}

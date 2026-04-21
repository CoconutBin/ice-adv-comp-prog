package entities.boss.behavior;
import java.util.Random;

public class MidHPBossBehavior implements BossBehaviorStrategy {
    private final Random random = new Random();

    @Override
    public int calculateDamage() {
        return 7 + random.nextInt(6); // Example damage calculation for mid HP behavior
    }
}

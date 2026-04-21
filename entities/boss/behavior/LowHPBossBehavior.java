package entities.boss.behavior;
import java.util.Random;

public class LowHPBossBehavior implements BossBehaviorStrategy {
    private final Random random = new Random();

    @Override
    public int calculateDamage() {
        return 8 + random.nextInt(8); // Example damage calculation for low HP behavior
    }
}

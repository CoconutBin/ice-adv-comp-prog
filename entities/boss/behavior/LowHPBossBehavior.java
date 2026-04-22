package entities.boss.behavior;

import game.ui.TerminalColor;
import java.util.Random;

public class LowHPBossBehavior implements BossBehaviorStrategy {
    private final Random random = new Random();

    @Override
    public int calculateDamage() {
        return 8 + random.nextInt(8);
    }

    @Override
    public String getDialogue() {
        return "You think you can defeat me? Go ahead, try me!";
    }

    @Override
    public TerminalColor getColor() {
        return TerminalColor.RED;
    }
}

package entities.boss.behavior;

import game.ui.TerminalColor;
import java.util.Random;

public class MidHPBossBehavior implements BossBehaviorStrategy {
    private final Random random = new Random();

    @Override
    public int calculateDamage() {
        return 7 + random.nextInt(6);
    }

    @Override
    public String getDialogue() {
        return "You're certainly better than I thought..";
    }

    @Override
    public TerminalColor getColor() {
        return TerminalColor.ORANGE;
    }
}

package entities.boss.behavior;

import game.ui.TerminalColor;
import java.util.Random;

public class MidHPBossBehavior implements BossBehaviorStrategy {
    private final Random random = new Random();

    @Override
    public int calculateDamage() {
        return 8 + random.nextInt(8);
    }

    @Override
    public String getDialogue() {
        return "You're certainly better than I thought..\n\n(* You feel vibrations from deep underground... *)";
    }

    @Override
    public TerminalColor getColor() {
        return TerminalColor.ORANGE;
    }
}

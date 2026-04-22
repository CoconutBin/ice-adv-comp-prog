package entities.boss.behavior;

import game.ui.TerminalColor;

public class DefeatBossBehavior implements BossBehaviorStrategy {
    @Override
    public int calculateDamage() {
        return 0;
    }

    @Override
    public String getDialogue() {
        return "But how? You were supposed to be bad!";
    }

    @Override
    public TerminalColor getColor() {
        return TerminalColor.LIGHT_GREY;
    }
}

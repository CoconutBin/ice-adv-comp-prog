package entities.boss.behavior;

import game.ui.TerminalColor;

public interface BossBehaviorStrategy {
    int calculateDamage();
    String getDialogue();
    TerminalColor getColor();
}

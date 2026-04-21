package entities;

import game.ui.TerminalColor;

public enum BossPhase {
    DEFAULT(TerminalColor.YELLOW, "Let's see what you're made of!"),
    MID_HP(TerminalColor.ORANGE, "You're certainly better than I thought.."),
    LOW_HP(TerminalColor.RED, "You think you can defeat me? Go ahead, try me!"),
    DEFEAT(TerminalColor.LIGHT_GREY, "But how? You were supposed to be bad!");

    private TerminalColor color;
    private String dialogue;

    BossPhase(TerminalColor color, String dialogue) {
        this.color = color;
        this.dialogue = dialogue;
    }

    public String getDialogue(){
        return dialogue;
    }

    public TerminalColor getColor() {
        return color;
    }
}

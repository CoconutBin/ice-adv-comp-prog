package game.ui;

public enum TerminalColor {
    RESET("\u001B[0m"),
    RED   ("\u001B[31m"),
    YELLOW("\u001B[33m"),
    GREEN ("\u001B[32m"),
    CYAN  ("\u001B[36m"),
    BLUE  ("\u001B[34m"),
    PURPLE("\u001B[35m"),
    ORANGE("\u001B[38;2;255;165;0m"),
    PINK  ("\u001B[38;2;255;192;203m"),
    LIGHT_GREY("\u001B[90m");

    private final String code;
    
    TerminalColor(String code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return code;
    }

    public String apply(String message) {
        return code + message + RESET.code;
    }
}
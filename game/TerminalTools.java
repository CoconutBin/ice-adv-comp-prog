package game;

public class TerminalTools {

    public static final String RESET = "\u001B[0m";
    public static final String RED    = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN  = "\u001B[32m";
    public static final String CYAN   = "\u001B[36m";
    public static final String BLUE   = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String ORANGE = "\u001B[38;2;255;165;0m";
    public static final String PINK   = "\u001B[38;2;255;192;203m";
    public static final String LIGHT_GREY = "\u001B[90m";

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private static final int DELAY = 20;
    public static void typing(String message) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            wait(DELAY);
        }
        System.out.println();
    }
    
    public static void fullClear() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearLine(int lineNum) {
        System.out.print("\033[" + lineNum + ";1H\033[2K");
        System.out.flush();
    }
}

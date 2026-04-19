package game;
import entities.Player;
import entities.boss.Boss;
public class Visuals {

    public static void showLogo() {
        System.out.println(TerminalTools.RED    + "  /██████  /██   /██ /██████ /████████        /██████  /██        /██████  /██     /██ /████████ /███████ " + TerminalTools.RESET);
        System.out.println(TerminalTools.ORANGE + " /██__  ██| ██  | ██|_  ██_/|_____ ██        /██__  ██| ██       /██__  ██|  ██   /██/| ██_____/| ██__  ██" + TerminalTools.RESET);
        System.out.println(TerminalTools.YELLOW + "| ██  \\ ██| ██  | ██  | ██       /██/       | ██  \\__/| ██      | ██  \\ ██ \\  ██ /██/ | ██      | ██  \\ ██" + TerminalTools.RESET);
        System.out.println(TerminalTools.GREEN  + "| ██  | ██| ██  | ██  | ██      /██/        |  ██████ | ██      | ████████  \\  ████/  | █████   | ███████/" + TerminalTools.RESET);
        System.out.println(TerminalTools.CYAN   + "| ██  | ██| ██  | ██  | ██     /██/          \\____  ██| ██      | ██__  ██   \\  ██/   | ██__/   | ██__  ██" + TerminalTools.RESET);
        System.out.println(TerminalTools.BLUE   + "| ██/██ ██| ██  | ██  | ██    /██/           /██  \\ ██| ██      | ██  | ██    | ██    | ██      | ██  \\ ██" + TerminalTools.RESET);
        System.out.println(TerminalTools.PURPLE + "|  ██████/|  ██████/ /██████ /████████      |  ██████/| ████████| ██  | ██    | ██    | ████████| ██  | ██" + TerminalTools.RESET);
        System.out.println(TerminalTools.PINK   + " \\____ ███ \\______/ |______/|________/       \\______/ |________/|__/  |__/    |__/    |________/|__/  |__/" + TerminalTools.RESET);
        TerminalTools.typing("\n                                           - Press Enter to start -                                     ");
    }

    public static void playPrologue(Player player, Boss boss) {
        TerminalTools.typing("\n" + TerminalTools.YELLOW + "Ah, " + player.getName() + "..." + TerminalTools.RESET);
        TerminalTools.wait(500);
        TerminalTools.typing("You stand at the threshold of the Seven Subjects. A place where dreams go to be graded.");
        TerminalTools.typing("Knowledge is your blade. Logic is your shield. A Calculator with low battery is your only friend.");
        TerminalTools.wait(800);
        TerminalTools.typing("If you falter, your GPA will be lower than the bar for a TikTok challenge.");
        TerminalTools.wait(1500);

        TerminalTools.typing("Searching for a spark of intelligence...");
        TerminalTools.wait(800);
        TerminalTools.typing("Error: Spark not found. Proceeding anyway...");
        TerminalTools.wait(500);
        TerminalTools.typing("Simulating student loan interest rates...");
        TerminalTools.wait(500);
        TerminalTools.typing("Destroying your eyesight..." + TerminalTools.RESET);
        TerminalTools.wait(1000);
        TerminalTools.clearTerminal();
        TerminalTools.typing(TerminalTools.RED + "--- " + boss.getName() + " --- descends" + TerminalTools.RESET);
        TerminalTools.wait(1000);
        TerminalTools.typing(boss.getIntro());
        TerminalTools.wait(1000);
    }

    public static void showSubjectHeader(String subjectName) {
        TerminalTools.fullClear();
        TerminalTools.typing(TerminalTools.YELLOW + "--- " + subjectName.toUpperCase() + " ---" + TerminalTools.RESET);
        TerminalTools.wait(500);
    }
    public static void showOpening() {
        TerminalTools.typing(TerminalTools.PURPLE + "[!] THE VOID OPENS (smells like cheap coffee and regret)..." + TerminalTools.RESET);
        TerminalTools.typing("A voice echoes: 'State your name, mortal, so we can misspell it on your final certificate.'");
        System.out.print(TerminalTools.CYAN + "--> " + TerminalTools.RESET);
    }
    public static void displayStatus(String entity, double hp, String name) {
        String bar = "";
        String missing = "";
        for (int i = 0; i < 20; i++) {
            if (i < Math.max(0, hp / 5)) bar += "█";
            else missing += "█";
        }
        if (entity.equals("player")){
            System.out.println(TerminalTools.GREEN + name + " HP: " + bar + TerminalTools.LIGHT_GREY + missing + TerminalTools.RESET);
        }
        else{
            System.out.println(TerminalTools.RED + name + " HP: " + bar + TerminalTools.LIGHT_GREY + missing + TerminalTools.RESET);
        }
    }

    public static void showDefeat(Player player, Boss boss) {
        System.out.println("\n" + TerminalTools.RED + "========================================" + TerminalTools.RESET);
        TerminalTools.typing(TerminalTools.RED + " [X] YOUR GPA IS CURRENTLY F! GITGUD" + TerminalTools.RESET);
        TerminalTools.typing(TerminalTools.RESET + boss.getName() + " is handing you a flyer for a career in competitive grass touching.");
        TerminalTools.wait(500);
        TerminalTools.typing(TerminalTools.RED + " G A M E   O V E R " + TerminalTools.RESET);
        System.out.println(TerminalTools.RED + "========================================" + TerminalTools.RESET);
    }

    public static void showVictory(Player player, Boss boss) {
        System.out.println("\n" + TerminalTools.YELLOW + "========================================" + TerminalTools.RESET);
        TerminalTools.typing(TerminalTools.GREEN + " [!] " + boss.getName() + " HAS BEEN DEFEATED! " + TerminalTools.RESET);
        TerminalTools.wait(500);
        TerminalTools.typing(TerminalTools.RESET + " " + player.getName() + " is aiming for that A\r");
        System.out.print("\033[1A " + player.getName() + " is aiming for that A");
        TerminalTools.wait(500);
        TerminalTools.typing(TerminalTools.RESET + "...verage (what? You don't know A is average?)");
        TerminalTools.wait(1000);
        TerminalTools.typing(TerminalTools.YELLOW + " A V E R A G E   A C H I E V E D " + TerminalTools.RESET);
        TerminalTools.wait(500);
        TerminalTools.typing(TerminalTools.PURPLE + " Remaining Health: " + (int)player.getHp() + " HP (and 0 dignity remaining)");
        System.out.println(TerminalTools.YELLOW + "========================================" + TerminalTools.RESET);
    }
}
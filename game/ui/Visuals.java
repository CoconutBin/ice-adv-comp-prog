package game.ui;
import entities.Player;
import entities.boss.Boss;
import game.io.IOHandler;


public class Visuals {
    private final IOHandler ioHandler;

    public Visuals(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

public void showLogo() {
        ioHandler.print(TerminalColor.RED.apply(   "         /██████  /██   /██ /██████ /████████        /██████  /██        /██████  /██     /██ /████████ /███████ ")) ;
        ioHandler.print(TerminalColor.ORANGE.apply("        /██__  ██| ██  | ██|_  ██_/|_____ ██        /██__  ██| ██       /██__  ██|  ██   /██/| ██_____/| ██__  ██"));
        ioHandler.print(TerminalColor.YELLOW.apply("       | ██  \\ ██| ██  | ██  | ██       /██/       | ██  \\__/| ██      | ██  \\ ██ \\  ██ /██/ | ██      | ██  \\ ██"));
        ioHandler.print(TerminalColor.GREEN.apply( "       | ██  | ██| ██  | ██  | ██      /██/        |  ██████ | ██      | ████████  \\  ████/  | █████   | ███████/"));
        ioHandler.print(TerminalColor.CYAN.apply(  "       | ██  | ██| ██  | ██  | ██     /██/          \\____  ██| ██      | ██__  ██   \\  ██/   | ██      | ██  \\ ██"));
        ioHandler.print(TerminalColor.BLUE.apply(  "       | ██/██ ██| ██  | ██  | ██    /██/           /██  \\ ██| ██      | ██  | ██    | ██    | ██      | ██  \\ ██"));
        ioHandler.print(TerminalColor.PURPLE.apply("       |  ██████/|  ██████/ /██████ /████████      |  ██████/| ████████| ██  | ██    | ██    | ████████| ██  | ██"));
        ioHandler.print(TerminalColor.PINK.apply(  "        \\____ ███ \\______/ |______/|________/       \\______/ |________/|__/  |__/    |__/    |________/|__/  |__/"));
        ioHandler.printTyping("\n                                                  - Press Enter to start -                                     ");
    }

    public void playPrologue(Player player) {
        ioHandler.printTyping("\n" + TerminalColor.YELLOW.apply("Ah, " + player.getName() + "..."));
        ioHandler.wait(500);
        ioHandler.printTyping("You stand at the threshold of the Seven Subjects. A place where dreams go to be graded.");
        ioHandler.wait(800);
        ioHandler.printTyping("Knowledge is your blade. Logic is your shield. A Calculator with low battery is your only friend.");
        ioHandler.wait(800);
        ioHandler.printTyping("If you falter, your GPA will be lower than the bar for a TikTok challenge.");
        ioHandler.wait(1500);
        ioHandler.clearTerminal();
    }

    public void playBossIntro(Boss boss) { //make this dynamic
        ioHandler.printTyping(TerminalColor.RED.apply("--- " + boss.getName() + " ---"));
        ioHandler.wait(1000);
        ioHandler.printTyping(boss.getIntro());
        ioHandler.wait(1000);
    }

    public void showSubjectHeader(String subjectName) { //make this dynamic
        ioHandler.fullClear();
        ioHandler.printTyping(TerminalColor.YELLOW.apply("--- " + subjectName.toUpperCase() + " ---"));
        ioHandler.wait(500);
    }
    public void showOpening() {
        ioHandler.printTyping(TerminalColor.PURPLE.apply("[!] THE VOID OPENS (smells like cheap coffee and regret)..."));
        ioHandler.wait(500);
        ioHandler.printTyping("A voice echoes: 'State your name, mortal, so we can misspell it on your final certificate.'");
        System.out.print(TerminalColor.CYAN.apply("--> "));
    }
    public void displayStatus(String entity, double hp, String name) {
        String bar = "";
        String missing = "";
        for (int i = 0; i < 20; i++) {
            if (i < Math.max(0, hp / 5)) bar += "█";
            else missing += "█";
        }
        if (entity.equals("player")){
            ioHandler.print(TerminalColor.GREEN + name + " HP: " + bar + TerminalColor.LIGHT_GREY + missing + TerminalColor.RESET);
        }
        else{
            ioHandler.print(TerminalColor.RED + name + " HP: " + bar + TerminalColor.LIGHT_GREY + missing + TerminalColor.RESET);
        }
    }

    public void showDefeat(Player player, Boss boss) {
        ioHandler.print("\n" + TerminalColor.RED.apply("========================================================================================================================"));
        ioHandler.printTyping(TerminalColor.RED.apply(" [X] YOUR GPA IS CURRENTLY F! GITGUD")); // center
        ioHandler.printTyping(TerminalColor.RESET + " " + boss.getName() + " is handing you a flyer for a career in competitive grass touching."); // center
        ioHandler.wait(500);
        ioHandler.printTyping(TerminalColor.RED.apply("            G A M E   O V E R "));
        ioHandler.print(TerminalColor.RED.apply("========================================================================================================================"));
    }

    public void showVictory(Player player, Boss boss) {
        ioHandler.print("\n" + TerminalColor.YELLOW.apply("========================================================================================================================"));
        ioHandler.printTyping(TerminalColor.GREEN.apply(" [!] " + boss.getName() + " HAS BEEN DEFEATED! "));

        ioHandler.wait(500);
        ioHandler.printTyping(TerminalColor.RESET + " " + player.getName() + " is aiming for that A\r");
        ioHandler.inlinePrint("\033[1A " + player.getName() + " is aiming for that A");
        ioHandler.wait(500);
        ioHandler.printTyping(TerminalColor.RESET + "...verage (what? You don't know A is average?)");
        ioHandler.wait(1000);
        ioHandler.printTyping(TerminalColor.YELLOW.apply(" A V E R A G E   A C H I E V E D "));
        ioHandler.wait(500);
        ioHandler.printTyping(TerminalColor.PURPLE.apply(" Remaining Health: " + (int)player.getHp() + " HP (and 0 dignity remaining)"));
        ioHandler.print(TerminalColor.YELLOW.apply("========================================================================================================================"));
    }
}
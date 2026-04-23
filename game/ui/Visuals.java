package game.ui;

import entities.GameEntity;

import attacks.question.QuoteBank;
import attacks.question.Subject;
import entities.Boss;
import entities.Player;
import game.io.IOHandler;

public class Visuals {
  private final IOHandler ioHandler;

  public Visuals(IOHandler ioHandler) {
    this.ioHandler = ioHandler;
  }

public void showLogo() {
        ioHandler.print(TerminalColor.RED.apply(ioHandler.center(   "  /██████  /██   /██ /██████ /████████        /██████  /██        /██████  /██     /██ /████████ /███████ ", 120, " "))) ;
        ioHandler.print(TerminalColor.ORANGE.apply(ioHandler.center(" /██__  ██| ██  | ██|_  ██_/|_____ ██        /██__  ██| ██       /██__  ██|  ██   /██/| ██_____/| ██__  ██", 120, " ")));
        ioHandler.print(TerminalColor.YELLOW.apply(ioHandler.center("| ██  \\ ██| ██  | ██  | ██       /██/       | ██  \\__/| ██      | ██  \\ ██ \\  ██ /██/ | ██      | ██  \\ ██", 120, " ")));
        ioHandler.print(TerminalColor.GREEN.apply(ioHandler.center( "| ██  | ██| ██  | ██  | ██      /██/        |  ██████ | ██      | ████████  \\  ████/  | █████   | ███████/", 120, " ")));
        ioHandler.print(TerminalColor.CYAN.apply(ioHandler.center(  "| ██  | ██| ██  | ██  | ██     /██/          \\____  ██| ██      | ██__  ██   \\  ██/   | ██      | ██  \\ ██", 120, " ")));
        ioHandler.print(TerminalColor.BLUE.apply(ioHandler.center(  "| ██/██ ██| ██  | ██  | ██    /██/           /██  \\ ██| ██      | ██  | ██    | ██    | ██      | ██  \\ ██", 120, " ")));
        ioHandler.print(TerminalColor.PURPLE.apply(ioHandler.center("|  ██████/|  ██████/ /██████ /████████      |  ██████/| ████████| ██  | ██    | ██    | ████████| ██  | ██", 120, " ")));
        ioHandler.print(TerminalColor.PINK.apply(ioHandler.center(  " \\____ ███ \\______/ |______/|________/       \\______/ |________/|__/  |__/    |__/    |________/|__/  |__/", 120, " ")));
        ioHandler.print(ioHandler.center("- Press Enter to start -", 120, " "));
    }

  public void playPrologue(Player player) {
    ioHandler.printTyping("\n" + TerminalColor.YELLOW.apply("Ah, " + player.getName() + "..."));
    ioHandler.wait(500);
    ioHandler.printTyping("You stand at the threshold of the Seven Subjects. A place where dreams go to be graded.");
    ioHandler.wait(800);
    ioHandler.printTyping(
        "Knowledge is your blade. Logic is your shield. A Calculator with low battery is your only friend.");
    ioHandler.wait(800);
    ioHandler.printTyping("If you falter, your GPA will be lower than the bar for a TikTok challenge.");
    ioHandler.print(TerminalColor.LIGHT_GREY.apply("\n[ Press ENTER to continue ]"));
    ioHandler.readLine();
    ioHandler.clearTerminal();
  }

  public void playBossIntro(Boss boss) {
    ioHandler.printTyping(TerminalColor.RED.apply("[!] " + boss.getName() + " descends"));
    ioHandler.wait(1000);
    ioHandler.printTyping(boss.getIntro());
    ioHandler.wait(1000);
  }

  public void showSubjectHeader(String subjectName) {
    ioHandler.fullClear();
    ioHandler.print(TerminalColor.YELLOW.apply(ioHandler.center(" " + subjectName.toUpperCase() + " ", 120, "-")));
    ioHandler.wait(500);
  }

  public void showOpening() {
    ioHandler.printTyping(TerminalColor.PURPLE.apply("[!] THE VOID OPENS (smells like cheap coffee and regret)..."));
    ioHandler.wait(500);
    ioHandler
        .printTyping("A voice echoes: 'State your name, mortal, so we can misspell it on your final certificate.'");
    ioHandler.inlinePrint(TerminalColor.CYAN.apply("--> "));
  }

  public void displayStatus(GameEntity entity, double oldHp, double newHp) {
    String bar = "";
    String missing = "";
    double maxHp = entity.getMaxHp();
    for (int i = 0; i < 20; i++) {
      if (i < Math.max(0, (newHp / maxHp) * 20))
        bar += "█";
      else
        missing += "█";
    }
    if (entity instanceof Player) {
      ioHandler.print(TerminalColor.GREEN.apply(entity.getName() + " HP: " + bar) + TerminalColor.LIGHT_GREY.apply(missing) + TerminalColor.GREEN.apply(" " + newHp + "/" + maxHp) + TerminalColor.ORANGE.apply(" [" + (newHp-oldHp) + " Hp]"));
    } else {
      ioHandler.print(TerminalColor.RED.apply(entity.getName() + " HP: " + bar) + TerminalColor.LIGHT_GREY.apply(missing) + TerminalColor.RED.apply(" " + newHp + "/" + maxHp) + TerminalColor.ORANGE.apply(" [" + (newHp-oldHp) + " Hp]"));
    }
  }

  public void showDefeat(Player player, Boss boss, Subject subject) {
    ioHandler.print("\n" + TerminalColor.RED.apply(ioHandler.center("", 120, "=")));
    ioHandler.print("");
    ioHandler.printTyping(TerminalColor.RED.apply(ioHandler.center("[!] YOUR GPA IS CURRENTLY F! GITGUD", 120, " ")));
    ioHandler.print("");
    ioHandler.printTyping(ioHandler
        .center(boss.getName() + " is handing you a flyer for a career in competitive grass touching.", 120, " "));
    ioHandler.printTyping(ioHandler.center(QuoteBank.getBossVictory(subject), 120, " "));
    ioHandler.print("");
    ioHandler.wait(500);
    ioHandler.printTyping(TerminalColor.RED.apply(ioHandler.center("G A M E   O V E R", 120, " ")));
    ioHandler.print("");
    ioHandler.print(TerminalColor.RED.apply(ioHandler.center("", 120, "=")));
  }

  public void showVictory(Player player, Boss boss, Subject subject) {
    if (player.getPlayerGift().hasSpecialVictoryScreen()) {
      ioHandler.print("\n" + TerminalColor.GREEN.apply(ioHandler.center("", 120, "=")));
      ioHandler.print("");
      ioHandler.printTyping(
          TerminalColor.GREEN.apply(ioHandler.center("[!] " + boss.getName() + " HAS BEEN DEFEATED!", 120, " ")));
      ioHandler.printTyping(ioHandler.center(QuoteBank.getBossDefeat(subject), 120, " "));
      ioHandler.print("");
      ioHandler.wait(500);
      ioHandler.printTyping(ioHandler.center(player.getName() + " is aiming for that S!", 120, " "));
      ioHandler.print("");
      ioHandler.wait(1000);
      ioHandler.printTyping(TerminalColor.GREEN.apply(ioHandler.center("S U R V I V E D   A C H I E V E D", 120, " ")));
      ioHandler.wait(500);
      ioHandler.printTyping(TerminalColor.CYAN.apply(ioHandler
          .center("Remaining Health: " + (int) player.getHp() + " HP (and maybe some dignity remaining)", 120, " ")));
      ioHandler.print("");
      ioHandler.print(TerminalColor.GREEN.apply(ioHandler.center("", 120, "=")));
    } else {
      ioHandler.print("\n" + TerminalColor.YELLOW.apply(ioHandler.center("", 120, "=")));
      ioHandler.print("");
      ioHandler.printTyping(
          TerminalColor.YELLOW.apply(ioHandler.center("[!] " + boss.getName() + " HAS BEEN DEFEATED!", 120, " ")));
      ioHandler.printTyping(ioHandler.center(QuoteBank.getBossDefeat(subject), 120, " "));
      ioHandler.print("");
      ioHandler.wait(500);
      ioHandler.printTyping(ioHandler.center(player.getName() + " is aiming for that A!", 120, " "));
      ioHandler.print("");
      ioHandler.wait(1000);
      ioHandler.printTyping(TerminalColor.YELLOW.apply(ioHandler.center("A V E R A G E   A C H I E V E D", 120, " ")));
      ioHandler.wait(500);
      ioHandler.printTyping(TerminalColor.PURPLE.apply(
          ioHandler.center("Remaining Health: " + (int) player.getHp() + " HP (and 0 dignity remaining)", 120, " ")));
      ioHandler.print("");
      ioHandler.print(TerminalColor.YELLOW.apply(ioHandler.center("", 120, "=")));
    }
  }
}

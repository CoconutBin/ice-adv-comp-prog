import attacks.question.QuoteBank;
import attacks.question.Subject;
import entities.Boss;
import entities.Player;
import entities.PlayerGift;
import game.io.IOHandler;
import game.loop.Battle;
import game.setup.GameSetup;
import game.ui.Menu;
import game.ui.TerminalColor;
import game.ui.Visuals;

public class App {

    public static void main(String[] args) {

        final IOHandler ioHandler = new IOHandler();
        Visuals visuals = new Visuals(ioHandler);

        ioHandler.fullClear();
        ioHandler.print(ioHandler.center("Please set your terminal width to 120 (or until this text is centered)", 120, " "));
        ioHandler.print(TerminalColor.LIGHT_GREY.apply(ioHandler.center("[ Press ENTER to continue ]", 120, " ")));
        ioHandler.readLine();
        ioHandler.fullClear();
        visuals.showLogo();

        ioHandler.readLine();
        ioHandler.fullClear();

        Menu menu = new Menu(ioHandler);
        Subject chosenSubject = menu.subjectSelection();
        ioHandler.print("");
        PlayerGift playerGift = menu.selectSpecialty();
        boolean skip = menu.shouldSkip();
        String playerName = "";
        if (!skip){
            visuals.showSubjectHeader(chosenSubject.getDisplayName());
            visuals.showOpening();
            playerName = ioHandler.readLine();
        }
        Player player = new Player(playerName.isEmpty() ? "Academic Probation" : playerName, 100, playerGift);
        Boss boss = new Boss(QuoteBank.getBossName(chosenSubject), QuoteBank.getBossIntro(chosenSubject), 100);
        if (!skip){
            visuals.playPrologue(player);
        }
        else{
            ioHandler.clearTerminal();
        }
        visuals.playBossIntro(boss);
        ioHandler.print(TerminalColor.LIGHT_GREY.apply("\n[ Press ENTER to continue ]"));
        ioHandler.readLine();
        ioHandler.clearTerminal();
        // Setup game state (register observers, initialize systems)
        GameSetup gameSetup = new GameSetup(player, boss, ioHandler, visuals);
        gameSetup.setupObservers();

        Battle battle = new Battle(ioHandler, visuals);
        battle.startLoop(player, boss, chosenSubject);
        System.exit(0);
    }
}

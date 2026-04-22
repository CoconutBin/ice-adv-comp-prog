import attacks.question.Subject;
import game.loop.Battle;
import game.setup.GameSetup;
import game.ui.TerminalColor;
import game.ui.Visuals;
import entities.PlayerGift;

public class App {

    public static void main(String[] args) {
        
        final game.io.IOHandler ioHandler = new game.io.IOHandler();
        Visuals visuals = new Visuals(ioHandler);
        
        ioHandler.fullClear();
        ioHandler.print(ioHandler.center("Please set your terminal to 120 x 15", 120, " "));
        ioHandler.print(TerminalColor.LIGHT_GREY.apply(ioHandler.center("[ Press ENTER to continue ]", 120, " ")));
        ioHandler.readLine(); 
        ioHandler.fullClear();
        visuals.showLogo();

        ioHandler.readLine();
        ioHandler.fullClear();
        
        game.ui.Menu menu = new game.ui.Menu(ioHandler);
        Subject chosenSubject = menu.subjectSelection();
        ioHandler.print("");
        PlayerGift playerGift = menu.selectSpecialty();
        boolean skip = menu.shouldSkip(ioHandler);
        String playerName = "";
        if (!skip){
            visuals.showSubjectHeader(chosenSubject.getDisplayName());
            visuals.showOpening();
            playerName = ioHandler.readLine();
        }
        entities.Player player = new entities.Player(playerName.isEmpty() ? "Academic Probation" : playerName, 100, playerGift);
        entities.Boss boss = new entities.Boss(attacks.question.QuoteBank.getBossName(chosenSubject),attacks.question.QuoteBank.getBossIntro(chosenSubject),100);
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
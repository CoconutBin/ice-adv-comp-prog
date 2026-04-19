import game.ui.TerminalColor;
import attacks.question.Subject;
import game.loop.Battle;
import game.setup.GameSetup;
import game.ui.Visuals;

public class App {

    public static void main(String[] args) {
        
        final game.io.IOHandler ioHandler = new game.io.IOHandler();
        Visuals visuals = new Visuals(ioHandler);
        
        ioHandler.fullClear();

        visuals.showLogo();

        ioHandler.readLine();
        ioHandler.fullClear();
        
        game.ui.Menu menu = new game.ui.Menu(ioHandler);
        Subject chosenSubject = menu.SubjectSelection();
        boolean skip = menu.shouldSkip(ioHandler);
        visuals.showSubjectHeader(chosenSubject.getDisplayName());
        if (!skip){
            visuals.showOpening();
        }
        else{
            ioHandler.printTyping("Name : ");
            ioHandler.inlinePrint(TerminalColor.CYAN.apply("--> "));
        }
        String playerName = ioHandler.readLine();
        entities.Player player = new entities.Player(playerName.isEmpty() ? "Academic Probation" : playerName, 100);
        entities.boss.Boss boss = new entities.boss.Boss(attacks.question.QuoteBank.getBossName(chosenSubject),attacks.question.QuoteBank.getBossIntro(chosenSubject),100);
        if (!skip){
            visuals.playPrologue(player, boss);
        }

        // Setup game state (register observers, initialize systems)
        GameSetup gameSetup = new GameSetup(player, boss, ioHandler);
        gameSetup.setupObservers();

        Battle battle = new Battle(ioHandler);
        battle.startLoop(player, boss, chosenSubject);
    }
}
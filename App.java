import attacks.question.Subject;
import game.loop.Battle;
import game.setup.GameSetup;
import game.ui.TerminalColor;
import game.ui.Visuals;

public class App {

    public static void main(String[] args) {
        
        final game.io.IOHandler ioHandler = new game.io.IOHandler();
        Visuals visuals = new Visuals(ioHandler);
        
        ioHandler.fullClear();
        ioHandler.print("Please set your terminal to 120 x 15");
        ioHandler.print(TerminalColor.LIGHT_GREY.apply("\n[ Press ENTER to continue]"));
        ioHandler.readLine(); 
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
        entities.Player player = new entities.Player(playerName.isEmpty() ? "Academic Probation" : playerName, 1);
        entities.boss.Boss boss = new entities.boss.Boss(attacks.question.QuoteBank.getBossName(chosenSubject),attacks.question.QuoteBank.getBossIntro(chosenSubject),1);
        if (!skip){
            visuals.playPrologue(player);     
        }
        else{
            ioHandler.clearTerminal();
        }
        visuals.playBossIntro(boss);
        ioHandler.print(TerminalColor.LIGHT_GREY.apply("\n[ Press ENTER to continue]"));
        ioHandler.readLine(); 
        ioHandler.clearTerminal();
        // Setup game state (register observers, initialize systems)
        GameSetup gameSetup = new GameSetup(player, boss, ioHandler);
        gameSetup.setupObservers();

        Battle battle = new Battle(ioHandler);
        battle.startLoop(player, boss, chosenSubject);
    }
}
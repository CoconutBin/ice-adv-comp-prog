import game.Battle;
import game.TerminalTools;
import game.Visuals;

public class App {

    public static void main(String[] args) {
        
        final game.IOHandler ioHandler = new game.IOHandler();
        
        TerminalTools.fullClear();

        Visuals.showLogo();

        ioHandler.readLine();
        TerminalTools.fullClear();
        
        game.Menu menu = new game.Menu(ioHandler);
        int choice = menu.SubjectSelection();
        boolean skip = menu.shouldSkip(ioHandler);
        Visuals.showSubjectHeader(menu.getSubjectName(choice));
        if (!skip){
            Visuals.showOpening();
        }
        else{
            TerminalTools.typing("Name : ");
            System.out.print(TerminalTools.CYAN + "--> " + TerminalTools.RESET);
        }
        String playerName = ioHandler.readLine();
        entities.Player player = new entities.Player(playerName.isEmpty() ? "Academic Probation" : playerName, 1);
        entities.boss.Boss boss = new entities.boss.Boss(attacks.question.QuoteBank.getBossName(choice),attacks.question.QuoteBank.getBossIntro(choice),1);
        if (!skip){
            Visuals.playPrologue(player, boss);
        }
        Battle battle = new Battle(ioHandler);
        battle.startLoop(player, boss, choice);
        game.GameEngine gameEngine = new game.GameEngine();

        gameEngine.initializeGame();
        gameEngine.startGameLoop();
    }
}
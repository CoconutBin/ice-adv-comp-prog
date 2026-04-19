import game.io.TerminalTools;
import game.loop.Battle;
import game.ui.Visuals;

public class App {

    public static void main(String[] args) {
        
        final game.io.IOHandler ioHandler = new game.io.IOHandler();
        
        TerminalTools.fullClear();

        Visuals.showLogo();

        ioHandler.readLine();
        TerminalTools.fullClear();
        
        game.ui.Menu menu = new game.ui.Menu(ioHandler);
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
    }
}
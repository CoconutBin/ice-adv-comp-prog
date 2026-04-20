package game.loop;

import attacks.question.Question;
import attacks.question.QuestionBank;
import attacks.question.Subject;
import entities.Player;
import entities.boss.Boss;
import game.io.IOHandler;
import game.ui.TerminalColor;
import game.ui.Visuals;
import java.util.Random;

public class Battle {
    private final IOHandler io;
    private final Random rand;
    private final Visuals visuals;

    public Battle(IOHandler io) {
        this.io = io;
        this.rand = new Random();
        this.visuals = new Visuals(io);
    }

    public void startLoop(Player player, Boss boss, Subject subject) {
        while (boss.getHp() > 0 && player.getHp() > 0) {
            
            // 1. Question Phase
            Question question = QuestionBank.getInstance().getUniqueQuestion(subject);
            String playerAnswer = question.askQuestion(io);
            boolean isCorrect = question.isCorrect(playerAnswer);
            
            // 2. Action Phase
            if (isCorrect) {
                handlePlayerStrike(player, boss, question.getAnswer());
            } else {
                handleBossCounter(player, boss, question.getAnswer());
            }
            
            if (!(boss.getHp() > 0 && player.getHp() > 0)){
                break;
            }
            io.print(TerminalColor.LIGHT_GREY.apply("\n[ Press ENTER to continue]"));
            io.readLine();
            io.clearTerminal();
        }
        io.wait(1000);
        io.clearTerminal();
        handleEndgame(player, boss);
    }

    private void handlePlayerStrike(Player player, Boss boss, String answer) {
        io.printTyping(TerminalColor.GREEN + "[!] CORRECT! The answer is: " + TerminalColor.YELLOW + answer + TerminalColor.GREEN + "\nPrepare your strike! " + TerminalColor.RESET);
        System.out.println("Striking [1] Head [2] Body [3] Legs");
        
        int aim = io.readInt();
        int weakPoint = rand.nextInt(3) + 1;
        int blockedPoint = (weakPoint % 3) + 1;

        if (aim == weakPoint) {
            io.printTyping(TerminalColor.YELLOW.apply("CRITICAL HIT! You found the weak spot!"));
            boss.updateHp(-10);
        } else if (aim == blockedPoint) {
            io.printTyping(TerminalColor.LIGHT_GREY.apply("Change your glasses, the boss is on the other side!"));
            boss.updateHp(0);
        } else {
            String part = (aim == 1 ? "Head" : aim == 2 ? "Body" : "Legs");
            io.printTyping(TerminalColor.CYAN.apply("Average strike to the " + part + "."));
            boss.updateHp(-5);
        }
    }

    private void handleBossCounter(Player player, Boss boss, String answer) {
        io.printTyping(TerminalColor.RED.apply("[X] WRONG! The answer is ") + TerminalColor.CYAN.apply(answer) + TerminalColor.RED.apply("\nThe boss counters! DODGE!"));
        System.out.println("Dodge to [1] Left [2] Right [3] Duck");
        
        int dodge = io.readInt();
        int safeZone = rand.nextInt(3) + 1;
        int trapZone = (safeZone % 3) + 1;

        if (dodge == safeZone) {
            io.printTyping(TerminalColor.GREEN.apply("PERFECT DODGE! You took no damage."));
            player.updateHp(0);
        } else if (dodge == trapZone) {
            io.printTyping(TerminalColor.RED.apply("??? You jumped right into the blade!"));
            player.updateHp(-10);
        } else {
            io.printTyping(TerminalColor.LIGHT_GREY.apply("A glancing blow. You took standard damage."));
            player.updateHp(-5);
        }
    }

    private void handleEndgame(Player player, Boss boss) {
        if (player.getHp() <= 0) {
            visuals.showDefeat(player, boss);
        } else {
            visuals.showVictory(player, boss);
        }
        System.exit(0);
    }
}
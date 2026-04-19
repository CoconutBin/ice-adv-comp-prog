package game;

import attacks.question.Question;
import attacks.question.QuestionBank;
import entities.Player;
import entities.boss.Boss;
import java.util.Random;

public class Battle {
    private final IOHandler io;
    private final Random rand;

    public Battle(IOHandler io) {
        this.io = io;
        this.rand = new Random();
    }

    public void startLoop(Player player, Boss boss, int choice) {
        while (boss.getHp() > 0 && player.getHp() > 0) {
            
            // 1. Question Phase
            Question question = QuestionBank.getInstance().getUniqueQuestion(choice);
            String playerAnswer = question.askQuestion(io);
            boolean isCorrect = question.isCorrect(playerAnswer);
            TerminalTools.clearTerminal();
            
            // 2. Action Phase
            if (isCorrect) {
                handlePlayerStrike(player, boss, question.getAnswer());
            } else {
                handleBossCounter(player, boss, question.getAnswer());
            }

            TerminalTools.wait(1000);
            TerminalTools.clearTerminal();
        }
        
        handleEndgame(player, boss);
    }

    private void handlePlayerStrike(Player player, Boss boss, String answer) {
        TerminalTools.typing(TerminalTools.GREEN + "[!] CORRECT! The answer is: " + TerminalTools.YELLOW + answer + TerminalTools.GREEN + "\nPrepare your strike! " + TerminalTools.RESET);
        System.out.println("Striking [1] Head [2] Body [3] Legs");
        
        int aim = io.readInt();
        int weakPoint = rand.nextInt(3) + 1;
        int blockedPoint = (weakPoint % 3) + 1;

        if (aim == weakPoint) {
            TerminalTools.typing(TerminalTools.YELLOW + "CRITICAL HIT! You found the weak spot!" + TerminalTools.RESET);
            boss.updateHp(-10);
        } else if (aim == blockedPoint) {
            TerminalTools.typing(TerminalTools.LIGHT_GREY + "Change your glasses, the boss is on the other side." + TerminalTools.RESET);
        } else {
            String part = (aim == 1 ? "Head" : aim == 2 ? "Body" : "Legs");
            TerminalTools.typing(TerminalTools.CYAN + "Average strike to the " + part + "." + TerminalTools.RESET);
            boss.updateHp(-5);
        }
        Visuals.displayStatus("boss", boss.getHp(), boss.getName());
    }

    private void handleBossCounter(Player player, Boss boss, String answer) {
        TerminalTools.typing(TerminalTools.RED + "[X] WRONG! The answer is " + TerminalTools.CYAN + answer + TerminalTools.RED + "\nThe boss counters! DODGE!" + TerminalTools.RESET);
        System.out.println("Dodge to [1] Left [2] Right [3] Duck");
        
        int dodge = io.readInt();
        int safeZone = rand.nextInt(3) + 1;
        int trapZone = (safeZone % 3) + 1;

        if (dodge == safeZone) {
            TerminalTools.typing(TerminalTools.GREEN + "PERFECT DODGE! You took no damage." + TerminalTools.RESET);
        } else if (dodge == trapZone) {
            TerminalTools.typing(TerminalTools.RED + "??? You jumped right into the blade!" + TerminalTools.RESET);
            player.updateHp(-10);
        } else {
            TerminalTools.typing(TerminalTools.LIGHT_GREY + "A glancing blow. You took standard damage." + TerminalTools.RESET);
            player.updateHp(-5);
        }
        Visuals.displayStatus("player", player.getHp(), player.getName());
    }

    private void handleEndgame(Player player, Boss boss) {
        if (player.getHp() <= 0) {
            Visuals.showDefeat(player, boss);
        } else {
            Visuals.showVictory(player, boss);
        }
        System.exit(0);
    }
}
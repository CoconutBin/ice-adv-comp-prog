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
            if (!isCorrect && 1 == player.getPath()) {
                io.printTyping(TerminalColor.CYAN.apply("[!] Your high Intelligence questions your answer."));
                playerAnswer = question.askQuestion(io);
                isCorrect = question.isCorrect(playerAnswer);
            }

            // 2. Action Phase
            if (isCorrect) {
                handlePlayerStrike(player, boss, question.getAnswer());
            } else {
                handleBossCounter(player, boss, question.getAnswer());
            }
            
            if (!(boss.getHp() > 0 && player.getHp() > 0)){
                break;
            }
            io.print(TerminalColor.LIGHT_GREY.apply("\n[ Press ENTER to continue ]"));
            io.readLine();
            io.clearTerminal();
        }
        io.wait(1000);
        io.clearTerminal();
        handleEndgame(player, boss, subject);
    }

    private void handlePlayerStrike(Player player, Boss boss, String answer) {
        io.printTyping(TerminalColor.GREEN.apply("[!] CORRECT! The answer is: ") + TerminalColor.YELLOW.apply(answer));
        io.wait(500);
        int DMG;
            switch (player.getPath()) {
                        case 1 -> {
                            DMG = 5;
                        }
                        case 2 -> {
                            DMG = 10;
                        }
                        case 3 -> {
                            DMG = 5;
                        }
                        default -> DMG = 5;
                    }
        int aim = -1;
        int weakPoint = rand.nextInt(3) + 1;
        int blockedPoint = (weakPoint % 3) + 1;
        if (3 == player.getPath()) {

            java.util.List<Integer> NormalZones = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 3));
            NormalZones.remove(Integer.valueOf(weakPoint));
            int revealedZone = NormalZones.get(new java.util.Random().nextInt(NormalZones.size()));
            String area = (revealedZone == 1 ? "Head" : revealedZone == 2 ? "Body" : "Legs");
            io.printTyping(TerminalColor.CYAN.apply("[!] Seeing that you looking super charming,\n" + boss.getName() +" decided to tell you that his weakpoint is not " + area + "."));
        }
        io.printTyping("Prepare your strike!");
        io.print("Striking [1] Head [2] Body [3] Legs");
        while (aim < 1 || aim > 3) {
            
            try {
                
                String input = io.readLine(); 
                aim = Integer.parseInt(input);
                
                if (aim < 1 || aim > 3) {
                    io.printTyping(TerminalColor.RED.apply("Invalid target! Focus your aim on 1, 2, or 3."));
                }
            } catch (NumberFormatException e) {
                // Catches "apple", empty strings, or symbols
                io.printTyping(TerminalColor.RED.apply("You hesitate! Enter a valid target NUMBER (1, 2, or 3)."));
                aim = -1; 
            }
        }


        if (aim == weakPoint) {
            io.printTyping(TerminalColor.YELLOW.apply("CRITICAL HIT! You found the weak spot!"));
            boss.updateHp(-2 * DMG);
        } else if (aim == blockedPoint) {
            io.printTyping(TerminalColor.LIGHT_GREY.apply(boss.getName() + " blocked your attack perfectly!"));
            boss.updateHp(0);
        } else {
            String part = (aim == 1 ? "Head" : aim == 2 ? "Body" : "Legs");
            io.printTyping(TerminalColor.RESET.apply("A strike to the " + part + "."));
            boss.updateHp(-1 * DMG);
        }
    }

    private void handleBossCounter(Player player, Boss boss, String answer) {
        io.printTyping(TerminalColor.RED.apply("[!] WRONG! The answer is ") + TerminalColor.CYAN.apply(answer));
        io.wait(500);
        int safeZone = rand.nextInt(3) + 1;
        int trapZone = (safeZone % 3) + 1;

        if (3 == player.getPath()) {

            java.util.List<Integer> dangerZones = new java.util.ArrayList<>(java.util.Arrays.asList(1, 2, 3));
            dangerZones.remove(Integer.valueOf(safeZone));
            int revealedZone = dangerZones.get(new java.util.Random().nextInt(dangerZones.size()));
            String direction = (revealedZone == 1 ? "left" : revealedZone == 2 ? "right" : "down");
            io.printTyping(TerminalColor.CYAN.apply("[!] Seeing that you looking super charming,\n" + boss.getName() +" decided to tell you that he's probably striking " + direction + "."));
        }
        int dodge = -1;
        io.printTyping("Prepare to dodge!");
        io.print("Dodge to [1] Left [2] Right [3] Duck");

        while (dodge < 1 || dodge > 3) {
            try {
    
                String input = io.readLine(); 
                dodge = Integer.parseInt(input);
                
                if (dodge < 1 || dodge > 3) {
                    io.printTyping(TerminalColor.RED.apply("That's not a dodge zone! Choose 1, 2, or 3."));
                }
            } catch (NumberFormatException e) {
                io.printTyping(TerminalColor.RED.apply("Panic makes you freeze! Enter a NUMBER (1, 2, or 3)."));
                dodge = -1;
            }
        }


        if (dodge == safeZone) {
            io.printTyping(TerminalColor.GREEN.apply("PERFECT DODGE!"));
            player.updateHp(0);
        } else if (dodge == trapZone) {
            io.printTyping(TerminalColor.RED.apply("??? You jumped into the blade!"));
            player.updateHp(-10);
        } else {
            io.printTyping(TerminalColor.RESET.apply("A glancing blow."));
            player.updateHp(-5);
        }
    }

    private void handleEndgame(Player player, Boss boss, Subject subject) {
        if (player.getHp() <= 0) {
            visuals.showDefeat(player, boss, subject);
        } else {
            visuals.showVictory(player, boss, subject);
        }
        System.exit(0);
    }
}
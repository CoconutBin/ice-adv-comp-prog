package game.loop;

import attacks.question.Question;
import attacks.question.QuestionBank;
import attacks.question.Subject;
import entities.Boss;
import entities.Player;
import game.io.IOHandler;
import game.ui.TerminalColor;
import game.ui.Visuals;
import java.util.Random;
import attacks.AttackResult;

public class Battle {
    private final IOHandler io = IOHandler.getInstance();
    private final Random rand;
    private final Visuals visuals;

    public Battle(Visuals visuals) {
        this.rand = new Random();
        this.visuals = visuals;
    }

    public void startLoop(Player player, Boss boss, Subject subject) {
        while (boss.getHp() > 0 && player.getHp() > 0) {

            // 1. Question Phase
            Question question = QuestionBank.getInstance().getUniqueQuestion(subject);
            String playerAnswer = question.askQuestion(io);
            boolean isCorrect = question.isCorrect(playerAnswer);
            if (!isCorrect && player.getPlayerGift().hasRetry()) {
                io.printTyping(TerminalColor.CYAN.apply("[!] The spirits above you question your choices, maybe reconsider?"));
                playerAnswer = question.askQuestion(io);
                isCorrect = question.isCorrect(playerAnswer);
            }

            // 2. Action Phase
            if (isCorrect) {
                handlePlayerStrike(player, boss, question.getAnswer());
            } else {
                handleBossCounter(player, boss, question.getAnswer());
            }

            if (!(boss.getHp() > 0 && player.getHp() > 0)) {
                break;
            }
            io.print(TerminalColor.LIGHT_GREY.apply("\n[ Press ENTER to continue ]\nㅤ"));
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
        BodyPart aimTarget = null;
        BodyPart weakPoint = BodyPart.getRandomPart(rand);
        BodyPart blockedPoint = BodyPart.getRandomPartExcluding(rand, weakPoint);
        if (player.getPlayerGift().hasCombatHints()) {
            io.printTyping(TerminalColor.CYAN.apply("[!] Seeing as you look quite charming, " + boss.getName()
                    + " has decided to tell you that their " + BodyPart.getRandomPartExcluding(rand, weakPoint) + " is not their weak point."));
        }
        io.printTyping("Prepare your strike!");
        String strikeMessage = "Striking";
        for (int i = 0; i < BodyPart.values().length; i++) {
            strikeMessage += " [" + (i+1) + "] " + BodyPart.values()[i];
        }
        io.print(strikeMessage);
        while (aimTarget == null) {
            try {
                String input = io.readLine();
                aimTarget = BodyPart.values()[Integer.parseInt(input)-1];
            } catch (NumberFormatException e) {
                io.printTyping(TerminalColor.RED.apply("You hesitated! Enter a valid target NUMBER (1, 2, or 3)."));
            } catch (ArrayIndexOutOfBoundsException e) {
                io.printTyping(TerminalColor.RED.apply("Invalid target! Focus your aim on 1, 2, or 3."));
            }
        }

        if (aimTarget == weakPoint) {
            io.printTyping(TerminalColor.YELLOW.apply("CRITICAL HIT! You found the weak spot!"));
            player.attack(boss, AttackResult.CRITICAL_HIT.getHitModifierWithBonus(player.getPlayerGift().getCritBonus()));
        } else if (aimTarget == blockedPoint) {
            io.printTyping(TerminalColor.LIGHT_GREY.apply(boss.getName() + " dodged your attack perfectly!"));
            player.attack(boss, AttackResult.DODGE.getBaseHitModifier());
        } else {
            io.printTyping(TerminalColor.RESET.apply("A strike to the " + aimTarget + "!"));
            player.attack(boss, AttackResult.HIT.getBaseHitModifier());
        }
    }

    private void handleBossCounter(Player player, Boss boss, String answer) {
        io.printTyping(TerminalColor.RED.apply("[!] WRONG! The answer is ") + TerminalColor.CYAN.apply(answer));
        io.wait(500);
        DodgeDirection safeZone = DodgeDirection.getRandomDirection(rand);
        DodgeDirection trapZone = DodgeDirection.getRandomDirectionExcluding(rand, safeZone);

        if (player.getPlayerGift().hasCombatHints()) {
            io.printTyping(TerminalColor.CYAN.apply("[!] Seeing as you look quite charming,\n" + boss.getName()
                    + " has decided to tell you that their strike will hit " + trapZone + " the hardest."));
        }
        DodgeDirection dodgeDirection = null;
        io.printTyping("Prepare to dodge!");
        String dodgeMessage = "Dodge to";
        for (int i = 0; i < DodgeDirection.values().length; i++) {
            dodgeMessage += " [" + (i+1) + "] " + DodgeDirection.values()[i];
        }
        io.print(dodgeMessage);

        while (dodgeDirection == null) {
            try {
                String input = io.readLine();
                int dodge = Integer.parseInt(input) - 1;
                dodgeDirection = DodgeDirection.values()[dodge];
            } catch (NumberFormatException e) {
                io.printTyping(TerminalColor.RED.apply("Panic makes you freeze! Enter a NUMBER (1, 2, or 3)."));
            } catch (ArrayIndexOutOfBoundsException e) {
                io.printTyping(TerminalColor.RED.apply("Invalid dodge! Focus on dodging to 1, 2, or 3."));
            }
        }

        if (dodgeDirection == safeZone) {
            io.printTyping(TerminalColor.GREEN.apply("PERFECT DODGE!"));
            boss.attack(player, AttackResult.DODGE.getBaseHitModifier());
        } else if (dodgeDirection == trapZone) {
            io.printTyping(TerminalColor.RED.apply("??? You jumped into the blade!"));
            boss.attack(player, AttackResult.CRITICAL_HIT.getHitModifierWithBonus(-player.getPlayerGift().getCritDamageReduction()));
        } else {
            io.printTyping(TerminalColor.RESET.apply("A glancing blow."));
            boss.attack(player, AttackResult.HIT.getBaseHitModifier());
        }
    }

    private void handleEndgame(Player player, Boss boss, Subject subject) {
        if (player.getHp() <= 0) {
            visuals.showDefeat(player, boss, subject);
        } else {
            visuals.showVictory(player, boss, subject);
        }
    }
}

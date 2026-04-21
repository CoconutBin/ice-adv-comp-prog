package game.loop;

import attacks.question.Question;
import attacks.question.QuestionBank;
import attacks.question.Subject;
import entities.Boss;
import entities.Player;
import entities.PlayerGift;
import game.io.IOHandler;
import game.ui.TerminalColor;
import game.ui.Visuals;
import java.util.Random;
import attacks.AttackResult;

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
            if (!isCorrect && PlayerGift.INTELLIGENCE == player.getPlayerGift()) {
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
        BodyPart aimTarget = null;
        BodyPart weakPoint = BodyPart.getRandomPart(rand);
        BodyPart blockedPoint = BodyPart.getRandomPartExcluding(rand, weakPoint);
        if (PlayerGift.CHARISMA == player.getPlayerGift()) {
            io.printTyping(TerminalColor.CYAN.apply("[!] Seeing as you look quite charming,\n" + boss.getName()
                    + " has decided to tell you that their " + BodyPart.getRandomPartExcluding(rand, weakPoint) + " is not their weak point."));
        }
        io.printTyping("Prepare your strike!");
        String strikeMessage = "Striking";
        for(BodyPart part : BodyPart.values()) {
            strikeMessage += " [" + part.getId() + "] " + part;
        }
        io.print(strikeMessage);
        while (aimTarget == null) {
            try {

                String input = io.readLine();
                aimTarget = BodyPart.fromId(Integer.parseInt(input));

            } catch (NumberFormatException e) {
                // Catches "apple", empty strings, or symbols or things that can't be parsed into an int;
                io.printTyping(TerminalColor.RED.apply("You hesitated! Enter a valid target NUMBER (1, 2, or 3)."));

            } catch (IllegalArgumentException e) {

                io.printTyping(TerminalColor.RED.apply("Invalid target! Focus your aim on 1, 2, or 3."));

            }
        }

        if (aimTarget == weakPoint) {
            io.printTyping(TerminalColor.YELLOW.apply("CRITICAL HIT! You found the weak spot!"));
            player.attack(boss, AttackResult.CRITICAL_HIT.getHitModifierWithBonus(PlayerGift.INTELLIGENCE == player.getPlayerGift() ? 0.25 : 0));
        } 
        else if (aimTarget == blockedPoint) {
            io.printTyping(TerminalColor.LIGHT_GREY.apply(boss.getName() + " dodged your attack perfectly!"));
            player.attack(boss, AttackResult.DODGE.getBaseHitModifier());
        } 
        else {
            io.printTyping(TerminalColor.RESET.apply("A strike to the " + aimTarget + "!"));
            player.attack(boss, AttackResult.HIT.getBaseHitModifier());
        }
    }

    private enum BodyPart {
        HEAD(1, "Head"), BODY(2, "Body"), LEGS(3, "Legs");

        private final int id;
        private String name;

        BodyPart(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String toString() {
            return name;
        }

        public static BodyPart fromId(int id) {
            for (BodyPart part : values()) {
                if (part.getId() == id) {
                    return part;
                }
            }
            throw new IllegalArgumentException("Invalid BodyPart ID: " + id);
        }

        public static BodyPart getRandomPart(Random rand) {
            return values()[rand.nextInt(values().length)];
        }

        public static BodyPart getRandomPartExcluding(Random rand, BodyPart exclude) {
            BodyPart part = exclude;
            while (part == exclude){
                part = values()[rand.nextInt(values().length)];
            };
            return part;
        }
    }

    private void handleBossCounter(Player player, Boss boss, String answer) {
        io.printTyping(TerminalColor.RED.apply("[!] WRONG! The answer is ") + TerminalColor.CYAN.apply(answer));
        io.wait(500);
        DodgeDirection safeZone = DodgeDirection.getRandomDirection(rand);
        DodgeDirection trapZone = DodgeDirection.getRandomDirectionExcluding(rand, safeZone);

        if (PlayerGift.CHARISMA == player.getPlayerGift()) {
            io.printTyping(TerminalColor.CYAN.apply("[!] Seeing as you look quite charming,\n" + boss.getName()
                    + " has decided to tell you that their strike will hit " + trapZone + " the hardest."));
        }
        DodgeDirection dodgeDirection = null;
        io.printTyping("Prepare to dodge!");
        String dodgeMessage = "Dodge to";
        for(DodgeDirection dir : DodgeDirection.values()) {
            dodgeMessage += " [" + dir.getId() + "] " + dir;
        }
        io.print(dodgeMessage);

        while (dodgeDirection == null) {
            try {
                
                String input = io.readLine();
                int dodge = Integer.parseInt(input);
                dodgeDirection = DodgeDirection.fromId(dodge);

            } catch (NumberFormatException e) {
                io.printTyping(TerminalColor.RED.apply("Panic makes you freeze! Enter a NUMBER (1, 2, or 3)."));
            } catch (IllegalArgumentException e){
                io.printTyping(TerminalColor.RED.apply("Invalid dodge! Focus on dodging to 1, 2, or 3."));
            }
        }

        if (dodgeDirection == safeZone) {
            io.printTyping(TerminalColor.GREEN.apply("PERFECT DODGE!"));
            boss.attack(player, AttackResult.DODGE.getBaseHitModifier());
        } else if (dodgeDirection == trapZone) {
            io.printTyping(TerminalColor.RED.apply("??? You jumped into the blade!"));
            boss.attack(player, AttackResult.CRITICAL_HIT.getHitModifierWithBonus(PlayerGift.INTELLIGENCE == player.getPlayerGift() ? -0.5 : 0));
        } else {
            io.printTyping(TerminalColor.RESET.apply("A glancing blow."));
            boss.attack(player, AttackResult.HIT.getBaseHitModifier());
        }
    }

    private enum DodgeDirection {
        LEFT(1), RIGHT(2), DUCK(3);

        private final int id;

        DodgeDirection(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static DodgeDirection fromId(int id) {
            for (DodgeDirection dir : values()) {
                if (dir.getId() == id) {
                    return dir;
                }
            }
            throw new IllegalArgumentException("Invalid DodgeDirection ID: " + id);
        }

        public static DodgeDirection getRandomDirection(Random rand) {
            return values()[rand.nextInt(values().length)];
        }

        public static DodgeDirection getRandomDirectionExcluding(Random rand, DodgeDirection exclude) {
            DodgeDirection dir = exclude;
            while (dir == exclude){
                dir = values()[rand.nextInt(values().length)];
            };
            return dir;
        }
    }

    private void handleEndgame(Player player, Boss boss, Subject subject) {
        if (player.getHp() <= 0) {
            visuals.showDefeat(player, boss, subject);
        } else {
            visuals.showVictory(player, boss, subject);
        }
        return;
    }
}
package game;

import entities.Player;
import entities.boss.Boss;

public class GameEngine {
    private Player player = new Player("Player", 50);
    private Boss boss = new Boss(100);
    private IOHandler ioHandler = new IOHandler();

    // If we manage to get persistance then we could skip this call
    public void initializeGame() {
        ioHandler.print("Hello brave adventurer! What is your name?");
        String playerName = ioHandler.readLine();

        if (!playerName.isEmpty()) {
            player.setName(playerName);
        }

        ioHandler.print("Nice to meet you, " + player.getName() + "!");
        ioHandler.print("You are now ready for your adventure, " + player.getName() + "!");

        GameSetup gameSetup = new GameSetup(player, boss, ioHandler);
        gameSetup.initializeGame();
    }

    public void startGameLoop() {
        while (boss.getHp() > 0 && player.getHp() > 0) {

            attacks.question.Question question = attacks.question.QuestionBank.getInstance().getRandomQuestion();
            String playerAnswer = question.askQuestion(ioHandler);
            boolean isCorrect = question.isCorrect(playerAnswer);

            ioHandler.clearTerminal();

            if (isCorrect) {
                ioHandler.print(player.getName() + " is so smart! The answer is " + question.getAnswer() + ".\n");
                player.attack(boss);
                ioHandler.print("Boss HP: " + boss.getHp());
            } else {
                ioHandler.print(
                player.getName() + " is dumb as FUCK! The correct answer was " + question.getAnswer() + ".\n");
                boss.attack(player);
                ioHandler.print("Your HP: " + player.getHp());
            }
        }
    }
}

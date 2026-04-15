public class App {
    public static void main(String[] args) {
        final game.IOHandler ioHandler = new game.IOHandler();
        
        entities.Boss boss = new entities.Boss(100);

        ioHandler.print("Hello brave adventurer! What is your name?");
    
        String playerName = ioHandler.readLine();
        entities.Player player = new entities.Player(playerName.isEmpty() ? "Player" : playerName, 50);
        
        ioHandler.print("Nice to meet you, " + player.getName() + "!");
        ioHandler.print("You are now ready for your adventure, " + player.getName() + "!");


        while (boss.getHp() > 0 && player.getHp() > 0) {

            attacks.question.Question question = attacks.question.QuestionBank.getInstance().getRandomQuestion();
            String playerAnswer = question.askQuestion(ioHandler);
            boolean isCorrect = question.isCorrect(playerAnswer);
            
            ioHandler.clearTerminal();

            if (isCorrect) {
                ioHandler.print(player.getName() + " is so smart! The answer is " + question.getAnswer() + ".\n");
                boss.updateHp(-Math.random() * 7);
                ioHandler.print("Boss HP: " + boss.getHp());
            }
            else {
                ioHandler.print(player.getName() + " is dumb as FUCK! The correct answer was " + question.getAnswer() + ".\n");
                player.updateHp(-Math.random() * 7);
                ioHandler.print("Your HP: " + player.getHp());
            }
        }

        if(player.getHp() <= 0) ioHandler.print("wow you're dead");
        if(boss.getHp() <= 0) ioHandler.print("wow boss dead");
    }
}

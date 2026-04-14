public class App {
    public static void main(String[] args) {
        final game.IOHandler ioHandler = new game.IOHandler();
        
        entities.Boss boss = new entities.Boss(100);

        //TODO: handle case when player doesnt write name
        ioHandler.print("Hello brave adventurer! What is your name?");
        entities.Player player = new entities.Player(ioHandler.readLine(), 50);
        
        ioHandler.print("Nice to meet you, " + player.getName() + "!");
        ioHandler.print("You are now ready for your adventure, " + player.getName() + "!");


        while (boss.getHp() > 0 && player.getHp() > 0) {
            final attacks.question.Question[] questions = attacks.question.QuestionBank.questions;
            attacks.question.Question question = questions[(int) (Math.random() * questions.length)];

            String playerAnswer = question.askQuestion(ioHandler);
            boolean isCorrect = question.isCorrect(playerAnswer);
            
            if (isCorrect) {
                ioHandler.print(player.getName() + " is so smart! The answer is " + question.getAnswer() + ".\n");
            }
            else {
                 ioHandler.print(player.getName() + " is dumb as FUCK! The correct answer was " + question.getAnswer() + ".\n");
            }
        }
    }
}

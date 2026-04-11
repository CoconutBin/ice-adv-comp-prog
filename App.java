public class App {
    public static void main(String[] args) {
        final game.IOHandler ioHandler = new game.IOHandler();


        ioHandler.print("Hello brave adventurer! What is your name?");
        String name = ioHandler.readLine();
        ioHandler.print("Nice to meet you, " + name + "!");
        entities.Player player = new entities.Player(name);
        entities.Boss boss = new entities.Boss();
        ioHandler.print("You are now ready for your adventure, " + name + "!");

        while (boss.getHp() > 0 && player.getHp() > 0) {
            final attacks.question.Question[] questions = attacks.question.QuestionBank.questions;
            attacks.question.Question question = questions[(int) (Math.random() * questions.length)];

            question.askQuestion(ioHandler);
        }
    }
}

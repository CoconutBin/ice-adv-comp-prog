package attacks.question.strategies;

import game.IOHandler;

public class WrittenQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, String answer, IOHandler ioHandler) {
        ioHandler.print(question);
        ioHandler.print("Write your answer below:");
        return ioHandler.readLine();
    }

    @Override
    public boolean isCorrect(String question, String[] options, String answer, String player_answer) {
        return answer.equals(player_answer);
    }
}

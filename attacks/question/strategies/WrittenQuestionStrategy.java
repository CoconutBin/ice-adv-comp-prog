package attacks.question.strategies;

import attacks.question.Question;
import game.IOHandler;

public class WrittenQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(Question question, IOHandler ioHandler) {
        ioHandler.print(question.getQuestion());
        ioHandler.print("Write your answer below:");
        return ioHandler.readLine();
    }

    @Override
    public boolean processAnswer(Question question, String scannerInput) {
        return question.getAnswer().equals(scannerInput);
    }
}

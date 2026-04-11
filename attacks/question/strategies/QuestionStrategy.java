package attacks.question.strategies;

import attacks.question.Question;
import game.IOHandler;

public interface QuestionStrategy {
    abstract String askQuestion(Question question, IOHandler ioHandler);
    abstract boolean processAnswer(Question question, String answer);
}
package attacks.question.strategies;

import attacks.question.Question;
import game.IOHandler;

public interface QuestionStrategy {
    String askQuestion(Question question, IOHandler ioHandler);
    //TODO: handle case when answer is invalid
    boolean isCorrect(Question question, String player_answer);
}
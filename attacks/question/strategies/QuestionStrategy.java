package attacks.question.strategies;

import game.IOHandler;

public interface QuestionStrategy {
    String askQuestion(String question, String[] options, IOHandler ioHandler);
    //TODO: handle case when answer is invalid
    boolean isCorrect(String question, String[] options, String answer, String playerAnswer);
}
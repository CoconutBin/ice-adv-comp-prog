package attacks.question.strategies;

import game.io.IOHandler;

public interface QuestionStrategy {
    String askQuestion(String question, String[] options, IOHandler ioHandler);
    boolean isCorrect(String question, String[] options, String answer, String playerAnswer);
}
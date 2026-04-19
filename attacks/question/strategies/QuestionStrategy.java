package attacks.question.strategies;

import game.io.IOHandler;

public interface QuestionStrategy {
    String askQuestion(String question, String[] options, IOHandler ioHandler);
    //I think it's done.
    boolean isCorrect(String question, String[] options, String answer, String playerAnswer);
}
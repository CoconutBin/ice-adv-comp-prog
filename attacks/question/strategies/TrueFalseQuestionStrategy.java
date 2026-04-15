package attacks.question.strategies;

import game.IOHandler;

public class TrueFalseQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, IOHandler ioHandler) {
        ioHandler.print(question);
        ioHandler.print("True or False?");
        return ioHandler.readLine();
    }

    @Override
    public boolean isCorrect(String question, String[] options, String answer, String playerAnswer) {
        return (playerAnswer.toLowerCase()).charAt(0) == (answer.toLowerCase()).charAt(0);
    }
}

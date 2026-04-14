package attacks.question.strategies;

import attacks.question.Question;
import game.IOHandler;

public class TrueFalseQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(Question question, IOHandler ioHandler) {
        ioHandler.print(question.getQuestion());
        ioHandler.print("True or False?");
        return ioHandler.readLine();
    }

    @Override
    public boolean isCorrect(Question question, String player_answer) {
        return (player_answer.toLowerCase()).charAt(0) == (question.getAnswer().toLowerCase()).charAt(0);
    }
}

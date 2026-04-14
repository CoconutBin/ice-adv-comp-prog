package attacks.question.strategies;

import attacks.question.Question;
import game.IOHandler;

public class MultipleChoiceQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(Question question, IOHandler ioHandler) {
        ioHandler.print(question.getQuestion());
        String[] options = question.getOptions();
        for(int i = 0; i < options.length; i++) {
            ioHandler.print((i + 1) + ". " + options[i]);
        }
        return ioHandler.readLine();
    }

    @Override
    public boolean isCorrect(Question question, String player_answer) {
        try {
            int answer = Integer.parseInt(player_answer);
            return question.getAnswer().equals(question.getOptions()[answer - 1]);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

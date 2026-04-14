package attacks.question.strategies;

import game.IOHandler;

public class MultipleChoiceQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, String answer, IOHandler ioHandler) {
        ioHandler.print(question);
        for(int i = 0; i < options.length; i++) {
            ioHandler.print((i + 1) + ". " + options[i]);
        }
        return ioHandler.readLine();
    }

    @Override
    public boolean isCorrect(String question, String[] options, String answer, String player_answer) {
        try {
            int player_answer_index = Integer.parseInt(player_answer);
            return answer.equals(options[player_answer_index - 1]);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

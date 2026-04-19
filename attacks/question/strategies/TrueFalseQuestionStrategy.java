package attacks.question.strategies;

import game.io.IOHandler;
import game.ui.TerminalColor;

public class TrueFalseQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, IOHandler ioHandler) {
        String input;
        
        while (true) {
            ioHandler.printTyping("\n" + question);
            ioHandler.print(" (True / False)");
            ioHandler.inlinePrint("\n--> ");
            input = ioHandler.readLine().trim().toLowerCase();

            // Check if it's empty or doesn't start with T or F
            if (!input.isEmpty() && (input.startsWith("t") || input.startsWith("f"))) {
                return input;
            }

            ioHandler.print(TerminalColor.RED.apply("Invalid input. Please type 'True' or 'False'."));
        }
    }

    @Override
    public boolean isCorrect(String question, String[] options, String answer, String playerAnswer) {
        // blank string, return false
        if (playerAnswer == null || playerAnswer.isEmpty()) return false;
        
        return playerAnswer.toLowerCase().charAt(0) == answer.toLowerCase().charAt(0);
    }
}
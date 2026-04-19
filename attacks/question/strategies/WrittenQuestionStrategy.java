package attacks.question.strategies;

import game.io.IOHandler;
import game.ui.TerminalColor;

public class WrittenQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, IOHandler ioHandler) {
        String input;
        
        while (true) {
            ioHandler.printTyping("\n" + question);
            ioHandler.print("Write your answer below");
            ioHandler.inlinePrint("--> ");
            
            input = ioHandler.readLine();
            
            // Validation: Don't allow empty or purely whitespace answers
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }

            ioHandler.print(TerminalColor.RED.apply(" You must type an answer to attack!"));
        }
    }

    @Override
    public boolean isCorrect(String question, String[] options, String answer, String playerAnswer) {
        if (playerAnswer == null) return false;
        
        // Use equalsIgnoreCase and trim to be fair to the player
        // Otherwise "Derivative" != "derivative"
        return answer.trim().equalsIgnoreCase(playerAnswer.trim());
    }
}
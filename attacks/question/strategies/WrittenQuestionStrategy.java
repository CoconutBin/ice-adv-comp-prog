package attacks.question.strategies;

import game.io.IOHandler;
import game.ui.TerminalColor;

public class WrittenQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, IOHandler ioHandler) {
        String input;
        ioHandler.printTyping(question);
        ioHandler.print("Write your answer below");
        
        while (true) {
            ioHandler.inlinePrint("--> ");
            
            input = ioHandler.readLine();
            
            // Validation: Don't allow empty or purely whitespace answers
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }

            ioHandler.print(TerminalColor.RED.apply(" Please type something, even if you don't know the answer."));
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
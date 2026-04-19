package attacks.question.strategies;

import game.IOHandler;

public class TrueFalseQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, IOHandler ioHandler) {
        String input;
        
        while (true) {
            ioHandler.print("\n" + question);
            ioHandler.print(" (True / False)");
            System.out.print("\n--> ");
            input = ioHandler.readLine().trim().toLowerCase();

            // Check if it's empty or doesn't start with T or F
            if (!input.isEmpty() && (input.startsWith("t") || input.startsWith("f"))) {
                return input;
            }

            ioHandler.print("\u001B[31m[!] Invalid input. Please type 'True' or 'False'.\u001B[0m");
        }
    }

    @Override
    public boolean isCorrect(String question, String[] options, String answer, String playerAnswer) {
        // blank string, return false
        if (playerAnswer == null || playerAnswer.isEmpty()) return false;
        
        return playerAnswer.toLowerCase().charAt(0) == answer.toLowerCase().charAt(0);
    }
}
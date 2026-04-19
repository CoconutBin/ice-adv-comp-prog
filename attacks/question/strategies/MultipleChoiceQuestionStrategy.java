package attacks.question.strategies;
import game.io.IOHandler;
import game.ui.TerminalColor;

public class MultipleChoiceQuestionStrategy implements QuestionStrategy {

    @Override
    public String askQuestion(String question, String[] options, IOHandler ioHandler) {
        String input;
        int choice;

        while (true) {
            ioHandler.printTyping("\n" + question);
            for (int i = 0; i < options.length; i++) {
                ioHandler.print((i + 1) + ". " + options[i]);
            }
            
            ioHandler.inlinePrint("--> ");
            input = ioHandler.readLine().trim();

            try {
                choice = Integer.parseInt(input);
                
                if (choice >= 1 && choice <= options.length) {
                    return input; 
                } else {
                    ioHandler.print("\u001B[31m[!] Out of bounds! Please pick 1 through " + options.length + ".\u001B[0m");
                }
            } catch (NumberFormatException e) {
                ioHandler.print(TerminalColor.RED.apply("[!] Invalid input. Please enter the NUMBER of your choice."));
            }
        }
    }

    @Override
    public boolean isCorrect(String question, String[] options, String answer, String playerAnswer) {

        try {
            int player_answer_index = Integer.parseInt(playerAnswer);
            return answer.equals(options[player_answer_index - 1]);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
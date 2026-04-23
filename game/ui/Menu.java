package game.ui;

import attacks.question.Subject;
import entities.PlayerGift;
import game.io.IOHandler;

public class Menu {
    private final IOHandler io = IOHandler.getInstance();

    public boolean shouldSkip() {
        io.print(TerminalColor.LIGHT_GREY.apply("\n[ Press 'x' to skip intro]"));
        io.inlinePrint(TerminalColor.CYAN.apply("--> "));
        String input = io.readLine();
        return input.equalsIgnoreCase("x");
    }

    public PlayerGift selectSpecialty() {
        io.print(TerminalColor.YELLOW.apply(io.center(" PICK YOUR GIFT ", 120, "=")));
        for(int i = 0; i < PlayerGift.values().length; i++) {
            PlayerGift gift = PlayerGift.values()[i];
            io.print(TerminalColor.PURPLE.apply("[" + (i+1) + "]") + " " + gift + " " + "(" + gift.getDescription() + ")");
        }
        io.print(TerminalColor.YELLOW.apply(io.center("", 120, "=")));

        while (true) {
            io.inlinePrint("--> ");
            try {
                String input = io.readLine();
                int choice = Integer.parseInt(input) - 1;
                return PlayerGift.values()[choice];
            } catch (NumberFormatException e) {
                io.print("Invalid input. Pick a number.");
            } catch (ArrayIndexOutOfBoundsException e) {
                io.print("Pick 1, 2, or 3!");
            }
        }
    }

    public Subject subjectSelection() {
        io.print(TerminalColor.YELLOW.apply(io.center(" SELECT YOUR SUBJECT ", 120, "=")));
        
        for (int i = 0; i < Subject.values().length; i++) {
            io.print(TerminalColor.PURPLE.apply("[" + (i + 1) + "] ") + Subject.values()[i].getDisplayName());
            io.wait(100);
        }
        io.print(TerminalColor.YELLOW.apply(io.center("", 120, "=")));

        while (true) {
            io.inlinePrint("\nEnter subject number: ");
            
            try {
                String input = io.readLine();             
                int choice = Integer.parseInt(input) - 1;
                return Subject.values()[choice]; 
                
            } catch (NumberFormatException e) {
                io.printTyping(TerminalColor.RED.apply("Error: Please enter a valid NUMBER."));
            } catch (ArrayIndexOutOfBoundsException e) {
                io.printTyping(TerminalColor.RED.apply("Invalid choice! Pick a number between 1 and " + Subject.values().length + "."));
            }
        }
    }
}
